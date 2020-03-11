create table board(
	bno number(8),
	name nvarchar2(10) not null,
	password varchar2(15) not null,
	title nvarchar2(50) not null,
	content nvarchar2(1000) not null,
	attach nvarchar2(100),
	re_ref number(8) not null,
	re_lev number(8) not null,
	re_seq number(8) not null,
	readcount number(8) default 0,
	regdate date default sysdate);	
alter table board add constraint pk_board primary key(bno);
create sequence board_seq;


select * from board;

-- 더미 데이터
insert into BOARD(bno,name,password,title,content,re_ref,re_lev,
re_seq) (select board_seq.nextVal,name,password,title,content,
board_seq.currVal,re_lev,re_seq from board);















