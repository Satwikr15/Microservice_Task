//package com.example.servicea.ServiceA;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class ServiceMessage {
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public ServiceMessage(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//    public String getMessage() {
//        String url = "http://localhost:8081/api/message";
//        return restTemplate.getForObject(url, String.class);
//    }
//}
package com.example.servicea.ServiceA;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceMessage {

    private final RestTemplate restTemplate;

    @Autowired
    public ServiceMessage(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    // Circuit Breaker pattern applied
    @CircuitBreaker(name = "messageService", fallbackMethod ="fallbackMessage")
    public String getMessage() {
        String url = "http://localhost:8081/api/message";  //message(ServiceB) or greeting(B)
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackMessage(Exception e) {
        return "Fallback response: Service is currently unavailable.";
    }
}

