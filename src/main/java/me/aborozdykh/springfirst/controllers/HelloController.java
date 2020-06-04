package me.aborozdykh.springfirst.controllers;

import me.aborozdykh.springfirst.UserResponseDto;
import me.aborozdykh.springfirst.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "<h1>Hello123</h1>";
    }

    @ResponseBody
    @GetMapping(value = "/user")
    public UserResponseDto getUser() {
        var dto = new UserResponseDto();
        dto.setName("Bob");
        dto.setEmail("bob@i.ua");
        return dto;

    }
}
