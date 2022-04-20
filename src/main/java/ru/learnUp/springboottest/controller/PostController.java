package ru.learnUp.springboottest.controller;

import org.springframework.web.bind.annotation.*;
import ru.learnUp.springboottest.PostViewMapper;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.post.PostFilter;
import ru.learnUp.springboottest.dao.post.PostService;
import ru.learnUp.springboottest.view.PostView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    private final PostService postService;
    private final PostViewMapper mapper;

    public PostController(PostService postService,
                          PostViewMapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PostView> getPosts(
            @RequestParam(value = "text", required = false) String text,
            @RequestParam(value = "title", required = false) String title
    ) {
        return postService.getPostsBy(new PostFilter(text, title))
                .stream()
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{postId}")
    public PostView getPost(@PathVariable("postId") Long postId) {
        return mapper.mapToView(postService.getPostById(postId));
    }

    @PostMapping
    public PostView createPost(@RequestBody PostView body) {
        if (body.getId() != null) {
            throw new EntityExistsException(
                    String.format("Post with id = %s already exist", body.getId())
            );
        }
        Post post = mapper.mapFromView(body);
        Post createdPost = postService.createPost(post);
        return mapper.mapToView(createdPost);
    }

    @PutMapping("/{postId}")
    public PostView updatePost(
            @PathVariable("postId") Long postId,
            @RequestBody PostView body
    ) {
        if (body.getId() == null) {
            throw new EntityNotFoundException("Try to found null entity");
        }
        if (!Objects.equals(postId, body.getId())) {
            throw new RuntimeException("Entity has bad id");
        }

        Post post = postService.getPostById(postId);

        if (!post.getText().equals(body.getText())) {
            post.setText(body.getText());
        }

        if (!post.getTitle().equals(body.getTitle())) {
            post.setTitle(body.getTitle());
        }

        Post updated = postService.update(post);

        return mapper.mapToView(updated);

    }

    @DeleteMapping("/{postId}")
    public Boolean deletePost(@PathVariable("postId") Long postId) {
        return postService.delete(postId);
    }

}
