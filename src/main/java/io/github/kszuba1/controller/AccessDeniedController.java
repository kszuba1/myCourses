package io.github.kszuba1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access-denied";
    }
}
