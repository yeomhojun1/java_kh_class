select * from user_tables;
select * from dept;
select * from emp;
select * from salgrade;
select * from national;
select * from bonus;
select* from employee;
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
select EXTRACT(year from substr(emp_no)),EXTRACT(month from emp_no),EXTRACT(day from emp_no)
from employee;
--16.EMPLOYEE테이블에서 사원명, 주민번호 조회 (단, 주민번호는 생년월일만 보이게 하고, '-'다음 값은 '*'로 바꾸기)
select emp_id, emp_no,rpad(substr(emp_no,8,'*'))
from employee;
--17. EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
--(단, 각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)
select emp_name, floor(abs(hire_date-sysdate)) 근무일수1,floor(abs(sysdate-hire_date)) 근무일수2
from employee;
--18. EMPLOYEE테이블에서 사번이 홀수인 직원들의 정보 모두 조회
select *
from employee
where mod(emp_id,2)=1;
--19. EMPLOYEE테이블에서 근무 년수가 20년 이상인 직원 정보 조회
select *
from employee
where months_between(sysdate,hire_date)>240;
--20.EMPLOYEE 테이블에서 사원명, 급여 조회 (단, 급여는 '\9,000,000' 형식으로 표시)
select emp_name,  '$'||trim(to_char(salary, '999,999,999,999'))
from employee;
--21. EMPLOYEE테이블에서 직원 명, 부서코드, 생년월일, 나이(만) 조회
--(단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 하며
--나이는 주민번호에서 출력해서 날짜데이터로 변환한 다음 계산)
select emp_name, dept_code, 
     substr(emp_no,1,2) ||'년' || substr(emp_no,3,2)||'월 '||substr(emp_no,5,2)||'일 '  "생년월일"
--만나이
    ,extract(year from sysdate)-extract(month from sysdate)-extract(day from sysdate)
--+substr(emp_no,5,2)
from employee;
select * from employee;
select to_date(substr(emp_no,1,6),'rrmmdd')
    ,  to_char(to_date(substr(emp_no,1,6),'rrmmdd'), 'yy"년" mm"월" dd"일"') "생년월일"
    , floor((sysdate - to_date(substr(emp_no,1,6), 'rrmmdd'))/365) "만나이"
    from employee;




--------------------------~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

---추후에 2페이지 끝에 다시해야함
--3페이지 1.아래와 같이 조회
select e.*, grade
from emp e
join salgrade s on e.sal>s.losal and e.sal<s.hisal
order by grade, empno;
--3페이지 2.
select e.*, grade
from emp e
join salgrade s  on e.sal between s.losal and s.hisal
where deptno in (20,30) 
order by grade desc, empno desc;
--3페이지  3
--DEPTNO가 20,30인 부서 사람들의 등급별 평균연봉
--조건 :    DEPTNO가 20,30인 부서 사람들의 평균연봉을 계산하도록 한다.
--    연봉 계산은 SAL*12+COMM
--    순서는 평균연봉이 내림차순으로 정렬한다.
select grade, avg(sal*12+nvl(comm,0)) a
from emp e
join salgrade s on e.sal between s.losal and s.hisal
where deptno in (20,30) 
group by grade order by 2 desc;
--3페이지 4.
--조건 :
--1. DEPTNO가 20,30인 부서 사람들의 평균연봉을 조회
--2. 연봉 계산은 SAL*12+COMM
--3. 순서는 평균연봉이 내림차순으로 정렬한다.
select deptno, avg(sal*12+nvl(comm,0)) a
from emp e
join salgrade s on e.sal between s.losal and s.hisal
where deptno in (20,30) group by deptno 
order by a desc;
--3페이지 Q. 5
--사원의 MGR의 이름을 아래와 같이 Manager컬럼에 조회 - 정렬
select e.empno, e.ename, e.job, e.mgr, m.ename
from emp e
join emp m on e.mgr = m.empno
order by e.empno;
--3페이지 Q. 6
--사원의 MGR의 이름을 아래와 같이 Manager컬럼에 조회 - 정렬
--단, Select 절에 SubQuery를 이용하여 풀이
select empno, ename,job, mgr, (select ename from emp m where m.empno=e.mgr)
from emp e
order by e.mgr, e.empno desc;
--3페이지 Q. 7
--MARTIN의 월급보다 많으면서 ALLEN과 같은 부서이거나 20번부서인 사원 조회
select empno, ename, job, mgr, hiredate, sal, comm,deptno
from emp
where sal >(select sal from emp where ename in 'MARTIN') and (deptno=(select deptno from emp where ename in 'ALLEN') OR DEPTNO=20);
--3페이지 Q. 8
--‘RESEARCH’부서의 사원 이름과 매니저 이름을 나타내시오.
SELECT ename, (select ename from emp m where e.mgr=m.EMPNO ) 
from emp e, dept d
where e.deptno=d.deptno and d.dname in 'RESEARCH'
ORDER BY 1 ASC;
--3페이지 Q. 9
--GRADE별로 급여을 가장 작은 사원명을 조회
select s.grade, e.ename 
from emp e, salgrade s
where (grade, sal) IN (select grade, min(sal) from emp, salgrade where sal >= losal and sal <= hisal group by grade);
--3페이지 Q. 10.
--GRADE별로 가장 많은 급여, 가장 작은 급여, 평균 급여를 조회
select s.grade, max(sal), min(sal), round(avg(sal),2)
from emp e, salgrade s
where sal between losal and hisal 
group by grade;
--3페이지 Q. 11
--GRADE별로 평균급여에 10프로내외의 급여를 받는 사원명을 조회 - 정렬
Create or replace view view_emp_salgrade 
as
select e.empno, e.ename, job, mgr, hiredate, sal, comm, deptno, grade, losal, hisal
    from emp e join salgrade s
        on e.sal between s.losal and s.hisal
