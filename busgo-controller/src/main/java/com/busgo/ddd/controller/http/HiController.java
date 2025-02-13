package com.busgo.ddd.controller.http;

import com.busgo.ddd.application.service.events.EventAppService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;

    @Autowired
    private  RestTemplate restTemplate;


    @GetMapping("/v1")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHelloV1")
    public String sayHello() {
        return eventAppService.sayHi("say hello");
    }

    public String fallbackHelloV1() {
        return "To many request";
    }
    @GetMapping("/v2")
    @RateLimiter(name = "backendB", fallbackMethod = "fallbackHelloV1")
    public String sayHi() {
        return eventAppService.sayHi("say hi");
    }

    private static final SecureRandom secureRandom = new SecureRandom();
    @GetMapping("/circuit/breaker")
    @CircuitBreaker(name="checkRandom", fallbackMethod = "fallbackCircuitBreaker")
    public String circuitBreaker() {
        int productId = secureRandom.nextInt(20)+1;
        String url = "https://fakestoreapi.com/products/" + productId;
        return restTemplate.getForObject(url, String.class);
    }
}
