package ru.learnUp.springboottest.view;

import lombok.Data;

import java.util.Set;

@Data
public class UserView {

    private String login;
    private String password;
    private Set<RoleView> roles;

}
