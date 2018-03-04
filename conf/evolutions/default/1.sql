# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table t_roles (
  id                            integer auto_increment not null,
  name                          varchar(255),
  constraint pk_t_roles primary key (id)
);

create table t_users (
  username                      varchar(255) not null,
  password                      varchar(255),
  city                          varchar(255),
  address                       varchar(255),
  school                        varchar(255),
  sch_class                     varchar(255),
  req_hours                     integer not null,
  curr_hours                    integer not null,
  constraint pk_t_users primary key (username)
);


# --- !Downs

drop table if exists t_roles;

drop table if exists t_users;

