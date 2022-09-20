create table estimateT(
 est_num varchar2(12) --고유번호
 ,est_zoning varchar2(20) not null --공간유형(주거, 상가)
 ,est_use varchar2(20) not null  --건물유형
 ,est_areaP number(12) not null --평수(평)
 ,est_areaM number(12) not null --제곱미터
 ,est_detail01 varchar2(30) -- 도배/벽
 ,est_detail02 varchar2(30) -- 바닥
 ,est_detail03 varchar2(30) -- 주방
 ,est_detail04 varchar2(30) --욕실
 ,est_detail05 varchar2(30) --현관
 ,est_detail06 varchar2(30) --발코니/샷시
 ,est_detail07 varchar2(30) --조명
 ,est_detail08 varchar2(30) --문
 ,est_bud number(12) not null --예산
 ,est_start varchar2(15) -- 희망공사 시작일
 ,est_end varchar2(15) -- 희망공사 종료일
 ,est_date date --견적신청 일자
 ,est_dateEnd varchar2(15) --견적신청 마감일자 +10일
 ,est_name varchar2(10) --의뢰인 이름
 ,est_phone varchar2(12) --의로인 휴대폰 번호
 ,est_desc varchar2(3000) --스타일 설명
 ,est_file varchar2(200) --파일첨부
 ,est_selectCompany varchar2(50) --업체 선택
);

select * from estimateT;