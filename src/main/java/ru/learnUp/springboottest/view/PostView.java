package ru.learnUp.springboottest.view;

import lombok.Data;

import java.util.List;

@Data
public class PostView {

    private Long id;

    private String title;

    private String text;

    private List<CommentView> comments;

}
