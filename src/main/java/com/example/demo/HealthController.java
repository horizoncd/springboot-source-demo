package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HealthController {
    private String status = "online";

    @RequestMapping("/health/online")
    public String doOnline() {
        status = "online";
        return "do online";
    }

    @RequestMapping("/health/offline")
    public String doOffline() {
        status = "offline";
        return "do offline";
    }

    @RequestMapping("/health/check")
    public String doCheck() {
        return "ok";
    }

    @RequestMapping("/health/status")
    public String status(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("offline".equals(status)) {
            response.setStatus(400);
            return "bad request";
        }
        response.setStatus(200);
        return "ok";
    }
}
