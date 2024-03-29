--학원이름
INSERT into ACADEMY (ACA_NO, ACA_NAME, ACA_PHONE,ACA_ADDRESS) VALUES ('A001','염호준수학','01012345678','강남역');

--멤버 정보
INSERT into ACA_MEMBER (MID, MPWD, MTYPE) VALUES ('T00001','TP00001','T');
INSERT into ACA_MEMBER (MID, MPWD, MTYPE) VALUES ('T00002','TP00002','T');
INSERT into ACA_MEMBER (MID, MPWD, MTYPE) VALUES ('T00003','TP00003','T');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001001', 'SA001001', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001002', 'SA001002', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001003', 'SA001003', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001004', 'SA001004', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001005', 'SA001005', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001006', 'SA001006', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001007', 'SA001007', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001008', 'SA001008', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001009', 'SA001009', 'S');
INSERT INTO ACA_MEMBER (MID,MPWD,MTYPE) VALUES ('SA001010', 'SA001010', 'S');
--선생님 정보
INSERT INTO TEACHER (MID,TEACHER_NAME,ENTRANCE_DATE,ACA_NO) VALUES ('T00001', '염호준', '230728', 'A001');
INSERT INTO TEACHER (MID,TEACHER_NAME,ENTRANCE_DATE,ACA_NO) VALUES ('T00002', '이지영', '220101', 'A001');
INSERT INTO TEACHER (MID,TEACHER_NAME,ENTRANCE_DATE,ACA_NO) VALUES ('T00003', '김종호', '180525', 'A001');
--학생정보
INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001001', '천영준', 100, to_date('950303','yyMMDD'), to_date('200511','yyMMDD'),'특이사항 없음','T00001','01012345678');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001002', '손범규', 85, to_date('911026','yyMMDD'), to_date('201130','yyMMDD'),'교실불을 자주꺼줌','T00001','01098765432');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001003', '유청하', 85, to_date('930219','yyMMDD'), to_date('201130','yyMMDD'),'특이사항 없음','T00001','01054896213');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001004', '남궁하진', 70, to_date('960405','yyMMDD'), to_date('181230','yyMMDD'),'특이사항 없음','T00002','01075131333');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001005', '유수현', 90, to_date('900822','yyMMDD'), to_date('110930','yyMMDD'),'잘 알려줌','T00002','01098785531');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001006', '조민지',85 , to_date('900131','yyMMDD'), to_date('161116','yyMMDD'),'특이사항 없음','T00002','01045446623');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001007', '박유림', 85 , to_date('960317','yyMMDD'), to_date('170726','yyMMDD'),'특이사항 없음','T00003','01078789120');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001008', '임지연', 100 , to_date('990628','yyMMDD'), to_date('230726','yyMMDD'),'놀리기 좋음','T00003','01066323202');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001009', '백의헌', 55 , to_date('941002','yyMMDD'), to_date('221002','yyMMDD'),'수염이 멋짐','T00003','01033675423');

INSERT INTO ACA_STUDENT (MID2, STUDENT_NAME, EXAM_SCORE,BIRTHDAY, ENTER_DATE, IMPORTANT, MID, TELE) VALUES ('SA001010', '신정훈', 60 , to_date('970909','yyMMDD'), to_date('200122','yyMMDD'),'특이사항 없음','T00003','01076111121');



