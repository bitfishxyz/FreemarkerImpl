package com.github.fish56.freemarker.controller;

import com.github.fish56.freemarker.entity.Monkey;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RootController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Hello friend!");
        return "index";
    }

    @GetMapping("/object")
    public String obj(Model model){
        Monkey monkey = new Monkey();
        monkey.setId(2);
        monkey.setName("Sun");
        monkey.setAge(22);
        model.addAttribute(monkey);
        return "object";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ids.add(i);
        }
        model.addAttribute("ids", ids);
        return "list";
    }

    @GetMapping("/if-else")
    public String ifElse(Model model, @RequestParam(required = false) String token){
        model.addAttribute("isLogin", token != null);
        return "if-else";
    }

}