;
select t1.grade, ename "10프로내외"
    from view_emp_salgrade t1
    where sal between (select avg(t2.sal) from view_emp_salgrade t2 where t2.grade = t1.grade)*0.9 
    and (select avg(t2.sal) from view_emp_salgrade t2 where t2.grade = t1.grade)*1.1
    order by t1.grade asc, 2 asc
;
-- group by 사용시 
-- select 컬럼명으로는 group by에 사용된 컬럼명 작성가능. 그리고 그룹함수 사용가능.
            select floor(avg(e2.sal)*0.9) minsal, floor(avg(e2.sal)*1.1) maxsal, floor(avg(e2.sal)) avgsal, s2.grade, s2.losal, s2.hisal
                from emp e2 join salgrade s2 on e2.sal between s2.losal and s2.hisal
                group by s2.grade , s2.losal, s2.hisal
                ;
--4페이지 1번
SELECT E.ENP_NAME, E.EMP_NO, D.DEPT_TITLE, J.JOB_NAME
FROM EMPLOYEE E
JOIN DEPT_ID ;
--4페이지 2. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회
select * 
from (  
    select e.emp_id, e.emp_name,  extract(year from sysdate)-extract(year from to_date(substr(emp_no,1,2),'rr')) age, 
    d.dept_title, j.job_name
    from employee e
    join department d on (e.dept_code= d.dept_id)
    join job j using (job_code)
    ) tb1
    where age = minage
    ;
