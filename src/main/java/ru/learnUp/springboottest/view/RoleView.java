package ru.learnUp.springboottest.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnUp.springboottest.dao.user.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleView {

    private String role;

    public RoleView(Role role) {
        this.role = role.getRole();
    }

}
