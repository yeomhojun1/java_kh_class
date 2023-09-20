desc board;
select * from member;
ALTER table member add enabled number(1) default 1;
ALTER table member add authority char(3) default 'R_A';
update table member add mpwd varchar2(80);