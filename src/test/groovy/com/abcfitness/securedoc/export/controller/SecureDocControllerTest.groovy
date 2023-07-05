package com.abcfitness.securedoc.export.controller

import com.abcfitness.securedoc.export.service.SecureDocService
import org.mockito.Mock
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import java.time.LocalDate

import static org.mockito.ArgumentMatchers.*
import static org.mockito.Mockito.*
import static org.testng.Assert.*

class SecureDocControllerTest {

    @Mock
    SecureDocService csvServiceMock

    @InjectMocks
    SecureDocController csvController

    @BeforeMethod
    void setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    void downloadDocumentTest() throws IOException {
        /*
        // Given
        String locationId = "1"
        String locationNumber = "123"
        byte[] testData = "test-data".getBytes()
        InputStream inputStream = new ByteArrayInputStream(testData)
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream)
        ResponseEntity<Resource> expectedResponseEntity = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, SecureDocController.ATTACHMENT_FILENAME + "code-summaries.txt")
                .contentType(MediaType.parseMediaType(SecureDocController.APPLICATION_CSV))
                .body(inputStreamResource)

        when(csvServiceMock.downloadDocument(String.getClass(), String.getClass()))
                .thenReturn(inputStream)

        // When
        ResponseEntity<Resource> actualResponseEntity = csvController.downloadDocument(locationId, locationNumber)

        // Then
        verify(csvServiceMock).downloadDocument(eq(locationId), eq(locationNumber))
        assertEquals(actualResponseEntity, expectedResponseEntity)

         */
    }
}
