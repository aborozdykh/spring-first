package me.aborozdykh.springfirst.controllers;

import java.util.LinkedList;
import java.util.List;
import me.aborozdykh.springfirst.dto.UserResponseDto;
import me.aborozdykh.springfirst.models.User;
import me.aborozdykh.springfirst.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/inject")
    public String inject() {
        userService.add(new User("nif-nif@pigs.com", "nif-nif"));
        userService.add(new User("naf-naf@pigs.com", "naf-naf"));
        userService.add(new User("nuf-nuf@pigs.com", "nuf-nuf"));
        return "Data was injected";
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return getDtoFromUser(userService.get(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> list = new LinkedList<>();
        for (User user : userService.listUsers()) {
            list.add(getDtoFromUser(user));
        }
        return list;
    }

    public UserResponseDto getDtoFromUser(User user) {
        var userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
