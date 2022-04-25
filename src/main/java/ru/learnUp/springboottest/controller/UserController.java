package ru.learnUp.springboottest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnUp.springboottest.dao.user.Role;
import ru.learnUp.springboottest.dao.user.User;
import ru.learnUp.springboottest.service.user.UserService;
import ru.learnUp.springboottest.view.RoleView;
import ru.learnUp.springboottest.view.UserView;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Boolean createUser(@RequestBody UserView user) {
        User entity = new User();
        entity.setUsername(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setRoles(
                user.getRoles()
                        .stream()
                        .map(RoleView::getRole)
                        .map(Role::new)
                        .collect(Collectors.toSet())
        );
        userService.create(entity);
        return true;
    }

}
