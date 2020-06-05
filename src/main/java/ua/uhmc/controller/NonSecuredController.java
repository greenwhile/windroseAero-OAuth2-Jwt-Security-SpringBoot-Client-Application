package ua.uhmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.uhmc.component.WindmapComponent;
import ua.uhmc.model.Windmap;

@Controller
public class NonSecuredController {

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }

    @GetMapping(value="/index")
    public String get_index(Model model){
        WindmapComponent windmapComponent = new WindmapComponent();
        model.addAttribute(windmapComponent);
        return "index";
    }

//    @PostMapping(value="/index")
//    public String post_index(@ModelAttribute("windmap") Windmap windmap){
//        System.out.println(windmap);
//        return "index_success";
//    }

    @RequestMapping(value = "/secured/index", method = RequestMethod.GET)
    public String securedIndex() {
        return "secured/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return login();
    }

}