--학생 주차별 정보
--천영준
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00001', 'SA001001', '일차방정식 활용','일차방정식에서 소금물 문제','특이사항없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00001', 'SA001001', '일차방정식 활용','일차방정식에서 소금물 문제','농도 공식을 잘 못외움', '100%',80);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00001', 'SA001001', '일차방정식 활용','일차방정식에서 거리속력시간 문제','특이사항없음', '100%',90);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00001', 'SA001001', '일차방정식 활용','일차방정식에서 거리속력시간 문제','시간공식과 거리공식을 헷갈림', '100%',80);
--손범규
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00001', 'SA001002', '경우의 수','전체 경우의 수를 계산','문제이해능력이 약간 부족해서 문제를 차근차근 읽어보는 습관을 들게함', '100%',90);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00001', 'SA001002', '경우의 수','주어진 경우의 수를 계산','특이사항 없음', '100%',95);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00001', 'SA001002', '경우의 수','확률이 0인 경우와 1인경우를 구분하는 문제','특이사항 없음', '100%',90);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00001', 'SA001002', '경우의 수','주어진 상황을 확률로 계산하고 동시에일어나는 확률을 구함','한가지 상황은 잘 푸나 여러가지 상황이 겹치는 경우 어려워함', '100%',70);
--유청하
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00001', 'SA001003', '분수의 덧셈과 뺄셈','분모가 같은 경우 분수의 덧셈과 뺄셈','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00001', 'SA001003', '분수의 덧셈과 뺄셈','그림을 통해 분수의 개념을 확실히 함','특이사항 없음', '100%',80);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00001', 'SA001003', '분수의 덧셈과 뺄셈','분모가 다른경우를 위해 통분과 약분을 배움','두 분모를 통분시켜주는걸 어려워함', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00001', 'SA001003', '분수의 덧셈과 뺄셈','분모가 다른경우를 위해 통분과 약분을 배움','저번주 부분을 어려워해서 이번주에 다시 복습', '100%',100);
--남궁하진
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00002', 'SA001004', '도형의 합동과 닮음','합동의 정의를 배우고 SSS,SAS,ASA 닮음을 익힘','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00002', 'SA001004', '도형의 합동과 닮음','합동의 정의를 배우고 SSS,SAS,ASA 닮음을 익힘','이번주 감기로 전부 결석', '0%',0);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00002', 'SA001004', '도형의 합동과 닮음','복잡한 도형에서 닮음을 찾기','특이사항 없음', '100%',80);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00002', 'SA001004', '도형의 합동과 닮음','복잡한 도형에서 닮음을 찾고 그를 통해 주어진 각도나 변의 길이를 구함','특이사항 없음', '100%',100);
--유수현
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00002', 'SA001005', '분수와 소수의 곱셈','분수끼리 곱해서 분모와 분자를 구함','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00002', 'SA001005', '분수와 소수의 곱셈','소수끼리 곱해서 소수점을 맞춰줌','이해력이 빠름', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00002', 'SA001005', '분수와 소수의 곱셈','분수와 소수끼리 곱하는 방법을 배움','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00002', 'SA001005', '분수와 소수의 곱셈','분수를 소수로 바꾸고 소수를 분수로 바꿈, 분수를 소수로 못바꿀경우 푸는 방법을 학습함','특이사항 없음', '100%',100);
--조민지
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00002', 'SA001006', '일차함수','미지수가 2개나오는 방정식을 설명함','특이사항 없음', '100%',70);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00002', 'SA001006', '일차함수','변수가 변하면 함수값도 변하는 개념을 이해하고 좌표평면에 대해 이해함','특이사항 없음', '100%',80);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00002', 'SA001006', '일차함수','좌표평면을 통해 일차함수를 그리는 방법을 배움','특이사항 없음', '100%',90);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00002', 'SA001006', '일차함수','기울기에 대해 기억하고 Y절편에 대한개념도 다시 설명함','일차함수 그리는 부분이 약함', '100%',65);
--박유림
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00003', 'SA001007', '큰 수','천의자리와 만의자리에 대한 개념을 배움','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00003', 'SA001007', '큰 수','억의 개념과 조의 개념에 대해 이해함','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00003', 'SA001007', '큰 수','서술적 문제를 통해 각각 자리수를 맞춰서 더하고 빼줌','특이사항 없음', '100%',50);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00003', 'SA001007', '큰 수','서술적 문제를 이해하는 부분 복습','문제이해력이 떨어져서 다시 복습함', '100%',100);
--임지연
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00003', 'SA001008', '이차함수','차수와 계수에 대한 개념을 다시 설명','특이사항 없음','100%',70);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00003', 'SA001008', '이차함수','이차함수의 꼭지점과 Y절편 기울기에 대한 개념학습','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00003', 'SA001008', '이차함수','표준형에서 일반형으로 바꾸는 방법을 학습함','꼭지점을 구하는걸 어려워함', '100%',60);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00003', 'SA001008', '이차함수','이차함수를 그려보고 꼭지점과 Y절편까지 본인이 그릴수 있는 학습합','특이사항 없음', '100%',100);
--백의헌
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00003', 'SA001009', '적분과 미분','미분을 왜써야하는지에대한 개념','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00003', 'SA001009', '적분과 미분','적분을 왜써야하는지에대한 개념','특이사항 없음', '100%',90);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00003', 'SA001009', '적분과 미분','미분과 적분 공식을 외우고 실습하면서 익숙해지는 과정','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00003', 'SA001009', '적분과 미분','미분과 적분을 중복해서 사용하는 연습','특이사항 없음', '100%',100);
--신정훈
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230801','YYMMDD'), 'T00003', 'SA001010', '다항식의 곱셈과 인수분해','두 개의 항을 곱하는 방법을 배우고 차순으로 정리하는 연습합','특이사항 없음', '100%',80);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230802','YYMMDD'), 'T00003', 'SA001010', '다항식의 곱셈과 인수분해','문자가 여러개 들어간 다항식의 곱셈','특이사항 없음', '100%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230803','YYMMDD'), 'T00003', 'SA001010', '다항식의 곱셈과 인수분해','완전제곱식을 인수분해하고 인수분해에 대한 공식과 개념을 외움','집안사정으로 출석률이 50%', '50%',100);
INSERT INTO ST_WEEK (YYMMDD, TC_ID, ST_ID, EXPECT, STUDY, ST_COMMENT,ACHEIVE,WEEK_SCORE) VALUES (to_date('230804','YYMMDD'), 'T00003', 'SA001010', '다항식의 곱셈과 인수분해','인수분해에 대한 공식과 개념을 다시 외우고 서술적 문제를 통해 활용을 학습함','특이사항 없음', '100%',100);

