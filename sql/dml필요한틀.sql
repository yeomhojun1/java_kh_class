DROP TABLE "CALENDAR";﻿
DROP TABLE "MEMBER_EX_SET";
DROP TABLE "FOOD";
DROP TABLE "MEMBER_WEIGHT";
DROP TABLE "BOARD";
DROP TABLE "FOOD_API";
DROP TABLE "DIET";
DROP TABLE "DAY_DIET";
DROP TABLE "EXERCISE";
DROP TABLE "NOTICE";
DROP TABLE "MEMBER";
DROP TABLE "ADMIN";
DROP TABLE "USERS";

--users
INSERT into users  VALUES ('test1', 'test1', 0, 'member');
INSERT into users  VALUES ('admin1', 'admin1', 1, 'admin');
--member
insert into member values ('test1','테스트', 'test1@gmail.com', '1995-07-18', 'M', '강남구 강남역', 180, 77, 'test1@gmail.com','test1@naver.com','test1@nate.com');

--exercise
insert into exercise (ecode, exname,part, epose, eposelink) values(10001,'덤벨 리스트 컬','팔','1.팔뚝을 벤치에 기대고 손바닥이 위쪽을 향하도록 덤벨을 잡습니다.2.손목을 반원 모양으로 천천히 위쪽으로 구부립니다.3.시작 위치로 돌아가서 반복하세요.' ,'<iframe width="853" height="480" src="https://www.youtube.com/embed/S-ynXc4M-mY" title="Simplified: Wrist Curl Quick #Howto" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>');
--member_ex_set
insert into member_ex_set values ('test1', 10001, '덤벨 리스트 컬', 5, 10);
--member_weight
insert into member_weight values ('test1', '230904', 77, 36, 25);
--board
insert into comment_num values (1,'test1', '게시글 테스트 제목', '게시글 테스트 내용', 1, '230904');
--day_diet
insert into day_diet values ('230904test1', 'test1', '230904', '저녁에 단백질이 부족함');
--diet
insert into diet values ('230904test1A', '230904test1', 'A');
--FOOD
insert into food values ();
--food_api
insert into food_api values ();
--admin
insert into admin values ('admin1', 'admin1','관리자1','admin1@gmail.com');
--notice
insert into notice values (1,'admin1','공지사항 제목', '공지사항 내용', 1, '230904');