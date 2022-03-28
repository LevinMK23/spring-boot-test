package ru.learnUp.springboottest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.springboottest.dao.User;
import ru.learnUp.springboottest.dao.UserDao;
import ru.learnUp.springboottest.dao.entity.Comment;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.post.PostDao;
import ru.learnUp.springboottest.service.Calculator;
import ru.learnUp.springboottest.service.Operation;
import ru.learnUp.springboottest.service.ValueService;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SpringBootTestApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootTestApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);
        Calculator calculator = context.getBean(Calculator.class);
        log.info("{} - {} = {}", 2, 2, calculator.calculate(2, 2, Operation.MINUS));
        context.getBean(ValueService.class).print();

        PostDao postDao = context.getBean(PostDao.class);

        Comment comment = new Comment();
        comment.setText("Comment text");

        Post post = new Post();
        post.setText("Post text");
        post.setTitle("Post title");
        comment.setPost(post);
        post.setComments(List.of(comment));

        postDao.createPost(post);

        List<Post> posts = postDao.getPosts();
        log.info("{}", posts);

    }

}
