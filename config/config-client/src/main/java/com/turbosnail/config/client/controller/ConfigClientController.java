package com.turbosnail.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ConfigClientController {

    @Value("${profile}")
    private String profile;

    @RequestMapping("/profile")
    public String getProfile() {
        return this.profile;
    }
}
