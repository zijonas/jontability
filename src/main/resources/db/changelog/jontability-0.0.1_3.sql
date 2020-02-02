--liquibase formatted sql
--changeset jziel:jontability-0.0.1_3_0
DROP TABLE bill;

--changeset jziel:jontability-0.0.1_3_1
CREATE TABLE post (
    id SERIAL,
    category_id INTEGER NOT NULL,
    account_id INTEGER NOT NULL,
    invoice boolean default TRUE,
    value FLOAT,
    date TIMESTAMP,
    description VARCHAR(1000),
    CONSTRAINT PK_post_id PRIMARY KEY (id),
    CONSTRAINT FK_post_category FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT FK_post_account FOREIGN KEY (account_id) REFERENCES account (id)
);
