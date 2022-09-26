package com.dozip.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnersVO {
	private String business_num;
	private String businessName;
	private String pId;
	private String pPw;
	private String pName;
	private String pTel;
	private String pMail_id;
	private String pMail_domain;
	private String pAddress;
	private String pDate;
	private String PDeldate;
	private String pDelcont;
	private int pState;
	
	
	public PartnersVO() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//회원가입시 사용할 DTO 

	public PartnersVO(String business_num, String businessName, String pId, String pPw, String pName, String pTel,
			String pMail_id, String pMail_domain) {
		super();
		this.business_num = business_num;
		this.businessName = businessName;
		this.pId = pId;
		this.pPw = pPw;
		this.pName = pName;
		this.pTel = pTel;
		this.pMail_id = pMail_id;
		this.pMail_domain = pMail_domain;
	}






	public String getBusiness_num() {
		return business_num;
	}

	public void setBusiness_num(String business_num) {
		this.business_num = business_num;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpPw() {
		return pPw;
	}

	public void setpPw(String pPw) {
		this.pPw = pPw;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpTel() {
		return pTel;
	}

	public void setpTel(String pTel) {
		this.pTel = pTel;
	}

	public String getpMail_id() {
		return pMail_id;
	}

	public void setpMail_id(String pMail_id) {
		this.pMail_id = pMail_id;
	}

	public String getpMail_domain() {
		return pMail_domain;
	}

	public void setpMail_domain(String pMail_domain) {
		this.pMail_domain = pMail_domain;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public String getPDeldate() {
		return PDeldate;
	}

	public void setPDeldate(String pDeldate) {
		PDeldate = pDeldate;
	}

	public String getpDelcont() {
		return pDelcont;
	}

	public void setpDelcont(String pDelcont) {
		this.pDelcont = pDelcont;
	}

	public int getpState() {
		return pState;
	}

	public void setpState(int pState) {
		this.pState = pState;
	}







	
}
