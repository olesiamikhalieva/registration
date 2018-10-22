package com.hellokoding.auth.controller;

import com.hellokoding.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "admin";
    }

    @RequestMapping(value = "/admin/deleteById", method = RequestMethod.GET)
    public String deleteUserById(@RequestParam Long id) {
        userService.removeById(id);
        return "redirect:/admin";
    }


}
