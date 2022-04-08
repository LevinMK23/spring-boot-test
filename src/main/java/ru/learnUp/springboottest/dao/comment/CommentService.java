package ru.learnUp.springboottest.dao.comment;

import org.springframework.stereotype.Service;
import ru.learnUp.springboottest.dao.entity.Comment;
import ru.learnUp.springboottest.dao.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }
}
