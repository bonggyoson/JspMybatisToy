-- board.article definition

-- Drop table

DROP TABLE board.article;

CREATE TABLE board.article
(
    article_id         int8                  DEFAULT nextval('board.seq_article') NOT NULL,
    article_title      varchar(255) NOT NULL,
    article_content    text         NOT NULL,
    article_writer     varchar(255) NOT NULL,
    article_view_count int          NOT NULL default 0,
    created_at timestamp NOT NULL,
    updated_at timestamp
);