--4페이지 3. 이름에 ‘형’이 들어가는 사원의 사원 코드, 사원 명, 직급 조회
SELECT E.EMP_ID, E.EMP_NAME, J.JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE=J.JOB_CODE
WHERE E.EMP_NAME LIKE ('%형%')
;
--4페이지 4. 부서코드가 D5이거나 D6인 사원의 사원 명, 직급 명, 부서 코드, 부서 명 조회
SELECT E.EMP_NAME, J.JOB_NAME, E.DEPT_CODE, D.DEPT_TITLE
FROM EMPLOYEE E
JOIN JOB J ON E.JOB_CODE= J.JOB_CODE
JOIN DEPARTMENT D ON D.DEPT_ID= E.DEPT_CODE
WHERE E.DEPT_CODE IN ('D5','D6');
--4페이지 5. 보너스를 받는 사원의 사원 명, 부서 명, 지역 명 조회
SELECT EMP_NAME, E.BONUS, DEPT_CODE, L.LOCAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON D.DEPT_ID= E.DEPT_CODE
JOIN LOCATION L ON L.LOCAL_CODE= D.LOCATION_ID
WHERE BONUS IS NOT NULL;
--4페이지 6. 사원 명, 직급 명, 부서 명, 지역 명 조회
SELECT EMP_NAME, J.JOB_NAME, D.DEPT_TITLE, L.LOCAL_NAME
FROM EMPLOYEE E
JOIN JOB J USING (JOB_CODE)
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON L.LOCAL_CODE = D.LOCATION_ID
ORDER BY D.DEPT_TITLE
;
--4페이지 7. 한국이나 일본에서 근무 중인 사원의 사원 명, 부서 명, 지역 명, 국가 명 조회
SELECT EMP_NAME, D.DEPT_TITLE, L.LOCAL_NAME, N.NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID
JOIN LOCATION L ON L.LOCAL_CODE = D.LOCATION_ID
JOIN NATIONAL N USING (NATIONAL_CODE)
WHERE NATIONAL_NAME IN ('한국','일본')
;
--4페이지 8. 한 사원과 같은 부서에서 일하는 사원의 이름 조회
SELECT E.EMP_NAME, M.DEPT_CODE, M.EMP_NAME
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.DEPT_CODE=M.DEPT_CODE AND M.EMP_NAME != E.EMP_NAME
;
--4페이지 9. 보너스가 없고 직급 코드가 J4이거나 J7인 사원의 이름, 직급 명, 급여 조회(NVL 이용)
SELECT EMP_NAME, J.JOB_NAME, E.SALARY
FROM EMPLOYEE E
JOIN JOB J USING (JOB_CODE)
WHERE E.BONUS IS NULL AND JOB_CODE IN ('J4','J7')
;
--4페이지 10. 보너스 포함한 연봉이 높은 5명의 사번, 이름, 부서 명, 직급, 입사일, 순위 조회
SELECT rownum,EMP_NO, EMP_NAME, DEPT_TITLE, JOB_NAME,HIRE_DATE,salary+(salary*nvl(bonus, 0 ))*12
FROM
(select * 
from employee e
JOIN DEPARTMENT D ON D.DEPT_ID=DEPT_CODE
JOIN JOB J USING (JOB_CODE)
ORDER BY 
    salary*12+(salary*nvl(bonus, 0 ))*12
     desc) 
where rownum <=5
;
--4페이지 11. 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서 명, 부서 별 급여 합계 조회
SELECT D.DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE=D.DEPT_ID
GROUP BY D.DEPT_TITLE HAVING SUM(SALARY)>= ((SELECT SUM(SALARY) FROM EMPLOYEE)/5)
;
--11-2. 인라인 뷰 사용
SELECT *
FROM (SELECT D.DEPT_TITLE, SUM(SALARY) A FROM EMPLOYEE E
JOIN DEPARTMENT D ON E.DEPT_CODE=D.DEPT_ID
GROUP BY D.DEPT_TITLE ) SUM1
WHERE SUM1.A >= ((SELECT SUM(SALARY) FROM EMPLOYEE)/5)
;
--11-3. WITH 사용
WITH B AS (SELECT D.DEPT_TITLE, SUM(SALARY) AS A 
    FROM EMPLOYEE E 
    JOIN DEPARTMENT D ON E.DEPT_CODE = D.DEPT_ID GROUP BY D.DEPT_TITLE) 
