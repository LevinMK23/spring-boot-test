package ru.learnUp.springboottest.dao.repository;

import org.springframework.data.jpa.domain.Specification;
import ru.learnUp.springboottest.dao.entity.Post;
import ru.learnUp.springboottest.dao.post.PostFilter;

import javax.persistence.criteria.Predicate;

public class PostSpecification {

    public static Specification<Post> byFilter(PostFilter filter) {

        return (root, q, cb) -> {

            Predicate predicate = cb.isNotNull(root.get("id"));

            if (filter.getText() != null) {
                predicate = cb.and(predicate, cb.like(root.get("text"), "%" + filter.getText() + "%"));
            }

            if (filter.getTitle() != null) {
                predicate = cb.and(cb.like(root.get("title"), "%" + filter.getTitle() + "%"));
            }

            return predicate;
        };
    }

}
