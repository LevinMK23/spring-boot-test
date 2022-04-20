package ru.learnUp.springboottest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnUp.springboottest.dao.User;
import ru.learnUp.springboottest.dao.entity.Book;
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

    public static void main(String[] args) throws JsonProcessingException {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        Gson gson = new Gson();

        Book book = Book.builder()
                .id(1L)
                .name("Book")
                .description("Description")
                .count(1L)
                .imageUrl("https://url.com")
                .price(100L)
                .build();

        String json = gson.toJson(book);

        log.info("{}", json);

        Book serial = gson.fromJson(json, Book.class);
        log.info("{}", serial);

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(book);
        log.info("{}", s);

    }

}
