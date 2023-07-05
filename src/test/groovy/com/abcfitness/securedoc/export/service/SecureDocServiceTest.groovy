package com.abcfitness.securedoc.export.service

import org.apache.kafka.common.quota.ClientQuotaAlteration
import org.mockito.MockedStatic
import org.mockito.MockitoAnnotations
import org.testng.annotations.BeforeClass

import java.sql.Date
import java.time.LocalDate

import static org.testng.Assert.*
import org.testng.annotations.Test
import org.mockito.Mockito
import org.mockito.InjectMocks
import org.mockito.Mock
import static org.mockito.ArgumentMatchers.*

class SecureDocServiceTest {
    @InjectMocks
    SecureDocService csvService

    @BeforeClass
    void initMocks() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    void testLoadCodeSummaries() throws IOException {
    }
}