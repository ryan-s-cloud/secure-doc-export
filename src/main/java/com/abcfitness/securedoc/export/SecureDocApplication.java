package com.abcfitness.securedoc.export;

import com.abcfinancial.api.common.annotation.AbcService;
import com.abcfinancial.api.common.configuration.ABCResourceServerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.reactive.function.client.WebClient;

@AbcService
public class SecureDocApplication extends ABCResourceServerConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(SecureDocApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		final int size = 24 * 1024 * 1024;
		return WebClient.builder()
				.baseUrl("https://file-examples.com")  // TODO: https://cmodsvc.abcfinancial.net/
				.codecs(configurer -> configurer
						.defaultCodecs()
						.maxInMemorySize(size))
				.build();
	}
}