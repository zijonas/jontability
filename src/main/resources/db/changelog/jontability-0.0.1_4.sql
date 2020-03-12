--liquibase formatted sql
--changeset jziel:jontability-0.0.1_4_0
create table user_data (
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);

--changeset jziel:jontability-0.0.1_4_1
create table authority (
    id SERIAL,
    username varchar(50) not null,
    role varchar(50) not null,
    constraint fk_authority_user_data foreign key(username) references user_data(username)
);
create unique index ix_auth_username on authority (username,role);

--changeset jziel:jontability-0.0.1_4_2
insert into user_data (username, password, enabled) values ('admin', '$2a$10$9iKlo/EJP.R716HLYT9P0..bNh7WPHjwwKwJSCPaxlFRwy3dVj3he', true);
insert into user_data (username, password, enabled) values ('user', '$2a$10$9iKlo/EJP.R716HLYT9P0..bNh7WPHjwwKwJSCPaxlFRwy3dVj3he', true);

--changeset jziel:jontability-0.0.1_4_3
insert into authority (username, role) values ('admin', 'ROLE_ADMIN');
insert into authority (username, role) values ('user', 'ROLE_USER');
