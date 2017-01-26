conn sys as sysdba;

drop user nh;
create user nh identified by rm;

grant create dba to nh;

drop table wiki_page;
create table wiki_page(name varchar2(100) primary key,content varchar2(2000),update_time varchar2(100) default sysdate);

