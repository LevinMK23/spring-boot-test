package ru.learnUp.springboottest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.springboottest.dao.User;
import ru.learnUp.springboottest.dao.entity.Comment;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.post.PostService;
import ru.learnUp.springboottest.service.user.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootApplication
@EnableCaching
public class SpringBootTestApplication {

    static void updateAsync(PostService service) {

        Post post = service.getPostById(2L);
        post.setTitle("Title new 4");

        for (int i = 0; i < 5; i++) {
            new Thread(() -> service.update(post)).start();
        }
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        PostService postService = context.getBean(PostService.class);

        updateAsync(postService);

    }

}
