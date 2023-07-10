select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;
--급여를 350000보다 많고 400000보다 적은사람 직원이름과 급여 조회

select EMP_Name, SALARY
from EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

select EMP_Name, SALARY
from EMPLOYEE
WHERE EMP_NAME LIKE '전%';

select EMP_Name, EMAIL
from EMPLOYEE
WHERE phone LIKE'___7%';

select EMP_Name, email, emp_no
from EMPLOYEE
WHERE EMP_NAME NOT LIKE '이%';

select EMP_Name
from EMPLOYEE
WHERE manager_id IS NULL AND dept_code IS NULL;

select EMP_Name
from EMPLOYEE
WHERE dept_code IS NULL AND bonus IS NOT NULL;

select EMP_Name
from EMPLOYEE
WHERE job_code LIKE 'J1';

select EMP_Name
from EMPLOYEE
WHERE ENAME LIKE '__@@_' ESCAPE '@';

select length(emp_name) len, length(emp_name) byteLen
    from employee
    ;

select email, instr(email, '@',8)위치 
from employee;

-- email 은 @ 이후에 .이 1개이상 있어야함.
select email, instr(email, '@'), instr(email, '.', instr(email, '@'))위치 
from employee
where instr(email,'.', instr(email, '@')) <>0;

select INSTR('ORACLEWELCOME','O', 2)
FROM DUAL;
select INSTR('ORACLEWELCOME','O', 1,2)
FROM DUAL;
select INSTR('ORACLEWELCOME','O',1,3)
FROM DUAL;
select INSTR('ORACLEWELCOMEOKEY','O',3,2)
FROM DUAL;
--SYSDATE는 함수는 아니나 명령어가 실행되는 시점에 결과값을 출력해줘서 함수호출과 같은 느낌임

select emp_name,emp_no,decode(substr(emp_no,8,1),2,'여',3,'남',4,'여',1, '남','그외') as "성별"
from employee
;
select substr(emp_no,8,1) from employee; 

select(substr(emp_no, 8,3) from employee;

if(substr(emp_no,8,1)==2){
return "여";
} else if(substr(emp_no,8,1)==1){
return "남";
}else if(substr(emp_no,8,1)==3){
return "남";
}else if(substr(emp_no,8,1)==4){
return "여";}else{
return "그외";
}

select emp_name,emp_no,
case to_number( substr(emp_no,8,1))
    when substr(emp_no,8,1)=2 then '여'
    when substr(emp_no,8,1)=1 then '남'
     when substr(emp_no,8,1)=4 then '여'
    when substr(emp_no,8,1)=3 then '남'
    else '그외'
    end
    as "성별"
from employee
;
select emp_name,emp_no,
case  substr(emp_no,8,1)
    when '1' then '남'
   when '2' then '여'
   when '3' then '남'
   when '4' then '여'
    else '그외'
    end
    as "성별"
from employee
;
select avg(salary) 평균급여 from employee;
select floor(avg(salary)) 평균급여 from employee;
select round(avg(salary)) 평균급여 from employee;
select ceil(avg(salary)) 평균급여 from employee;
select trunc(avg(salary),2) 평균급여 from employee;

select count(distinct dept_code) from employee;
select count(dept_code) from employee;--21
select count(*) from employee;--23
select count(*) from employee where dept_code is null;
select* from employee group by dept_code;--23
select count(dept_code), dept_code from employee group by dept_code;
--count 는 resultset의 row값이 null이라면 count 하지않음
--아래 식은 null이 몇개인지 아는것
select count(dept_code), count(bonus) from employee where dept_code is null;
--distinct는 중복값을 1개로 보고 인정함

select count(dept_code), count(distinct dept_code)
from employee;




