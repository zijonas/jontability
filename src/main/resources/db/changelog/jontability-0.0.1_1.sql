--liquibase formatted sql
--changeset jziel:jontability-0.0.1_1_0
CREATE TABLE aaccount (
    id SERIAL,
    name VARCHAR (500),
    type  VARCHAR (500),
    CONSTRAINT PK_aaccount_id PRIMARY KEY (id)
);

--changeset jziel:jontability-0.0.1_1_1
DROP TABLE aaccount;
