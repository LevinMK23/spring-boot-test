--liquibase formatted sql

--changeset mikelevin:create_post_table
create table post
(
    id      serial not null,
    text    text,
    title   text,
    version int8 default 0,
    primary key (id)
)