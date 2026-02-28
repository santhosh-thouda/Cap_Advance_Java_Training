package com.capgemini.urlshortener.service;

import com.capgemini.urlshortener.dto.ShortenUrlRequest;
import com.capgemini.urlshortener.dto.UrlResponse;

import java.util.List;

public interface UrlMappingService {

    UrlResponse shortenUrl(ShortenUrlRequest request);

    String getOriginalUrl(String shortCode);

    UrlResponse getUrlStats(String shortCode);

    List<UrlResponse> getAllUrls();

    void deleteByShortCode(String shortCode);

    List<UrlResponse> getTopUrls();
}