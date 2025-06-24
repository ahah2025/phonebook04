##############################################
# phonebook 만들기
##############################################

-- -----------------------------------------
# phonebook 계정에서 실행
-- -----------------------------------------
 
-- db 선택
use phonebook_db;

-- 테이블 삭제
drop table person;

-- 테이블생성 
create table person(
    person_id	int              primary key          auto_increment,
    name		varchar(30)      not null,
    hp      	varchar(20),
    company	    varchar(20)
);

-- 테이블조회
select  person_id,
        name,
        hp,
        company
from person
order by person_id desc
;

select 	person_id,
		name,
        hp,
        company
from person
where person_id = 1
;

-- 등록
insert into person
values(null, '정우성','010-1111-1111','02-1111-2111')
;

insert into person
values(null, '이효리','010-2222-2222','02-2221-2202')
;

insert into person
values(null, '강호동','010-3333-3333','02-3333-3002')
;

-- 수정
update person
set name = '서장훈' , 
     hp = '010-3333-4444',
     company = '02-2222-3333' 
where person_id = 1 
;

-- 삭제
delete from person
where person_id = 18 ;
