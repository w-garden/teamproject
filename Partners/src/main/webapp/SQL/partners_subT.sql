create table partners_subT (
	business_num nvarchar2(12) not null,  --사업자번호
	pShortstate nvarchar2(2000),
	pInt_img nvarchar2(70),
	pComp_logo nvarchar2(70),
	pService nvarchar2(50),
	pHomepg nvarchar2(100),
	pRes_build_type nvarchar2(100) not null,
	pRes_space_type nvarchar2(400) not null,
	pCom_build_type nvarchar2(100) not null,
	pCom_space_type nvarchar2(400) not null,
	pRes_person_name nvarchar2(10),
	pRes_person_tel nvarchar2(15),
	pCom_person_name nvarchar2(10),
	pCom_person_tel nvarchar2(15),
	pBalance number(20),
	pAccount_bank nvarchar2(10) not null,
	pAccount_name nvarchar2(10) not null,
	pAccount_num nvarchar2(20) not null,
	pAccount_file nvarchar2(70) not null,
	pBusiness_lic_file nvarchar2(70) not null,
	foreign key(business_num) references partnersT(business_num)
);

select * from partners_subT;
drop table partners_subT;

	