-- JoinColumn
create table address (id integer generated by default as identity, primary key (id));
create table employee (id integer generated by default as identity, addrs_id integer, primary key (id));
alter table if exists employee drop constraint if exists addrs_id_fk;
alter table if exists employee add constraint addrs_id_uq unique (addrs_id);
alter table if exists employee add constraint addrs_id_fk foreign key (addrs_id) references address;
