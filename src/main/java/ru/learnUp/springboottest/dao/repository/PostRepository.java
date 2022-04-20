package ru.learnUp.springboottest.dao.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Repository;
import ru.learnUp.springboottest.dao.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTitle(String title);

    @Query(value = "select * from post p left join comment c on p.id = c.post_id where c.id is not null", nativeQuery = true)
    List<Post> findByIdWithComments();

    @Query(
            value = "select count(*) from post p " +
            "left join comment c on p.id = c.post_id " +
            "where p.id = ?1 and c.id is not null",
            nativeQuery = true
    )
    Long getCommentsCount(long id);

    @Query(value = "from Post p join fetch p.comments where p.id = :id")
    Post findId1(Long id);

    List<Post> findAll(Specification<Post> specification);
}
