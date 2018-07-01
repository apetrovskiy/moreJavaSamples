package com.test.spring;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Test001 {
    public static final String BASE_URL = "http://localhost:1235/v2";
    public static final String CATS = "/cats";

    @Test
    public void testConnect() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + CATS + "?name=barsik", String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        System.out.print(response.getBody());
    }
}
