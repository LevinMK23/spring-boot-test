package ru.learnUp.springboottest.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import ru.learnUp.springboottest.dao.User;
import ru.learnUp.springboottest.dao.UserDao;

import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;
    private final TransactionTemplate transactionTemplate;

    public UserService(UserDao userDao,
                       TransactionTemplate transactionTemplate) {
        this.userDao = userDao;
        this.transactionTemplate = transactionTemplate;
    }

    public Optional<User> findById(long id) {
        return userDao.findById(id);
    }

    public void save(User user) {
        transactionTemplate.executeWithoutResult(status -> {
            userDao.save(user);
        });
    }
}
