package ru.learnUp.springboottest.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnUp.springboottest.dao.entity.A;

@Repository
public interface ARepo extends JpaRepository<A, Long> {
}
