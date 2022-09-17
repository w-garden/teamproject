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

















