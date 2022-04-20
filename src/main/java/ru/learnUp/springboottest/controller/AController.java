package ru.learnUp.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.learnUp.springboottest.dao.entity.A;
import ru.learnUp.springboottest.dao.repository.ARepo;

@RestController
public class AController {

    private final ARepo aRepo;

    public AController(ARepo aRepo) {
        this.aRepo = aRepo;
    }

    @GetMapping
    public A postA(@RequestParam("text") String text) {
        A a = new A();
        a.setStr(text);
        return aRepo.save(a);
    }

}
