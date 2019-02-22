package com.company.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return  "helloworld-form";
    }


    @RequestMapping("/processForm")
    public String processForm(){
        return  "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String letShoutDude(HttpServletRequest request, Model model){

        // read the request param from the html form
        String theName = request.getParameter("studentName");

        // convert the data to all capps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return  "helloworld";
    }


}
