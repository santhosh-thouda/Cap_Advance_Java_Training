package com.capgemini.urlshortener.controller;

import com.capgemini.urlshortener.dto.ShortenUrlRequest;
import com.capgemini.urlshortener.dto.UrlResponse;
import com.capgemini.urlshortener.service.UrlMappingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UrlMappingController {

    private final UrlMappingService service;

    // 1️⃣ POST /api/shorten
    @PostMapping("/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(
            @Valid @RequestBody ShortenUrlRequest request) {

        UrlResponse response = service.shortenUrl(request);
        return ResponseEntity.ok(response);
    }

    // 2️⃣ GET /api/{shortCode}
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String originalUrl = service.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();
    }

    // 3️⃣ GET /api/stats/{shortCode}
    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<UrlResponse> getStats(
            @PathVariable String shortCode) {

        return ResponseEntity.ok(service.getUrlStats(shortCode));
    }

    // 4️⃣ GET /api/urls
    @GetMapping("/urls")
    public ResponseEntity<List<UrlResponse>> getAllUrls() {
        return ResponseEntity.ok(service.getAllUrls());
    }

    // 5️⃣ DELETE /api/{shortCode}
    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> delete(
            @PathVariable String shortCode) {

        service.deleteByShortCode(shortCode);
        return ResponseEntity.noContent().build();
    }

    // 6️⃣ GET /api/top
    @GetMapping("/top")
    public ResponseEntity<List<UrlResponse>> getTopUrls() {
        return ResponseEntity.ok(service.getTopUrls());
    }
}