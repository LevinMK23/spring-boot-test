package ru.learnUp.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
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
@EnableCaching
//@EnableRedisRepositories
public class SpringBootTestApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        PostService postService = context.getBean(PostService.class);

        CommentService commentService = context.getBean(CommentService.class);

        log.info("Posts: {}", postService.getPosts());
        log.info("Comments: {}", commentService.getComments());


        PostRepository postRepository = context.getBean(PostRepository.class);

        //log.info("Search result: {}", postRepository.findAllByTextContains("asd"));

        // log.info("Search result: {}", postRepository.findByIdWithComments());

        // log.info("Post 1 have {} comments", postRepository.getCommentsCount(1));

        // log.info("Post id = 1: {}", postRepository.findId1(1L));

        Post post = postService.getPostById(1L);

        for (int i = 0; i < 5; i++) {
            log.info("Post id = 1: {}", postService.getPostById(1L));
        }

        post.setText("Post text edited 3");

        postService.update(post);

        log.info("Post id = 1: {}", postService.getPostById(1L));
    }

}
