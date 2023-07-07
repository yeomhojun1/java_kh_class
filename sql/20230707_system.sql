select * from user_tables;
--
--create 명령어 - DDL 데이터 정의어
create user c##scott identified by tiger;
drop user c##scott;
--21g xe 버젼 , dba 추가 "_ORACLE_SCRIPT"=true; 셋 해줘야함
alter session set "_ORACLE_SCRIPT"=true;
create user kh identified by kh;
create user scott identified by tiger;
--DCL
--create session, create table처럼 각각의 권한명을 모두 나열하여 적기 힘듬..
--권한을 묶어서 만들어둔 롤role 을 사용하여 권한을 부여함.
--connect- 접속관련 권한들이 있는 role
--resource- 자원(table,view 등 객체)관련 권한들이 있는 role
grant connect, resource to c##scott kh;
grant connect, resource to kh;
revoke connect, resource from kh;
grant connect, resource to scott kh;
--21g xe 버젼 , dba 추가
grant connect, resource, dba to scott, kh;
