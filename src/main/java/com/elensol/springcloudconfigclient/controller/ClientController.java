package com.elensol.springcloudconfigclient.controller;

import com.elensol.springcloudconfigclient.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value = "/client")
public class ClientController {

    private final Config config;
    @Value("${my.message: Hey there! from default message}")
    private String message;

    @Autowired
    public ClientController(Config config) {
        this.config = config;
    }

    // One way
    @GetMapping(value = "/greeting")
    public String greeting(){
        return this.config.getGreeting();
    }

    // Other way
    @GetMapping(value = "/message")
    public String message(){
        return message;
    }
}
