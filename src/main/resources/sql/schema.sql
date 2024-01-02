-- board.article definition

-- Drop table

DROP TABLE board.article;

CREATE SEQUENCE board.seq_article START 1;

CREATE TABLE board.article
(
    article_id         int8                  DEFAULT nextval('board.seq_article') NOT NULL,
    article_title      varchar(255) NOT NULL,
    article_content    text         NOT NULL,
    article_writer     varchar(255) NOT NULL,
    article_view_count int          NOT NULL default 0,
    created_at         timestamp    NOT NULL,
    updated_at         timestamp
);

-- board.member definition

-- Drop table

DROP TABLE board.member;

CREATE SEQUENCE board.seq_member START 1;

CREATE TABLE board.member
(
    member_id       int8 DEFAULT nextval('board.seq_member') NOT NULL,
    member_email    varchar(255)                             NOT NULL,
    member_password varchar(255)                             NOT NULL,
    member_name     varchar(255)                             NOT NULL,
    member_role     varchar(255)                             NOT NULL,
    created_at      timestamp                                NOT NULL,
    updated_at      timestamp
);
