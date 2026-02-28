package com.capgemini.urlshortener.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ShortenUrlRequest {

    @NotBlank(message = "Original URL cannot be empty")
    private String originalUrl;
}