package org.github.fedecumiano.budgetManager.controller;

import org.github.fedecumiano.budgetManager.model.User;
import org.github.fedecumiano.budgetManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignInController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/signIn")
    public String getSignIn (Model model, HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        if (username != null && !username.equals("")){
            model.addAttribute("message", "You are already logged in!");
            return "loggedWelcome";
        }
        else {
            model.addAttribute("user", new User());
            return "signIn";
        }
    }

    @PostMapping(value="/signIn")
    public String postSignIn (@ModelAttribute("user") User user , Model model, HttpServletRequest request){
        String username = user.getUsername();
        if (userService.userExists(username)) {
            model.addAttribute("user", new User());
            model.addAttribute("message", "User already exists");
            return "signIn";
        }
        else{
            userService.addUser(user.getUsername(), user.getPass());
            request.getSession().setAttribute("username", user.getUsername());
            model.addAttribute("message", "User created successfully");
            return "loggedWelcome";
        }

    }
}
