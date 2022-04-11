--liquibase formatted sql

--changeset mikelevin:create_comment_table
create table comment
(
    id      serial not null,
    text    text,
    version int8 default 0,
    post_id int8,
    primary key (id)
);

--changeset mikelevin:create_comment_table_fk
alter table comment
    add constraint fk_post_id foreign key (post_id) references post (id);