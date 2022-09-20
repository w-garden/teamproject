create table qnaT(
	qna_no number(38) primary key, --글번호
	mem_id varchar2(20) not null, --고객아이디(fk)
	business_num nvarchar2(12), --사업자번호(fk)
	qna_type varchar2(50) not null, --질문유형
	qna_title varchar2(200) not null, --글제목
	qna_cont varchar2(4000) not null, --글내용
	qna_date date default sysdate, --작성일자
	edit_date date, --수정일자
	qna_state number(10) default 1, --글상태(삭제:0)
	qna_ref number(38), -- 답글(그룹번호)
	qna_step number(38), -- 답글(원본글:0)
	qna_level number(38), -- 답글(정렬순서)
	reply_state varchar2(20), -- 답변상태
	reply_date date, --답변일자
	foreign key(mem_id) references memberT(mem_id),
	foreign key(business_num) references partnersT(business_num)
);

select * from qnaT;

--qnaT_no_seq 시퀀스 생성
create sequence qnaT_no_seq
start with 1 
increment by 1
nocache;

select qnaT_no_seq.nextval from dual;
