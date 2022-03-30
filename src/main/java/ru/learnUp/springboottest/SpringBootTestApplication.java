package ru.learnUp.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.learnUp.springboottest.dao.comment.CommentService;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.post.PostService;
import ru.learnUp.springboottest.dao.repository.PostRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringBootTestApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        PostService postService = context.getBean(PostService.class);

        CommentService commentService = context.getBean(CommentService.class);

        log.info("Posts: {}", postService.getPosts());
        log.info("Comments: {}", commentService.getComments());


    }

}
