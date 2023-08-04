package org.demoAuthJWT.AuthJWT.controller;

import lombok.AllArgsConstructor;
import org.demoAuthJWT.AuthJWT.Repo.UserRepo;
import org.demoAuthJWT.AuthJWT.config.JwtService;
import org.demoAuthJWT.AuthJWT.mapper.UserLoginUserDetails;
import org.demoAuthJWT.AuthJWT.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class IndexController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;


    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("loginObj", new User());
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "loginObj") User user){
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        user.getUsername(),
//                        user.getPassword()
//                ));
//
//        var user1 = userRepo.findByUsername(user.getUsername())
//                .orElseThrow();
//
//        var jwtToken = jwtService.generateToken();

        return "redirect:/home";
    }


}
