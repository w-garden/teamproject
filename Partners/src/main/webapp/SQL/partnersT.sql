--회원가입시 필요한 파트너스의 정보를 담는 테이블
create table partnersT (
    business_num nvarchar2(12)primary key, --사업자번호
    businessName nvarchar2(20) not null, --상호명
    pId	nvarchar2(20) not null, --아이디
    pPw	nvarchar2(20) not null, --비밀번호
    pName nvarchar2(10) not null, --대표자이름
    pTel nvarchar2(12) not null, --대표자 연락처
    pMail_id nvarchar2(30) not null, --대표자 이메일 ID
    pMail_domain nvarchar2(30) not null, --대표자 이메일 DOMAIN
    pAddress nvarchar2(500), --영업장 주소
    pDate nvarchar2(15), --가입날짜
    PDeldate nvarchar2(15), --탈퇴날짜
    pDelcont nvarchar2(400), --탈퇴사유
    pState number(5) default 1 --탈퇴여부(가입 1, 탈퇴 2)
);

select * from partnersT;
drop table partnersT;
delete from PARTNERST;
select * from partnersT where pId='shc729';






--포트폴리오에 대한 정보를 담는 테이블					
create table portfolioT(
	pf_no number(38) primary key, --글번호
	business_num nvarchar2(12) not null, --파트너스 사업자번호(외래키)
	pf_title nvarchar2(50) not null, --제목
	pf_type nvarchar2(5) not null, --공사유형
	pf_subtype nvarchar2(5) not null, --공사 세부유형
	pf_range nvarchar2(10) not null, -- 시공범위
	pf_zipcode nvarchar2(7) not null, --우편번호
	pf_addr1 nvarchar2(30) not null, --주소1
	pf_addr2 nvarchar2(30) not null, --주소2
	pf_addr3 nvarchar2(20), --주소3
	pf_area number(10) not null, --평수
	pf_cost number(10) not null, --공사비용
	pf_period number(5) not null, --공사기간
	pf_concept nvarchar2(30) not null, --시공컨셉
	pf_introduction nvarchar2(1000) not null, --인사말
	pf_closing nvarchar2(1000) not null, --맺음말
	pf_photo1 nvarchar2(50), --사진1
	pf_photo2 nvarchar2(50), --사진2
	pf_photo3 nvarchar2(50), --사진3
	pf_photo4 nvarchar2(50), --사진4
	pf_photo5 nvarchar2(50), --사진5
	pf_photo6 nvarchar2(50), --사진6
	pf_photo7 nvarchar2(50), --사진7
	pf_premium number(5) default 0, --프리미엄여부
	pf_regdate nvarchar2(20) not null, --작성일자
	foreign key(business_num) references partnersT(business_num)
);					

drop table portfolioT;
select * from portfolioT;





--portfolioT_no_seq 시퀀스 생성
create sequence portfolioT_no_seq
start with 1 
increment by 1
nocache;

select portfolioT_no_seq.nextval from dual;






