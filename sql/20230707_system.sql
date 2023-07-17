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

select *
from emp
where dept = 10 or deptno = 20
;
select *
from emp
where deptno != 10 and deptno != 20
;

SELECT *
FROM EMP
WHERE MGR IS NULL AND COMM IS Null;

SELECT *
FROM EMP
WHERE deptno in (20,30);

select ename, sal, job
from emp
where job in ('ANALYST', 'SALESMAN')
AND SAL>= 2500;

--사원명의 길이와 byte크기를 조회
select length(ename)
    from emp
    ;
    
select length('a')
    from emp
    ;
select length(trim('a안 녕b')), lengthb('a안녕b')
from dual
--테이블 dual은 임시테이블로 연산이나 간단한 함수 결과값을 조회할 때 사용
--trim은 앞뒤에있는 스페이스를 없애줌 대신 문장안에있는 스페이스를 없애주지는 못함
;

select trim(ename, 's') from emp
;

select Lpad(ename,7, 's') from emp;

select ename||comm from emp;
select concat(ename, comm) from emp; --두개는 동일한 결과를 가짐
select concat(sal,'달러') from emp;


select replace(ename, 'SM', 'A') from emp;

SELECT SYSDATE FROM DUAL;
SELECT  hiredate, ADD_MoNTHS(hiredate, 1) FROM EMP; 

select sysdate, to_char(sysdate,'yyyy.mm.dd(dy) hh24:mi:ss') from dual;
select sysdate, to_char(sysdate,'yyyy.mm.dd(day)') from dual;
alter session set NLS_DATE_FORMAT = 'YYYY-mm-dd hh24:mi:ss';
select sysdate from dual;
select * from emp;
select add_months(to_date('2023091113', 'yyyymmddhh24'), 5) from dual;
select next_day(to_date('2023091113', 'yyyymmddhh24'), '일') from dual;
select next_day(to_date('2023091113', 'yyyymmddhh24'), 4) from dual;
select last_day(to_date('2023091113', 'yyyymmddhh24')) from dual;

select to_char(empno,'000000'), '$'||trim(to_char(sal, '999,999,999,999')) from emp;
select to_number('123-4567-8901', '999-9999-9999') from dual;

-- 직원들의 평균 급여는 얼마인지 조회
select avg(sal) 평균급여 from emp;
select sum(sal) 평균급여 from emp;
select max(sal) 평균급여 from emp;
select min(sal) 평균급여 from emp;
--부서별 평균 급여 조회
select avg(sal) 평균급여, deptno 부서 from emp group by deptno;
select sum(sal) sum, job from emp group by job;
select max(sal) max, job from emp group by job;
select min(sal) min, job from emp group by job;

select count(job) count, job from emp group by job;
select count(*) count, job from emp group by job;

select avg(sal) 평균급여
--job ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
from emp
where job ='ANALYST'
;
select avg(sal) 평균급여, JOB
from emp
group by job
having job='ANALYST'
;
--job이 analyst인 부서별 직원의 평균 급여 조회
select job, deptno
    from emp
    where job = 'analyst';
select job, deptno, ename
    from emp
    where job = 'CLERK';
select job, deptno, avg(sal)
    from emp
    where job = 'CLERK'
    GROUP BY DEPTNO,JOB;
    
select count(distinct dept_code) from employee;

select * from emp
order by sal desc, deptno, job
;

select sal, sal*12+nvl(comm,0) salcomm
from emp
order by salcomm desc, sal asc
;
--job 오름차순
select * from emp
    order by 3;

select deptno 부서, sum(sal) 급여합계, avg(sal) 평균급여  from emp group by deptno;
select  count(comm) from emp where comm is not null ;
select * from emp;
--실전 연습
select * from emp where comm is not null;
select * from emp where comm is null or comm=0;
select * from emp where mgr is null;
select * from emp order by sal desc;
select * from emp order by sal desc, comm asc;

--수업
select * from dept;
select * from emp;
select emp.ename, emp.deptno, dept.dname, dept.loc 
    from emp
    join dept using (deptno)
    ;
    
    
    
select ename, dept.deptno, dname, loc
FROM emp, dept
where emp.deptno= dept.deptno
    and loc='DALLAS';

SELECT EMPNO, LOC
    FROM DEPT CROSS JOIN EMP
    ;
    
