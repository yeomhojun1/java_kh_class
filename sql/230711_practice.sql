select * from user_tables;
select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;

SELECT * FROM EMP;
--1. EMP테이블에서 COMM 의 값이 NULL이 아닌 정보 조회
SELECT *
FROM EMP
WHERE COMM IS NOT NULL;
--2. EMP테이블에서 커미션을 받지 못하는 직원 조회
SELECT *
FROM EMP
where comm is null or comm=0;
--3. EMP테이블에서 관리자가 없는 직원 정보 조회
SELECT *
FROM EMP
where mgr is NULL;
--4. EMP테이블에서 급여를 많이 받는 직원 순으로 조회
SELECT *
FROM EMP
order by sal desc;
--5. EMP테이블에서 급여가 같을 경우 커미션을 내림차순 정렬 조회
SELECT *
FROM EMP
order by sal desc, comm desc;
--6. EMP테이블에서 사원번호, 사원명, 직급, 입사일 조회 (단, 입사일을 오름차순 정렬 처리)
SELECT empno, ename, job, hiredate
FROM EMP
order by hiredate asc;
--7. EMP테이블에서 사원번호, 사원명 조회 (사원번호 기준 내림차순 정렬)
SELECT empno, ename
FROM EMP
order by empno desc;
--8. EMP테이블에서 사번, 입사일, 사원명, 급여 조회
--(부서번호가 빠른 순으로, 같은 부서번호일 때는 최근 입사일 순으로 처리)
SELECT empno, hiredate, ename, sal
FROM EMP
order by deptno asc, hiredate desc;
--9. 오늘 날짜에 대한 정보 조회
select sysdate from dual;
--10. EMP테이블에서 사번, 사원명, 급여 조회
--(단, 급여는 100단위까지의 값만 출력 처리하고 급여 기준 내림차순 정렬)
SELECT empno, ename, trunc(sal,-2)
FROM EMP
order by sal desc;
--11. EMP테이블에서 사원번호가 홀수인 사원들을 조회
SELECT *
FROM EMP
where mod(empno,2)=1;
--12. EMP테이블에서 사원명, 입사일 조회 (단, 입사일은 년도와 월을 분리 추출해서 출력)
SELECT ename, EXTRACT(year from hiredate), EXTRACT(month from hiredate)
FROM EMP;
--13. EMP테이블에서 9월에 입사한 직원의 정보 조회
SELECT *
FROM EMP
where EXTRACT(month from hiredate)=9;
--14. EMP테이블에서 81년도에 입사한 직원 조회
SELECT *
FROM EMP
where EXTRACT(year from hiredate)=1981;
--15. EMP테이블에서 이름이 'E'로 끝나는 직원 조회
SELECT *
FROM EMP
where ename like '%E';
--16. EMP테이블에서 이름의 세 번째 글자가 'R'인 직원의 정보 조회
SELECT *
FROM EMP
where ename like '__R%';
--방법 2번째
select * from emp where substr(ename, 3, 1) = 'R';
--17. EMP테이블에서 사번, 사원명, 입사일, 입사일로부터 40년 되는 날짜 조회
SELECT empno, ename, hiredate, add_months(hiredate, 480)
FROM EMP
;
--18. EMP테이블에서 입사일로부터 38년 이상 근무한 직원의 정보 조회
select *
from emp
where months_between(sysdate,hiredate)>38;
--19. 오늘 날짜에서 년도만 추출
select EXTRACT(year from sysdate) from dual;
--2페이지
select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;
--1. JOB 테이블의 모든 정보 조회
select *
from job;
--2. JOB 테이블의 직급 이름 조회
select job_name
from job;
--3. DEPARTMENT 테이블의 모든 정보 조회
select *
from department;
--4. EMPLOYEE테이블의 직원명, 이메일, 전화번호, 고용일 조회
select emp_name,email, phone, hire_date
from employee;
--5. EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회
select  hire_date,emp_name,salary
from employee;
--6. EMPLOYEE테이블에서 이름, 연봉, 총수령액(보너스포함), 실수령액(총수령액 - (연봉*세금 3%)) 조회
select  emp_name,salary*12 연봉, salary*12+salary*nvl(bonus,0) 총수령액, salary*12+salary*12*nvl(bonus,0)-(salary*12*0.03) 실수령액
from employee;
--7. EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회
select emp_name, salary, hire_date, phone
from employee
where sal_level='S1';
--8. EMPLOYEE테이블에서 실수령액(6번 참고)이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
select emp_name,salary, salary*12+salary*12*nvl(bonus,0)-(salary*12*0.03), hire_date
from employee
where salary*12+salary*12*nvl(bonus,0)-(salary*12*0.03)>=50000000;
--9. EMPLOYEE테이블에 월급이 4000000이상이고 JOB_CODE가 J2인 사원의 전체 내용 조회
select *
from employee
where salary>=4000000 and job_code='J2';
--10. EMPLOYEE테이블에 DEPT_CODE가 D9이거나 D5인 사원 중
--고용일이 02년 1월 1일보다 빠른 사원의 이름, 부서코드, 고용일 조회
select emp_name, dept_code,hire_date
from employee
where dept_coDE IN ('D9','D5') AND HIRE_DATE < TO_DATE(20020101, 'YYYYMMDD');
--11. EMPLOYEE테이블에 고용일이 90/01/01 ~ 01/01/01인 사원의 전체 내용을 조회
select *
from employee
where HIRE_DATE between TO_DATE(19900101, 'YYYYMMDD') and TO_DATE(20010101, 'YYYYMMDD');
--12. EMPLOYEE테이블에서 이름 끝이 '연'으로 끝나는 사원의 이름 조회
select emp_name
from employee
where emp_name like '__연%';
--13. EMPLOYEE테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회
select emp_name, phone
from employee
where substr(phone, 1,3) != '010';
--14. EMPLOYEE테이블에서 메일주소 '_'의 앞이 4자이면서 DEPT_CODE가 D9 또는 D6이고
--고용일이 90/01/01 ~ 00/12/01이고, 급여가 270만 이상인 사원의 전체를 조회
select *
from employee
where email like '____#_%' escape '#' and dept_code in ('D9','D6') and 
HIRE_DATE between TO_DATE(19900101, 'YYYYMMDD') and TO_DATE(20001201, 'YYYYMMDD')
and salary>=2700000;
--15. EMPLOYEE테이블에서 사원 명과 직원의 주민번호를 이용하여 생년, 생월, 생일 조회
select 



--테이블들
select * from user_tables;
select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;