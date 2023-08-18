create extension if not exists "uuid-ossp";
create table dummy
(
    id          uuid                  not null primary key default uuid_generate_v4(),
    text        varchar(200)
)