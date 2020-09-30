package org.launchcode.spaday.controllers;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user/add")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute(user);
        if (verify == user.getPassword()) {
            return "user/index.html";
        } else {
            return "redirect";
        }
    }
}
