package me.aborozdykh.springfirst;

import java.util.List;
import me.aborozdykh.springfirst.config.AppConfig;
import me.aborozdykh.springfirst.models.User;
import me.aborozdykh.springfirst.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var userService = context.getBean(UserService.class);

        userService.add(new User("test@test.com", "pass_example"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("__");
            System.out.println(user);
        }

    }
}
