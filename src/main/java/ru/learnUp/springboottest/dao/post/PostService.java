package ru.learnUp.springboottest.dao.post;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.OptimisticLock;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.repository.PostRepository;

import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import java.util.List;

@Slf4j
@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Post createPost(Post post) {
        return repository.save(post);
    }

    public List<Post> getPosts() {
       return repository.findAll();
    }

    @Cacheable(value = "post")
    public Post getPostById(Long id) {
        return repository.findId1(id);
    }

    @Transactional
    @CacheEvict(value = "post", key = "#post.id")
    @Lock(value = LockModeType.READ)
    public void update(Post post) {
        try {
            repository.save(post);
        } catch (OptimisticLockException e) {
               log.warn("Optimistic lock exception for post {}", post.getId());
        }
    }

}
