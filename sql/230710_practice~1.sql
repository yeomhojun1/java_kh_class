select* from EMPLOYEE;
select* from DEPARTMENT;
select* from JOB;
select* from LOCATION;
select* from SAL_GRADE;

select emp_name, length(emp_name), email, length(email) from employee;
select email, instr(email,'@', -1,1) 위치 from employee;
select substr('showmethemoney', 2,2) from dual;
select '가나다라'||'abcd' from dual;
select emp_name, hire_date, floor(months_between(sysdate, hire_date)) from employee;
select emp_name, to_char(hire_date,'yyyy-mm-dd') from employee;
select emp_no, emp_name, salary, nvl(bonus,0) from employee;
select emp_id, emp_name, emp_no, case when substr(emp_no,8,1)=1 then '남'
else '여' end as 성별 from employee;
select sum(salary) from employee where substr(emp_no,8,1)=1;
select sum(salary+(salary*nvl(bonus,0))*12) from employee where dept_code= 'D5';
select count(*) from employee;
select count(dept_code) from employee where dept_code='D5';
select dept_code, sum(salary) from employee;--오류발생
select dept_code, sum(salary) from employee group by dept_code;
select dept_code, sum(salary), floor(avg(salary)), count(*) from employee group by dept_code order by dept_code asc;
select dept_code, floor(avg(salary)) from employee group by dept_code having floor(avg(salary))>= 300000 order by dept_code;





