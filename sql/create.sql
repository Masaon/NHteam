conn sys as sysdba;

drop user nh cascade;
create user nh identified by rm;

grant create table to nh;
grant create user to nh;
grant create view to nh;
grant create session to nh;
grant dba to nh;

conn nh /rm;

drop table wiki_page;
create table wiki_page(name varchar2(100) primary key,content varchar2(2000),update_time varchar2(100) default sysdate);
