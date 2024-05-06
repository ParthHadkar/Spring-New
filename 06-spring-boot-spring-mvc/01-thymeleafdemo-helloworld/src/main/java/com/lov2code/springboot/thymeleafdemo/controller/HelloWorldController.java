package com.lov2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    
    // need a controller mtd to show html form
    //@RequestMapping("/showForm") // can be used to get all mapping
    @GetMapping("/showForm")
    private String showForm(){
        return "helloworld-form";
    } 
    // need a controller mtd to process html form
    @RequestMapping("/processForm")
    private String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    private String shoutAllCaps(HttpServletRequest pRequest, Model pModel){
        String name = pRequest.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo! " + name;
        pModel.addAttribute("message", result);
        return "helloworld";
    }

    //@RequestMapping("/processFormVersionThree")
    @PostMapping("/processFormVersionThree")
    private String processFormVersionThree(@RequestParam("studentName") String name, Model pModel){
        name = name.toUpperCase();
        String result = "Hey my friend from v3! " + name;
        pModel.addAttribute("message", result);
        return "helloworld";
    }
}