SELECT * FROM ACA_STUDENT;
desc member;    
SELECT * FROM ACA_MEMBER ORDER BY 1;
SELECT * FROM ACADEMY;
SELECT * FROM TEACHER;
SELECT * FROM ACA_STUDENT;
SELECT * FROM ST_WEEK ;
DESC USER_CONSTRAINTS;
desc ACA_STUDENT;
commit;
SELECT * FROM ACA_STUDENT where student_name like '%?%' or important like '%꺼%';    
select (select student_name from aca_student a where mid2='SA001010') student_name,to_date('monthNo','yyyy') monthNo,Tc_id,St_id,Expect,Study,St_Comment,Acheive,to_number('Week_Score','999') Week_Score
from st_week;
select extract(m from monthNo) from st_week;
SELECT * FROM ACA_STUDENT where student_name like '%영%';

select m.*,
  decode(mtype,'S', (select  student_name from ACA_STUDENT where mid2='T00001'), 'T', (select  teacher_name from teacher where mid='T00001'), 'A') name
 from aca_member m 
 where mid='T00001' and mpwd='TP00001'
 ;
 select m.*,  decode(mtype,'S', (select  student_name from ACA_STUDENT where mid2='T00001'), 'T', (select  teacher_name from teacher where mid='T00001'), 'A',(select  aca_name from academy where aca_no='A001')) mname from aca_member m where mid='A001' and mpwd='A001' and mtype='A';
 
 select mid,  decode(substr(mtype,1,1),'A','학원','S','학생','T','선생님') AS mtype, 
decode(mtype,'S', (select  student_name from ACA_STUDENT where mid2='T00001'), 'T', (select  teacher_name from teacher where mid='T00001'), 'A',(select  aca_name from academy where aca_no='T00001')) mname from aca_member m where mid='T00001' and mpwd='TP00001' and mtype='T';
 
select mid,  decode(substr(mtype,1,1),'A','학원','S','학생','T','선생님') AS mtype, 
decode(mtype
,'S', (select  student_name from ACA_STUDENT s where s.mid2=m.mid)
, 'T', (select  teacher_name t from teacher t where t.mid=m.mid)
, 'A',(select  aca_name from academy a where a.aca_no=m.mid )) mname 
from aca_member m
order by mid;
  
 SELECT * FROM BBOARD;
 
 SELECT bno,bwriter,btitle FROM bboard;
 
 select * from member;
 
 commit;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 