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

@Slf4j
@SpringBootApplication
@EnableCaching
public class SpringBootTestApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        userService.save(User.builder()
                .name("Ivan 1")
                .surname("Ivanov 1")
                .birthDate(LocalDate.of(2000, 12, 20))
                .address("St.Petersburg")
                .build());

        PostService postService = context.getBean(PostService.class);

        Post post = new Post();

        post.setText("New post text");
        post.setTitle("New post title");
        post.setComments(
                List.of(
                        new Comment("New comment 1", post),
                        new Comment("New comment 2", post),
                        new Comment("New comment 3", post)
                )
        );

        postService.createPost(post);

        log.info("Created: {}", post);

    }

}
