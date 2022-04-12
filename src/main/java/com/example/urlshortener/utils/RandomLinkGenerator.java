package com.example.urlshortener.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomLinkGenerator {

    @Value("${server.domain}")
    private String domain;

    public String generate() {
        Random random = new Random();
        var res = domain + "/redirect/";
        for (int i = 0; i <= 6; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            res += c;
        }
        return res;
    }
}
