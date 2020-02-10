package com.giphly.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Arrays;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate giphyRestTemplate() {
        Duration readTimeout = Duration.ofSeconds(20L);
        Duration connectTimeout = Duration.ofSeconds(5L);

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
            new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
            Arrays.asList(
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_OCTET_STREAM));
      //  restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
        return new RestTemplateBuilder()
            .setReadTimeout(readTimeout)
            .setConnectTimeout(connectTimeout)
            .defaultMessageConverters().additionalMessageConverters(mappingJackson2HttpMessageConverter)
            .build();
    }
}
