package ru.learnUp.springboottest.dao.post;

import org.springframework.stereotype.Service;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post createPost(Post post) {
        return repository.save(post);
    }

    public List<Post> getPosts() {
       return repository.findAll();
    }

    public Post getPostById(Long id) {
        return repository.getById(id);
    }

}
