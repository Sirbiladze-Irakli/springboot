package com.spring.springboot.controller;

import com.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdministrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") String username,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(username);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/get/{username}")
    public String getUser(@PathVariable("username") String username, Model model) {
        model.addAttribute("allUsers", userService.usergtList(username));
        return "admin";
    }

}
