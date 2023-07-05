package com.abcfitness.securedoc.export.service;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Transactional( readOnly = true )
@Service
public class SecureDocService {
  private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(120);

  private final WebClient webClient;

  public SecureDocService(WebClient webClient) {
    this.webClient = webClient;
  }

  public ByteArrayInputStream downloadDocument(String clubNumber, String documentNumber) {
    final String dataBuffer =  webClient
            .get()
            .uri("/storage/fede3f30f864a1f979d2bf0/2017/10/file-example_PDF_1MB.pdf")
            .retrieve()
            .bodyToMono(String.class)
            .block(REQUEST_TIMEOUT);

    try {
      return new ByteArrayInputStream(dataBuffer.getBytes("US-ASCII"));
    } catch (Exception e) {
      return new ByteArrayInputStream(dataBuffer.getBytes());
    }
  }
}