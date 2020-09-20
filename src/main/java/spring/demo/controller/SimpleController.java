package spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/simple")
    public String index() {
        return "some text. Means that scan works. Finally.";
    }
}
