package com.giphly.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.giphly.client.giphy.api.invoker.RFC3339DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JavaTimeModule javaTimeModule;

    @Autowired
    private Jdk8Module jdk8Module;

    @Bean
    public RestTemplate giphyRestTemplate() {
        Duration readTimeout = Duration.ofSeconds(20L);
        Duration connectTimeout = Duration.ofSeconds(5L);

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
            new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = mappingJackson2HttpMessageConverter.getObjectMapper()
            .registerModule(jdk8Module)
            .registerModule(javaTimeModule);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE, false);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
        mapper.setDateFormat(new RFC3339DateFormat());
        mappingJackson2HttpMessageConverter.setObjectMapper(mapper);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
            Arrays.asList(
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_OCTET_STREAM));
       RestTemplate restTemplate = new RestTemplateBuilder()
            .setReadTimeout(readTimeout)
            .setConnectTimeout(connectTimeout)
            .additionalMessageConverters(mappingJackson2HttpMessageConverter)
            .build();
       return restTemplate;
    }
}
