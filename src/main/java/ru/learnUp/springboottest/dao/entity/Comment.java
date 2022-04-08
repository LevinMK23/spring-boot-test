package ru.learnUp.springboottest.dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(exclude = {"post"})
@RequiredArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn
    @Fetch(FetchMode.JOIN)
    private Post post;

}
