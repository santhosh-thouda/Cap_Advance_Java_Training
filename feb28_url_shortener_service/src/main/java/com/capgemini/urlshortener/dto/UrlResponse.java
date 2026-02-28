package com.capgemini.urlshortener.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlResponse {

    private String originalUrl;
    private String shortCode;
    private Long clickCount;
}