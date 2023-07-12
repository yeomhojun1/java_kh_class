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
INSERT INTO USER_NOTNULL VALUES(1, 'user01', 'pass01', '홍길동', '남', '010-1234-5678’,
‘hong123@kh.or.kr’)
;



