package ru.learnUp.springboottest.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@RedisHash
public class A {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "str", nullable = false)
    private String str;

    @ManyToMany(mappedBy = "as")
    private List<B> bs = new ArrayList<>();

}
