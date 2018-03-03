# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table t_users (
  username                      varchar(255) not null,
  password                      varchar(255),
  constraint pk_t_users primary key (username)
);


# --- !Downs

drop table if exists t_users;

