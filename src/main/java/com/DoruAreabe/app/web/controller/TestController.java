package com.DoruAreabe.app.web.controller;

import com.DoruAreabe.app.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    Book test(){
        return new Book(1,"12313123123","sometitle","someautor","somepublisher","sometype");
    }
}
