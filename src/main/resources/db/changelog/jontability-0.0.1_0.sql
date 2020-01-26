--liquibase formatted sql
--changeset jziel:jontability-0.0.1_0_0
CREATE TABLE account (
    id SERIAL,
    name VARCHAR (500),
    type  VARCHAR (500),
    CONSTRAINT PK_account_id PRIMARY KEY (id)
);

--changeset jziel:jontability-0.0.1_0_1
CREATE TABLE categorie (
    id SERIAL,
    name VARCHAR (500),
    CONSTRAINT PK_categorie_id PRIMARY KEY (id)
);

--changeset jziel:jontability-0.0.1_0_2
CREATE TABLE bill (
    id SERIAL,
    categorie_id INTEGER,
    value FLOAT,
    date  TIMESTAMP,
    description VARCHAR(1000),
    CONSTRAINT PK_bill_id PRIMARY KEY (id),
    CONSTRAINT FK_bill_categorie FOREIGN KEY (categorie_id) REFERENCES categorie (id)
);

--changeset jziel:jontability-0.0.1_0_3
ALTER TABLE bill ADD COLUMN account_id INTEGER NOT NULL;
ALTER TABLE bill ADD CONSTRAINT FK_account_id FOREIGN KEY (account_id) REFERENCES account (id);