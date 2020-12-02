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
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String getLogin (Model model, HttpServletRequest request){
        String user = (String) request.getSession().getAttribute("username");
        if (user != null && !user.equals("")){
            model.addAttribute("message", "You are already logged in!");
            return "loggedWelcome";
        }
        else {
            model.addAttribute("user", new User());
            return "login";
        }
    }

    @PostMapping(value="/login")
    public String postLogin (@ModelAttribute("user") User user , Model model, HttpServletRequest request){
        String correctPass = userService.getPass(user.getUsername());
        if (userService.userExists(user.getUsername())){
            if (user.getPass().equals(correctPass)){
                model.addAttribute("message", "Logged in Successfully!");
                request.getSession().setAttribute("username", user.getUsername());
                return "loggedWelcome";
            }
            else{
                model.addAttribute("message", "Invalid password, try again");
                return "login";
            }
        }
        else{
           model.addAttribute("message", "This user doesn't exists");
           return "login";
        }
    }

    @GetMapping(value = "/logOff")
    public String getLogOff (HttpServletRequest request){
        request.getSession().setAttribute("username", "");
        return "unloggedWelcome";
    }
}
