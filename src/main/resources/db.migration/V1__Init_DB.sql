create table authors
(
    birth_date date,
    id         bigint not null auto_increment,
    name       varchar(255),
    primary key (id)
) engine = InnoDB;
create table genres
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table publishes
(
    id      bigint not null auto_increment,
    address varchar(255),
    name    varchar(255),
    primary key (id)
) engine = InnoDB;
create table products
(
    release_date date,
    id           bigint not null auto_increment,
    publisher_id bigint not null,
    description  text,
    isbn         varchar(255),
    title        varchar(255),
    primary key (id)
) engine = InnoDB;
create table author_product
(
    author_id  bigint not null,
    product_id bigint not null
) engine = InnoDB;
create table genre_product
(
    genre_id   bigint not null,
    product_id bigint not null
) engine = InnoDB;
alter table author_product
    add constraint FKaixxa82b1qrwp8gdo9jpet01 foreign key (product_id) references products (id);
alter table author_product
    add constraint FKeig7m3wyj8c6ytwhgtp0r7xg0 foreign key (author_id) references authors (id) ON DELETE CASCADE;
alter table genre_product
    add constraint FK2haatf5e79dv8fn7wa8ysgblj foreign key (product_id) references products (id);
alter table genre_product
    add constraint FKt3u06p6e7kmwym7fdpgr39kme foreign key (genre_id) references genres (id) ON DELETE CASCADE;
alter table products
    add constraint FKh37bx9bt85nmd0eokefsh3dvr foreign key (publisher_id) references publishes (id);