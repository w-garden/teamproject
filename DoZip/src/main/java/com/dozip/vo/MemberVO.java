package com.dozip.vo;

public class MemberVO {
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_tel;
	private String mem_email;
	private String mem_domain;
	private String mem_zip;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_joinType;
	private String mem_joinDate;
	private int mem_withdraw;
	private String mem_withdrawDate;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_domain() {
		return mem_domain;
	}
	public void setMem_domain(String mem_domain) {
		this.mem_domain = mem_domain;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_joinType() {
		return mem_joinType;
	}
	public void setMem_joinType(String mem_joinType) {
		this.mem_joinType = mem_joinType;
	}
	public String getMem_joinDate() {
		return mem_joinDate;
	}
	public void setMem_joinDate(String mem_joinDate) {
		this.mem_joinDate = mem_joinDate.substring(0,10);//0이상 10미만 사이의 년월일 만 반환
	}
	public int getMem_withdraw() {
		return mem_withdraw;
	}
	public void setMem_withdraw(int mem_withdraw) {
		this.mem_withdraw = mem_withdraw;
	}
	public String getMem_withdrawDate() {
		return mem_withdrawDate;
	}
	public void setMem_withdrawDate(String mem_withdrawDate) {
		this.mem_withdrawDate = mem_withdrawDate.substring(0,10);//0이상 10미만 사이의 년월일 만 반환
	}	
}
