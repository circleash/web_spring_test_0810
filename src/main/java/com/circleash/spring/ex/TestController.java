package com.circleash.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@ResponseBody
    @RequestMapping("/hello1")
    public String helloWorld() {
        return "Hello World!!";
    }
}

