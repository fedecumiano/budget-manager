package org.github.fedecumiano.budgetManager.controller;

import org.github.fedecumiano.budgetManager.model.Operations;
import org.github.fedecumiano.budgetManager.model.User;
import org.github.fedecumiano.budgetManager.service.OperationService;
import org.github.fedecumiano.budgetManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private OperationService operationService;

    @GetMapping(value = "/home")
    public String showMenu(HttpServletRequest request, Model model){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getUser(username);
        if (username != null && !username.equals("")) {
            List<Operations> opList = operationService.retrieveAllOperations(user);
            List<Operations> lastTen = opList.stream().limit(10).collect(Collectors.toList());
            Double balance = operationService.balance(user);
            model.addAttribute("balance", balance);
            model.addAttribute("list", lastTen);
            return "home";
        }
        else{
            return "unloggedWelcome";
        }
    }

    @GetMapping(value="/")
    public String welcome(){
        return "unloggedWelcome";
    }
}
