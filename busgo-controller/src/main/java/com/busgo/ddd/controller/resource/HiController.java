package com.busgo.ddd.controller.resource;

import com.busgo.ddd.application.service.events.EventAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;
    @GetMapping("/v1")
    public String sayHello() {
        return eventAppService.sayHi("say hello");
    }
    @GetMapping("/v2")
    public String sayHi() {
        return eventAppService.sayHi("say hi");
    }
}