SELECT * FROM EMP;
SELECT * FROM SALGRADE;
--사원의 이름, 사번, sal, grade를 조회
select ename, empno, sal, grade 등급
from emp e
join salgrade s on e.sal between s.losal and s.hisal
order by s.grade desc, e.sal
;



select empno, ename mgr from emp;
select e.empno, e.ename, m.empno, m.ename mgrname 
from emp e 
join emp m on e.empno= m.mgr
;
select ename from emp where empno=7566;

create table t1(c1 char(5), c2 varchar2(5));
insert into t1 values('12','12');
commit;
select length(c1), length(c2)from t1;

DESC T1;
DESC EMP;
--ERD(entity relationship diagram)
--uml - classDiagram, erd

SELECT * FROM EMP;

SELECT EMPNO, ENAME,JOB
FROM EMP
WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO);

SELECT EMPNO, ENAME,JOB, HIREDATE
FROM EMP
WHERE (DEPTNO, JOB) IN (SELECT DEPTNO, JOB FROM EMP WHERE SAL>2000 AND COMM>200);

SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE (JOB, SAL) IN (SELECT JOB,MAX(SAL) FROM EMP GROUP BY JOB) ORDER BY 3;

--SELECT ENAME, JOB, SAL
--FROM EMP E
--WHERE SAL IN (SELECT MAX(SAL) FROM EMP GROUP BY DEPTNO)
--WHERE ENAME IN (SELECT ENAME FROM EMP WHERE LIKE 'E');

SELECT * FROM EMP WHERE DEPTNO IN (20,30) 
ORDER BY ENAME ASC
;
SELECT ROWNUM,E.* FROM EMP E WHERE DEPTNO IN(20,30) ORDER BY ENAME ASC;
SELECT ROWNUM,E.* FROM EMP E WHERE DEPTNO IN(20,30) ;

SELECT ROWNUM,E.* 
FROM (SELECT * FROM EMP ORDER BY ENAME ASC) E WHERE DEPTNO IN(20,30);

--1PAGE 1-3
SELECT ROWNUM,E.* 
FROM (SELECT * FROM EMP WHERE DEPTNO IN(20,30) ORDER BY ENAME ASC) E;

SELECT ROWNUM,E.* 
FROM (SELECT * FROM EMP WHERE DEPTNO IN(20,30) ORDER BY ENAME ASC) E
WHERE ROWNUM BETWEEN 1 AND 3
;
--오류남 왜나면 SELECT에서 RNUM을 선언했는데 그 전에 수행되는 WHERE에 RNUM이 있어서 인식못함
SELECT ROWNUM RNUM,E.* 
FROM (SELECT * FROM EMP WHERE DEPTNO IN(20,30) ORDER BY ENAME ASC) E
WHERE RNUM BETWEEN 4 AND 6
;

SELECT *
FROM (SELECT ROWNUM RNUM, E.*
    FROM(SELECT * FROM EMP WHERE DEPTNO IN (20,30) ORDER BY ENAME ASC) E
    )
    WHERE RNUM BETWEEN 7 AND 9;
    
WITH ABC AS (SELECT ROWNUM RNUM, E.*
    FROM (SELECT * FROM EMP WHERE DEPTNO IN (20,30) ORDER BY ENAME ASC) E)
SELECT *
FROM ABC
WHERE RNUM BETWEEN 7 AND 9;
    
WITH ABC AS (SELECT ROWNUM RNUM, E.*
    FROM (SELECT * FROM EMP WHERE DEPTNO IN (20,30) ORDER BY ENAME ASC) E)
SELECT *
FROM ABC
WHERE RNUM BETWEEN 7 AND 9 
--ABC가 마치 새로운 테이블 처럼 사용가능함.
--AND SAL>(SELECT AVG(SAL) FROM ABC)
;
CREATE VIEW VIEW_ABC
AS
SELECT ROWNUM RNUM, E.*
    FROM (SELECT * FROM EMP WHERE DEPTNO IN (20,30) ORDER BY ENAME ASC) E;

SELECT * FROM VIEW_ABC;

select empno, ename, sal
from emp
where sal < all(select sal from emp where job = 'SALESMAN');
--관리자로 등록되어있는 사원들을 조회
select empno, ename
from emp e
--여기까지 메인쿼리
where exists(select empno from emp e2 where e.empno=e2.mgr);
--exist아래잇는 select는 상관커리, 그리고 join이랑 같은 상황
select * from emp;
select  distinct e.empno, e.ename
from emp e join emp e2
on e.empno= e2.mgr;
--join 대비 상관커리(exist)를 쓰면 속도가 매우 빨라짐