SELECT *
FROM B
WHERE B.A >= ((SELECT SUM(SALARY) FROM EMPLOYEE)*0.2);
--4페이지 12. 부서 명과 부서 별 급여 합계 조회
SELECT D.DEPT_TITLE, SUM(E.SALARY)
FROM EMPLOYEE E
JOIN DEPARTMENT D ON D.DEPT_ID= E.DEPT_CODE
GROUP BY D.DEPT_TITLE
;
WITH A1 AS (SELECT SUM(SALARY) AS SUM1, AVG(SALARY) AS AVG1 FROM EMPLOYEE)
SELECT *
FROM A1;
--춘대학교 1번
SELECT DEPARTMENT_NAME,  CATEGORY
FROM TB_DEPARTMENT
;
--춘대학교 2번
SELECT DEPARTMENT_NAME||'의 정원은'||CAPACITY||'명 입니다.' AS "학과별 정원"
FROM TB_DEPARTMENT
;
--춘대학교 3번
SELECT STUDENT_NAME
FROM TB_STUDENT s
JOIN TB_DEPARTMENT d USING (DEPARTMENT_NO)
where decode(substr(s.absence_yn,1),'1',
;
--춘대학교 기본 테이블
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_STUDENT;
SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_PROFESSOR;
SELECT * FROM TB_GRADE;
--춘대학교

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;
SELECT * FROM DEPARTMENT;

select e.emp_id, e.emp_name, extract(year from sysdate)-extract(year from to_date(substr(emp_no,1,2),'rr') "나이", 
d.dept_title, j.job_name
from employee e
join department d on (e.dept_code= d.dept_id)
join job j using (job_code)
;
select  extract(year from sysdate)-extract(year from to_date(substr(emp_no,1,2),'rr'))


select * from location;
select * from national;

--4페이지 8. 한 사원과 같은 부서에서 일하는 사원의 이름 조회
select e1.emp_name, e1.dept_code, e2.emp_name
    from employee e1
    join employee e2 on e1.dept_code=e2.dept_code and e1.emp_name <> e2.emp_name
  
    order by e1.emp_name
;


--춘대학교 2-4
select student_name, student_ssn, entrance_date from tb_student;
select * from(
select student_name, student_ssn, entrance_date
    , extract(year from to_date(substr(student_ssn,1,2),'rr')) birth
     , extract(year from entrance_date) entr
     ,extract(year from entrance_date) - extract(year from to_date(substr(student_ssn,1,2),'rr'))+1 aaa
    from tb_student) tb1
    where tb1.aaa>20;
select entrance_date
from tb_student;
--caseTjqhrl

select * from(
select student_name, student_ssn, entrance_date
    , case when (substr(student_ssn,1,2)) > 23 then substr(student_ssn,1,2)+1900
    else substr(student_ssn,1,2)+2000
    end birth
     , extract(year from entrance_date) entr
     ,extract(year from entrance_date) - extract(year from to_date(substr(student_ssn,1,2),'rr'))+1 aaa
    from tb_student) tb1
    where tb1.aaa>20;




---------------
select * from user_tables;
select * from dept;
select * from emp;
select * from salgrade;
select * from national;
select * from bonus;
select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;
--3페이지 11번
--select에서 rownum을 쓸때는 반드시 뒤에 별칭을 써줘야함
--별칭을 사용안하면 불려질때마다 새로운애가와서 원하는 값이 안나옴
--select에서 함수사용한 경우 반드시 별칭 
--생성먼저
-- 03- 11. GRADE별로 평균급여에 10프로내외의 급여를 받는 사원명을 조회 - 정렬
-- where 에 subquery 활용




--3페이지 12번 
--Q. 12
--지역 재난 지원금을 사원들에게 추가 지급
--조건 :
--1. NEW YORK지역은 SAL의 2%, DALLAS지역은 SAL의 5%, CHICAGO지역은 SAL의 3%,
--BOSTON지역은 SAL의 7%
--2. 추가지원금이 많은 사람 순으로 정렬
select empno, ename, sal, loc, sal+decode(loc, 'NEW YORK', SAL*0.02, 'DALLAS',SAL*0.05,'CHICAGO' ,SAL*0.03,'BOSTON', SAL*0.07, 0)
  
  
as sal_subsidy
from  emp e
    join dept d using (deptno)
--    order by decode(loc, 'NEW YORK', SAL*0.02, 'DALLAS',SAL*0.05,'CHICAGO' ,SAL*0.03,'BOSTON', SAL*0.07, 0) desc
    order by (sal_subsidy - sal) desc

;
select empno, ename, sal, loc
    case loc
        when 'NEW YORK' THEN SAL*0.02
        when 'DALLAS' THEN SAL*0.05
        when 'CHICAGO' THEN SAL*0.03
        when 'BOSTON' THEN SAL*0.07
    END 
as sal_subsidy
from  emp
    join dept using (deptno)
--    where 
--    group by
--    having
--    order by 
;






--테이블들
select * from user_tables;
select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;