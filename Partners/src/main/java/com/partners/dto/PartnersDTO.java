package com.partners.dto;

public class PartnersDTO {
	private int business_num;
	private String businessName;
	private String pId;
	private String pPw;
	private String pName;
	private int pTel;
	private String pMail;
	private String pAddress;
	private String pDate;
	private String PDeldate;
	private String pDelcont;
	private int pState;
	
	public PartnersDTO() {}

	public PartnersDTO(int business_num, String businessName, String pId, String pPw, String pName, int pTel,
			String pMail, String pAddress, String pDate, String pDeldate, String pDelcont, int pState) {
		super();
		this.business_num = business_num;
		this.businessName = businessName;
		this.pId = pId;
		this.pPw = pPw;
		this.pName = pName;
		this.pTel = pTel;
		this.pMail = pMail;
		this.pAddress = pAddress;
		this.pDate = pDate;
		PDeldate = pDeldate;
		this.pDelcont = pDelcont;
		this.pState = pState;
	}

	public int getBusiness_num() {
		return business_num;
	}

	public void setBusiness_num(int business_num) {
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

	public int getpTel() {
		return pTel;
	}

	public void setpTel(int pTel) {
		this.pTel = pTel;
	}

	public String getpMail() {
		return pMail;
	}

	public void setpMail(String pMail) {
		this.pMail = pMail;
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
