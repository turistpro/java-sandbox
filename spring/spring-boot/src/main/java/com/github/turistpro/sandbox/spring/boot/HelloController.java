package com.github.turistpro.sandbox.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @Autowired
    private Consumer<String> consumer;

    @GetMapping("/hello")
    public Map<String, String> hello() {
        consumer.accept("hello");
        return Collections.singletonMap("message", "Hello, World!");
    }
}
