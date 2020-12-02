package org.github.fedecumiano.budgetManager.controller;

import org.github.fedecumiano.budgetManager.model.Operations;
import org.github.fedecumiano.budgetManager.model.User;
import org.github.fedecumiano.budgetManager.service.OperationService;
import org.github.fedecumiano.budgetManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private UserService userService;

    //INCOME / SPENT

    @GetMapping(value = "/newOperation")
    public String getNewOp (Model model, HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        if (username != null && !username.equals("")){
            model.addAttribute("user", userService.getUser(username));
            model.addAttribute("operation", new Operations());
            return "newOperation";
        }
        else {
            model.addAttribute("message", "Log in to register an operation");
            return "login";
        }
    }

    @PostMapping(value = "/newOperation")
    public String postNewOp (@ModelAttribute ("operation") Operations operation, Model model){
        operationService.saveOperation(operation);
        User user = userService.getUser(operation.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("list", operationService.retrieveAllOperations(user));
        model.addAttribute("message", "Operation created succesfully");
        return "operationList";
    }


    @GetMapping(value = "/operationList")
    public String getOpList (Model model, HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.getUser(username);
        if (username != null && !username.equals("")){
            model.addAttribute("user", user);
            model.addAttribute("list", operationService.retrieveAllOperations(user));
            return "operationList";
        }
        else {
            model.addAttribute("message", "Log in to view your operations");
            return "/login";
        }
    }

    @GetMapping(value = "/deleteOperation")
    public String deleteOp (@RequestParam String id, HttpServletRequest request, Model model){
        String username = (String) request.getSession().getAttribute("username");
        Operations operation = operationService.findOperation(Integer.parseInt(id));
        if (operation.getUsername().equals(username)){
            operationService.deleteOperation(operation);
            User user = userService.getUser(operation.getUsername());
            model.addAttribute("user", user);
            model.addAttribute("list", operationService.retrieveAllOperations(user));
            model.addAttribute("message", "Operation deleted Successfully");
            return "operationList";
        }
        else{
            model.addAttribute("message", "An error occured");
            return "loggedWelcome";
        }
    }

    @GetMapping(value = "/updateOperation")
    public String getUpdateOp (@RequestParam String id, HttpServletRequest request, Model model){
        String username = (String) request.getSession().getAttribute("username");
        Operations operation = operationService.findOperation(Integer.parseInt(id));
        if (operation.getUsername().equals(username)){
            model.addAttribute("updOperation", operation);
            model.addAttribute("operation", new Operations());
            return "updateOperation";
        }
        else{
            model.addAttribute("message", "An error occured");
            return "loggedWelcome";
        }
    }

    @PostMapping(value = "/updateOperation")
    public String postUpdateOp (@ModelAttribute ("operation") Operations operation, Model model){
        operationService.saveOperation(operation);
        User user = userService.getUser(operation.getUsername());
        model.addAttribute("user", user);
        model.addAttribute("list", operationService.retrieveAllOperations(user));
        model.addAttribute("message", "Operation updated succesfully");
        return "operationList";
    }


}
