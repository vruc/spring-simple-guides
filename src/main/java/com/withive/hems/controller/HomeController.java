package com.withive.hems.controller;

import com.withive.hems.bean.Greeting;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HomeController {

    private final static AtomicLong counter = new AtomicLong();
    private final static String template = "Hello %s";

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Home";
    }

    @RequestMapping("/greet")
    @ResponseBody
    public Greeting greet(@RequestParam(value = "name", defaultValue = "OSCAR") String name) {
        return new Greeting(counter.incrementAndGet(), template.format(name));
    }


}
