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