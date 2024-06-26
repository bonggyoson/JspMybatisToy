-- board.article definition

-- Drop table

DROP TABLE IF EXISTS board.article;

DROP SEQUENCE IF EXISTS board.seq_article;

CREATE SEQUENCE board.seq_article START 1;

CREATE TABLE board.article
(
    article_id         int8                  DEFAULT nextval('board.seq_article') NOT NULL,
    member_id          int8         NOT NULL,
    article_title      varchar(255) NOT NULL,
    article_content    text         NOT NULL,
    article_view_count int          NOT NULL default 0,
    created_at         timestamp    NOT NULL,
    updated_at         timestamp
);

-- board.member definition

-- Drop table

DROP TABLE IF EXISTS board.member;

DROP SEQUENCE IF EXISTS board.seq_member;

CREATE SEQUENCE board.seq_member START 1;

CREATE TABLE board.member
(
    member_id        int8 DEFAULT nextval('board.seq_member') NOT NULL,
    member_email     varchar(255)                             NOT NULL,
    member_password  varchar(255)                             NOT NULL,
    member_name      varchar(255)                             NOT NULL,
    member_role      varchar(255)                             NOT NULL,
    upload_file_name varchar(255),
    store_file_name  varchar(255),
    store_path       varchar(255),
    created_at       timestamp                                NOT NULL,
    updated_at       timestamp
);

-- board.comment definition

-- Drop table

DROP TABLE IF EXISTS board.comment;

DROP SEQUENCE IF EXISTS board.seq_comment;

CREATE SEQUENCE board.seq_comment START 1;

CREATE TABLE board.comment
(
    comment_id      int8 DEFAULT nextval('board.seq_comment') NOT NULL,
    article_id      int8                                      NOT NULL,
    member_id       int8                                      NOT NULL,
    comment_content text                                      NOT NULL,
    created_at      timestamp                                 NOT NULL,
    updated_at      timestamp
);

-- board.workoutCralwer definition

-- Drop table

DROP TABLE IF EXISTS board.workoutCralwer;

DROP SEQUENCE IF EXISTS board.seq_workout;

CREATE SEQUENCE board.seq_workout START 1;

CREATE TABLE board.workoutCralwer
(
    workout_id      int8 DEFAULT nextval('board.seq_workout') NOT NULL,
    workout_name    varchar(255)                              NOT NULL,
    workout_content text                                      NOT NULL,
    created_at      timestamp                                 NOT NULL,
    updated_at      timestamp
);
