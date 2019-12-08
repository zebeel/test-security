package com.beel.testsecurity.controller;

import com.beel.testsecurity.common.Message;
import com.beel.testsecurity.common.Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", Message.WelcomeMsg);

        return Template.Welcome;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return Template.Hello;
    }

}
