package dev.fbricenos.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/public")
    public String myPublicApi() {
        return "Hello public data!";
    }
    @GetMapping("/private")
    public String myPrivateApi() {
        return "Hello private data!";
    }
}
