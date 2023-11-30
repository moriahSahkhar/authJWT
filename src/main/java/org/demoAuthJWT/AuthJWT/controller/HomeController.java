package org.demoAuthJWT.AuthJWT.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping()
    public String home(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("AUTH:: "+ auth.getAuthorities());
        return "home";
    }

}