--부서 번호가 30인 사원들으 ㅣ급여와 부서번호를 묶어 메인 쿼리로 전달해보자
select *
    from emp e
    where(deptno,sal) in (select deptno, sal from emp e2 where deptno=30)
;
--부서별 평균급여와 직원들 정보를 조회해주세요
select e.*,
--스칼라 서브쿼리 작성되어야함.
    (select trunc(avg(sal)) from emp e2 where e2.deptno=e.deptno) 평균
from emp e
order by deptno asc
;
--select e.*,
--    case e.deptno
--        when 10 then (select trunc(avg(sal)) from emp e2 where e2.deptno=10)
--         when 20 then (select trunc(avg(sal)) from emp e2 where e2.deptno=20)
--          when 30 then (select trunc(avg(sal)) from emp e2 where e2.deptno=30)
--        end
--        from emp e;
--직원 정보와 부서번호, 부서명, 부서위치
select ename, deptno, dname, loc
from emp  join dept using (deptno)
;

select ename, deptno, 
    (select dname from dept d where e.deptno= d.deptno) 직업,
     (select loc from dept d where e.deptno= d.deptno) 위치
from emp e
;
--SALESMAN과 'MANAGER'를 조회해쥇요
SELECT * FROM EMP
WHERE JOB='SALESMAN' OR JOB= 'MANAGER';
SELECT * FROM EMP
WHERE JOB IN('SALESMAN', 'MANAGER');
SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB='SALESMAN' 
UNION
SELECT MGR,ENAME,JOB FROM EMP WHERE JOB='MANAGER';
--급여가 1000미만인 직원, 2000미만인 직원 조회-중복 포함 결과
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL<1000 
UNION ALL
SELECT  EMPNO,ENAME,SAL FROM EMP WHERE SAL<2000; 
--급여가 1000초과인 직원, 2000미만인 직원 조회-중복 포함 결과
SELECT EMPNO,ENAME,SAL FROM EMP WHERE SAL>1000 
INTERSECT
SELECT  EMPNO,ENAME,SAL FROM EMP WHERE SAL<2000; 
--급여가 2000미만인 직원을 제외하고 조회-MINUS
SELECT EMPNO,ENAME,SAL FROM EMP ;
MINUS
SELECT  EMPNO,ENAME,SAL FROM EMP WHERE SAL<2000; 
--NOT EXISTS
SELECT EMPNO,ENAME,SAL FROM EMP E
    WHERE NOT EXISTS(SELECT EMPNO,ENAME,SAL FROM EMP WHERE E.SAL<2000);


