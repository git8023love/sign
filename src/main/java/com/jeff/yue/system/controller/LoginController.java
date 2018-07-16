package com.jeff.yue.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * 进入主页，转跳--->blog首页
     * @param model
     * @return
     */
    @GetMapping({ "/", "" })
    String welcome(Model model) {
        return "redirect:/blog";
    }
}
