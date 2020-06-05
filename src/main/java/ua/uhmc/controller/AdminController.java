package ua.uhmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.uhmc.model.Admin;

@Controller
public class AdminController {

    @GetMapping("/admin-reload")
    public String reloadElementDiv(@ModelAttribute("adminObj") Admin adminObj, Model model) {
        int random_id = 0 + (int)(Math.random() * (10 - 0) + 1 );
        adminObj = new Admin(random_id);
        model.addAttribute(adminObj);
        System.out.println("admin: " + adminObj);
        model.addAttribute("adminObj", adminObj);
        model.addAttribute("id", adminObj.getId());
        return "/fragments/adminForm";
    }

}
