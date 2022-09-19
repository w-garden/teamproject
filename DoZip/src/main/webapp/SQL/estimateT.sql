create table estimateT(
 est_num varchar2(12)
 ,est_zoning varchar2(20) not null
 ,est_use varchar2(20) not null
 ,est_areaP number(12) not null
 ,est_areaM number(12) not null
 ,est_detail01 varchar2(30)
 ,est_detail02 varchar2(30)
 ,est_detail03 varchar2(30)
 ,est_detail04 varchar2(30)
 ,est_detail05 varchar2(30)
 ,est_detail06 varchar2(30)
 ,est_detail07 varchar2(30)
 ,est_detail08 varchar2(30)
 ,est_bud number(12) not null
 ,est_start varchar2(15)
 ,est_end varchar2(15)
 ,est_date date
 ,est_dateEnd varchar2(15)
 ,est_name varchar2(10)
 ,est_phone varchar2(12)
 ,est_desc varchar2(3000)
 ,est_file varchar2(200)
 ,est_selectCompany varchar2(50)
);

select * from estimateT;