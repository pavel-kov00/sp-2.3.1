package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String getUsers(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/add")
    public String addUser() {
        return "adduser";
    }

    @PostMapping("/add")
    public String addUserPost(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id,Model model){
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUserPost(@ModelAttribute User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}