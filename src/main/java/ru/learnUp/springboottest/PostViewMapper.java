package ru.learnUp.springboottest;

import org.springframework.stereotype.Component;
import ru.learnUp.springboottest.dao.entity.Comment;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.view.CommentView;
import ru.learnUp.springboottest.view.PostView;

import java.util.stream.Collectors;

@Component
public class PostViewMapper {

    public PostView mapToView(Post post) {
        PostView view = new PostView();
        view.setId(post.getId());
        view.setText(post.getText());
        view.setTitle(post.getTitle());
        if (post.getComments() != null) {
            view.setComments(
                    post.getComments().stream()
                            .map(comment -> new CommentView(comment.getId(), comment.getText()))
                            .collect(Collectors.toList())
            );
        }
        return view;
    }

    public Post mapFromView(PostView view) {
        Post post = new Post();
        post.setId(view.getId());
        post.setTitle(view.getTitle());
        post.setText(view.getText());
        if (view.getComments() != null) {
            post.setComments(
                    view.getComments()
                            .stream()
                            .map(comment -> new Comment(comment.getId(), comment.getText(), post))
                            .collect(Collectors.toList())
                    );
        }
        return post;
    }

}
