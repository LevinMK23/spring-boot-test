package ru.learnUp.springboottest.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@RedisHash
public class Book {

    private Long id;
    private String imageUrl;
    private String name;
    private String description;
    private Long price;
    private Long count;
    private Long field;

}
