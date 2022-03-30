package ru.learnUp.springboottest.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnUp.springboottest.dao.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
