package ru.learnUp.springboottest.view;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Data;

import java.util.List;

@Data
public class PostView {

    private Long id;

    private String title;

    private String text;

    private List<CommentView> comments;

}
