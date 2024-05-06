package com.love2code.springdemo.mvc.controller;

import com.love2code.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(DataBinder pDataBinder){

        StringTrimmerEditor lStringTrimmerEditor = new StringTrimmerEditor(true);
        pDataBinder.registerCustomEditor(String.class, lStringTrimmerEditor);
    }
    @GetMapping("/")
    public String showForm(Model pModel){
        pModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer pCustomer, BindingResult pBindingResult){

        System.out.println("lastName: |"+pCustomer.getLastName()+"|");

        System.out.println("Binding Result: "+pBindingResult.toString());
        System.out.println("\n\n\n\n");
        if(pBindingResult.hasErrors()){
            return "customer-form";
        }
        else{
            return "customer-confirmation";
        }
    }

}
