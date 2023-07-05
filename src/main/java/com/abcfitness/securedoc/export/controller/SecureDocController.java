package com.abcfitness.securedoc.export.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.abcfitness.securedoc.export.service.SecureDocService;

import java.io.IOException;

@Slf4j
@Validated
@RestController
@RequestMapping("/secdoc")
@RequiredArgsConstructor@Controller
public class SecureDocController {

  public static final String CONTENT_DISPOSITION = "attachment; file-name=";
  public static final String CONTENT_TYPE = "application/octet-stream";

  @Autowired
  private SecureDocService fileService;

  @GetMapping("/download-document")
  // @PreAuthorize( "hasAuthority('secure-doc-export:read') || hasAuthority('secure-doc-export:client-read')" )
  public ResponseEntity<Resource> downloadDocument(
          @RequestParam String clubNumber,
          @RequestParam String documentNumber) throws IOException {
    String filename = clubNumber + "-" + documentNumber + ".tiff";
    InputStreamResource file = new InputStreamResource(
              fileService.downloadDocument(clubNumber, documentNumber));

    return ResponseEntity.ok()
              .header(HttpHeaders.CONTENT_DISPOSITION, CONTENT_DISPOSITION + filename)
              .contentType(MediaType.parseMediaType(CONTENT_TYPE))
              .body(file);
  }
}