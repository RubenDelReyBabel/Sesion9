package com.babelgroup.controllers;

import com.babelgroup.service.init.DataInitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {

    private DataInitService dataInitService;

    public InitController(DataInitService dataInitService) {
        this.dataInitService = dataInitService;
    }

    @RequestMapping("/")
    public String init() {
        dataInitService.initData();
        return "index";
    }
}
