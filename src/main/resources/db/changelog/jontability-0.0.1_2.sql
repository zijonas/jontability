--liquibase formatted sql
--changeset jziel:jontability-0.0.1_2_0
DROP TABLE bill;
DROP TABLE categorie;

--changeset jziel:jontability-0.0.1_2_1
CREATE TABLE category (
    id SERIAL,
    name VARCHAR (500),
    CONSTRAINT PK_category_id PRIMARY KEY (id)
);

--changeset jziel:jontability-0.0.1_2_2
CREATE TABLE bill (
    id SERIAL,
    category_id INTEGER,
    value FLOAT,
    date TIMESTAMP,
    description VARCHAR(1000),
    CONSTRAINT PK_bill_id PRIMARY KEY (id),
    CONSTRAINT FK_bill_category FOREIGN KEY (category_id) REFERENCES category (id)
);
