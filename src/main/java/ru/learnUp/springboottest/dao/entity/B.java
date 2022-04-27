package ru.learnUp.springboottest.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
//@RedisHash
public class B {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToMany
    @JoinTable(name = "b_as",
            joinColumns = @JoinColumn(name = "b_id"),
            inverseJoinColumns = @JoinColumn(name = "as_id"))
    private List<A> as = new ArrayList<>();


}
