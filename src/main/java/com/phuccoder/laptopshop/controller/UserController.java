package com.phuccoder.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.phuccoder.laptopshop.domain.User;
import com.phuccoder.laptopshop.service.UserService;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create user
    @GetMapping("/admin/user/create")
    public String getCreate(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String postCreate(@ModelAttribute("newUser") User user) {
        this.userService.save(user);
        return "redirect:/admin/user/tableuser"; // sau khi create thid chuyển sang trang tableusser
    }

    // table user

    @GetMapping("/admin/user/tableuser")
    public String getTableUser(Model model) {
        List<User> user = this.userService.findAll();
        model.addAttribute("users", user);
        return "admin/user/tableuser";
    }

    // view user
    @GetMapping("/admin/user/viewuser/{id}")
    public String getView(Model model, @PathVariable long id) {
        User user = this.userService.getaUser(id);
        model.addAttribute("user", user);
        return "admin/user/viewuser"; // Đảm bảo trả về đúng tên view
    }

    // list user
    @GetMapping("/admin/user/listuser")
    public String getListUser(Model model){
        List<User> user = this.userService.findAll();
        model.addAttribute("users", user);
        return "admin/user/listuser";
    }
}
