package ru.learnUp.springboottest.service;

public interface Processor {

    Operation getOperation();

    int process(int a, int b);

}
