package com.capgemini.urlshortener.service.impl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capgemini.urlshortener.dto.ShortenUrlRequest;
import com.capgemini.urlshortener.dto.UrlResponse;
import com.capgemini.urlshortener.entity.UrlMapping;
import com.capgemini.urlshortener.exception.ResourceNotFoundException;
import com.capgemini.urlshortener.repository.UrlMappingRepository;
import com.capgemini.urlshortener.service.UrlMappingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlMappingServiceImpl implements UrlMappingService {

    private final UrlMappingRepository repository;

    private static final String CHAR_POOL =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private static final int SHORT_CODE_LENGTH = 6;

    private String generateShortCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SHORT_CODE_LENGTH; i++) {
            sb.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }

        return sb.toString();
    }

    private String generateUniqueShortCode() {
        String shortCode;

        do {
            shortCode = generateShortCode();
        } while (repository.existsByShortCode(shortCode));

        return shortCode;
    }

    @Override
    public UrlResponse shortenUrl(ShortenUrlRequest request) {

        String shortCode = generateUniqueShortCode();

        UrlMapping mapping = UrlMapping.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .clickCount(0L)
                .build();

        repository.save(mapping);

        return UrlResponse.builder()
                .originalUrl(mapping.getOriginalUrl())
                .shortCode(mapping.getShortCode())
                .clickCount(mapping.getClickCount())
                .build();
    }

    @Override
    public String getOriginalUrl(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found"));

        mapping.setClickCount(mapping.getClickCount() + 1);
        repository.save(mapping);

        return mapping.getOriginalUrl();
    }

    @Override
    public UrlResponse getUrlStats(String shortCode) {

        UrlMapping mapping = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new RuntimeException("Short code not found"));

        return UrlResponse.builder()
                .originalUrl(mapping.getOriginalUrl())
                .shortCode(mapping.getShortCode())
                .clickCount(mapping.getClickCount())
                .build();
    }

    @Override
    public List<UrlResponse> getAllUrls() {
        return repository.findAll()
                .stream()
                .map(m -> UrlResponse.builder()
                        .originalUrl(m.getOriginalUrl())
                        .shortCode(m.getShortCode())
                        .clickCount(m.getClickCount())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByShortCode(String shortCode) {
        UrlMapping mapping = repository.findByShortCode(shortCode)
        		.orElseThrow(() -> new ResourceNotFoundException("Short code not found"));

        repository.delete(mapping);
    }

    @Override
    public List<UrlResponse> getTopUrls() {
        return repository.findTop5ByOrderByClickCountDesc()
                .stream()
                .map(m -> UrlResponse.builder()
                        .originalUrl(m.getOriginalUrl())
                        .shortCode(m.getShortCode())
                        .clickCount(m.getClickCount())
                        .build())
                .collect(Collectors.toList());
    }
}