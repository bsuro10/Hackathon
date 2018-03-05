# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table t_events (
  id                            integer auto_increment not null,
  name                          varchar(255),
  address                       varchar(255),
  start_date                    datetime(6),
  end_date                      datetime(6),
  organization_id               integer,
  constraint pk_t_events primary key (id)
);

create table t_organizations (
  id                            integer auto_increment not null,
  name                          varchar(255),
  address                       varchar(255),
  description                   varchar(255),
  constraint pk_t_organizations primary key (id)
);

create table t_roles (
  id                            integer auto_increment not null,
  name                          varchar(255),
  display_name                  varchar(255),
  constraint pk_t_roles primary key (id)
);

create table t_users (
  username                      varchar(255) not null,
  password                      varchar(255),
  fullname                      varchar(255),
  cellphone                     varchar(255),
  city                          varchar(255),
  address                       varchar(255),
  school                        varchar(255),
  sch_class                     varchar(255),
  req_hours                     integer not null,
  curr_hours                    integer not null,
  role_id                       integer,
  org_id                        integer,
  constraint pk_t_users primary key (username)
);

create table t_event_user (
  id                            integer auto_increment not null,
  username                      varchar(255),
  event_id                      integer,
  hours                         integer not null,
  approve                       tinyint(1) default 0 not null,
  constraint pk_t_event_user primary key (id)
);

alter table t_events add constraint fk_t_events_organization_id foreign key (organization_id) references t_organizations (id) on delete restrict on update restrict;
create index ix_t_events_organization_id on t_events (organization_id);

alter table t_users add constraint fk_t_users_role_id foreign key (role_id) references t_roles (id) on delete restrict on update restrict;
create index ix_t_users_role_id on t_users (role_id);

alter table t_users add constraint fk_t_users_org_id foreign key (org_id) references t_organizations (id) on delete restrict on update restrict;
create index ix_t_users_org_id on t_users (org_id);

alter table t_event_user add constraint fk_t_event_user_username foreign key (username) references t_users (username) on delete restrict on update restrict;
create index ix_t_event_user_username on t_event_user (username);

alter table t_event_user add constraint fk_t_event_user_event_id foreign key (event_id) references t_events (id) on delete restrict on update restrict;
create index ix_t_event_user_event_id on t_event_user (event_id);


# --- !Downs

alter table t_events drop foreign key fk_t_events_organization_id;
drop index ix_t_events_organization_id on t_events;

alter table t_users drop foreign key fk_t_users_role_id;
drop index ix_t_users_role_id on t_users;

alter table t_users drop foreign key fk_t_users_org_id;
drop index ix_t_users_org_id on t_users;

alter table t_event_user drop foreign key fk_t_event_user_username;
drop index ix_t_event_user_username on t_event_user;

alter table t_event_user drop foreign key fk_t_event_user_event_id;
drop index ix_t_event_user_event_id on t_event_user;

drop table if exists t_events;

drop table if exists t_organizations;

drop table if exists t_roles;

drop table if exists t_users;

drop table if exists t_event_user;

