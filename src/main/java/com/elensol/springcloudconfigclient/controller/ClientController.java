package com.elensol.springcloudconfigclient.controller;

import com.elensol.springcloudconfigclient.config.Config;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private final Config config;

    public ClientController(Config config) {
        this.config = config;
    }

    @GetMapping(value = "/greeting")
    public String greeting(){
        return this.config.getGreeting();
    }
}
