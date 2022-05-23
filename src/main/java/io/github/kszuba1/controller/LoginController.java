package io.github.kszuba1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/loginStudent")
    public String loginFormStudent() {

        return "login-form-student";
    }

    @GetMapping("/loginInstructor")
    public String loginFormInstructor() {

        return "login-form-instructor";
    }

}