SELECT * FROM EMPLOYEE;
SELECT DEPT_CODE, JOB_CODE, mANAGER_ID, FLOOR(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE, MANAGER_ID;



DESC USER_CONSTRAINTS;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_TABLES;
SELECT * FROM USER_VIEWS;
--NOT NULL예시
CREATE TABLE USER_NOTNULL(

USER_NO NUMBER NOT NULL,
USER_ID VARCHAR2(20) NOT NULL,
USER_PWD VARCHAR2(30) NOT NULL,
USER_NAME VARCHAR2(30),
GENDER VARCHAR2(10),
PHONE VARCHAR2(30),
EMAIL VARCHAR2(50)

);

--t2테이블이 없음에도 view 생성
create or replace force view view_test2
    as select * from t2 ;
create or replace view view_emp_readonly
    as
        select * from emp
        with read only
        ;
insert into view_emp_readonly(empno, ename, deptno) values ( 8100, 'EJEJ', 30);

create or replace VIEW VIEW_EMP_CHECKOPTION
AS
SELECT * FROM EMP
WHERE DEPTNO=30
WITH CHECK OPTION;
SELECT * FROM VIEW_EMP_CHECKOPTION;
UPDATE VIEW_EMP_CHECKOPTION SET DEPTNO=20 WHERE EMPNO= 7499;
UPDATE VIEW_EMP_CHECKOPTION SET COMM=350 WHERE COMM= 7499;
UPDATE EMP SET DEPTNO=20 WHERE EMPNO= 7499;

CREATE SEQUENCE SEQ_T1;

SELECT SEQ_T1.NEXTVAL FROM DUAL;
SELECT SEQ_T1.CURRVAL FROM DUAL;
--SEQUENCE의 NEXTVAL은 UNIQUE한 값에 INSERT 시에 활용됨
--SEQUENCE 이름을 지을 때 SEQ_테이블명_컬럼명 
--예를 들어 emp테이블에 넣을 때는 SEQ_EMP_EMPNO
--INSERT INTO EMP VALUES (SEQ_EMP_EMPNO.nextval , '홍길동',...
SELECT * FROM USER_SEQUENCES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONS_COLUMNS;

--함수기반 INDEX
CREATE INDEX IDX_EMP_SAL ON EMP(SAL);
--WHERE 절에 SAL*12>5000 처럼 조건문에 사용이 빈번할 때 INDEX를 걸어줌
CREATE INDEX IDX_EMP_SAL ON EMP(SAL*12);
--WHERE 절에 SAL*12>5000 AND COMM > 200 처럼 조건문에 사용이 빈번할 때 INDEX를 걸어줌
CREATE INDEX IDX_EMP_SAL_COMM ON EMP(SAL, COMM);
SELECT * FROM EMP WHERE SAL>3000 AND COMM IS NOT NULL;
--BIT기반 INDEX도 있음
CREATE BITMAP INDEX IDX_EMP_SAL ON EMP(SAL);
CREATE BITMAP INDEX IDX_EMP_SAL_COMM ON EMP(SAL,COMM);

ALTER INDEX PK_EMP REBUILD;

SELECT * FROM KH.DEPT;

SELECT * FROM USER_SEQUENCES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_IND_COLUMNS;
SELECT * FROM USER_CONSTRAINTS;
SELECT * FROM USER_CONS_COLUMNS;

CREATE SYNONYM EMPLOYEE FOR EMP;
CREATE SEQUENCE SEQ_TB1_C1 STart WITH 10 INCREMENT BY 10 MAXVALUE 90 MINVALUE 10 NOCYCLE CACHE 20;
--ORA-08002: 시퀀스 SEQ_TB1_C1.CURRVAL은 이 세션에서는 정의 되어 있지 않습니다
--왜냐면 
--08002. 00000 -  "sequence %s.CURRVAL is not yet defined in this session"
--*Cause:    sequence CURRVAL has been selected before sequence NEXTVAL
--*Action:   select NEXTVAL from the sequence before selecting CURRVAL
SELECT SEQ_TB1_C1.CURRVAL FROM DUAL;
SELECT SEQ_TB1_C1.NEXTVAL FROM DUAL;
--ORA-08004: 시퀀스 SEQ_TB1_C1.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
--MAXVALUE에서 한번더 NEXTVAL을 입력하면 NOCYCLE이기 때문에 오류가 나옴
--08004. 00000 -  "sequence %s.NEXTVAL %s %sVALUE and cannot be instantiated"
--*Cause:    instantiating NEXTVAL would violate one of MAX/MINVALUE
--*Action:   alter the sequence so that a new value can be requested

--ROLE
--접속관련된 설정-ORACLE 12 이후 버젼에서 FALSE 상태로 접속됨, 그래서 TRUE로 바꾼상태에서 해야함
ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;
CREATE ROLE SCOTTROLE1;
CREATE ROLE ROLE_SCOTT_MANAGER;
CREATE USER KH2 IDENTIFIED BY KH2;
CREATE ROLE ROLE_MANAGER;

GRANT CONNECT, RESOURCE TO KH2;
--CONNECT-- 롤 이름
--권한들으 ㅣ묶음= 롤
--CREATE SESSION--접속권한
--CONNECT를 포함하는것은 
--CREATE TABLE,ALTER TABLE,DROP TABLE, CREATE VIEW, DROP VIEW, CREATE SEQUENCE,...
--공간 SPATCE를 사용한 ㄴ권한들을 묶어서 RESOURCE 롤에 지정함
GRANT CREATE TABLE, CREATE VIEW TO ROLE_MANAGER;
--GRANT 권한명, 권한명,...롤명, 롤명,.. TO 롤명;
GRANT ROLE_MANAGER TO KH2;
--롤 매니저에게 줬던 CREATE VIEW 권한을 뺏어옴
REVOKE CREATE VIEW FROM ROLE_MANAGER;





SELECT * FROM all_users;
SELECT * FROM user_tables;
SELECT * FROM user_constraints;
SELECT * FROM user_users;