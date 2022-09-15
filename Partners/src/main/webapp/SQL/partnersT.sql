--회원가입시 필요한 파트너스의 정보를 담는 테이블
create table partnersT (
    business_num number(10)primary key, --사업자번호
    businessName varchar2(20) not null, --상호명
    pId	varchar2(20) not null, --아이디
    pPw	varchar2(20) not null, --비밀번호
    pName varchar2(10) not null, --대표자이름
    pTel number(12) not null, --대표자 연락처
    pMail varchar2(30) not null, --대표자 이메일 ID
    pAddress varchar2(500), --영업장 주소
    pDate varchar2(15), --가입날짜
    PDeldate varchar2(15), --탈퇴날짜
    pDelcont varchar2(400), --탈퇴사유
    pState number(5) default 1 --탈퇴여부(가입 1, 탈퇴 2)
);

select * from PARTNERST;









