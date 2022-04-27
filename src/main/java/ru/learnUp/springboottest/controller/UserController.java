package ru.learnUp.springboottest.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.learnUp.springboottest.dao.user.Role;
import ru.learnUp.springboottest.dao.user.User;
import ru.learnUp.springboottest.service.user.UserService;
import ru.learnUp.springboottest.view.RoleView;
import ru.learnUp.springboottest.view.UserView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<UserView> getActiveUsers() {
        return userService.findAll()
                .stream()
                .map(user -> UserView.builder()
                        .login(user.getUsername())
                        .roles(user.getRoles().stream()
                                .map(RoleView::new)
                                .collect(Collectors.toSet())
                        )
                        .build()
                )
                .collect(Collectors.toList());
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
