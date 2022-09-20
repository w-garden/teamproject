package com.partners.dto;

public class PortfolioDTO {
	private int pf_no;
	private String business_num;
	private String pf_title;
	private String pf_type;
	private String pf_subtype;
	private String pf_range;
	private String pf_zipcode;
	private String pf_addr1;
	private String pf_addr2;
	private String pf_addr3;
	private int pf_area;
	private int pf_cost;
	private int pf_period;
	private String pf_concept;
	private String pf_introduction;
	private String pf_closing;
	private String pf_photo1;
	private String pf_photo2;
	private String pf_photo3;
	private String pf_photo4;
	private String pf_photo5;
	private int pf_premium;
	private String pf_regdate;
	
	
	
	
	public PortfolioDTO () {}
	
	//포트폴리오 정보 담기를 위한 생성자 오버로딩
	
	public PortfolioDTO(String business_num, String pf_title, String pf_type, String pf_subtype, String pf_range,
			String pf_zipcode, String pf_addr1, String pf_addr2, String pf_addr3, int pf_area, int pf_cost,
			int pf_period, String pf_concept, String pf_introduction, String pf_closing) {
		super();
		this.business_num = business_num;
		this.pf_title = pf_title;
		this.pf_type = pf_type;
		this.pf_subtype = pf_subtype;
		this.pf_range = pf_range;
		this.pf_zipcode = pf_zipcode;
		this.pf_addr1 = pf_addr1;
		this.pf_addr2 = pf_addr2;
		this.pf_addr3 = pf_addr3;
		this.pf_area = pf_area;
		this.pf_cost = pf_cost;
		this.pf_period = pf_period;
		this.pf_concept = pf_concept;
		this.pf_introduction = pf_introduction;
		this.pf_closing = pf_closing;
	}
	
	
	public int getPf_no() {
		return pf_no;
	}

	public void setPf_no(int pf_no) {
		this.pf_no = pf_no;
	}
	public String getBusiness_num() {
		return business_num;
	}
	public void setBusiness_num(String business_num) {
		this.business_num = business_num;
	}
	public String getPf_title() {
		return pf_title;
	}
	public void setPf_title(String pf_title) {
		this.pf_title = pf_title;
	}
	public String getPf_type() {
		return pf_type;
	}
	public void setPf_type(String pf_type) {
		this.pf_type = pf_type;
	}
	public String getPf_subtype() {
		return pf_subtype;
	}
	public void setPf_subtype(String pf_subtype) {
		this.pf_subtype = pf_subtype;
	}
	public String getPf_range() {
		return pf_range;
	}
	public void setPf_range(String pf_range) {
		this.pf_range = pf_range;
	}
	public String getPf_zipcode() {
		return pf_zipcode;
	}
	public void setPf_zipcode(String pf_zipcode) {
		this.pf_zipcode = pf_zipcode;
	}
	public String getPf_addr1() {
		return pf_addr1;
	}
	public void setPf_addr1(String pf_addr1) {
		this.pf_addr1 = pf_addr1;
	}
	public String getPf_addr2() {
		return pf_addr2;
	}
	public void setPf_addr2(String pf_addr2) {
		this.pf_addr2 = pf_addr2;
	}
	public String getPf_addr3() {
		return pf_addr3;
	}
	public void setPf_addr3(String pf_addr3) {
		this.pf_addr3 = pf_addr3;
	}
	public int getPf_area() {
		return pf_area;
	}
	public void setPf_area(int pf_area) {
		this.pf_area = pf_area;
	}
	public int getPf_cost() {
		return pf_cost;
	}
	public void setPf_cost(int pf_cost) {
		this.pf_cost = pf_cost;
	}
	public int getPf_period() {
		return pf_period;
	}
	public void setPf_period(int pf_period) {
		this.pf_period = pf_period;
	}
	public String getPf_concept() {
		return pf_concept;
	}
	public void setPf_concept(String pf_concept) {
		this.pf_concept = pf_concept;
	}
	public String getPf_introduction() {
		return pf_introduction;
	}
	public void setPf_introduction(String pf_introduction) {
		this.pf_introduction = pf_introduction;
	}
	public String getPf_closing() {
		return pf_closing;
	}
	public void setPf_closing(String pf_closing) {
		this.pf_closing = pf_closing;
	}
	public String getPf_photo1() {
		return pf_photo1;
	}
	public void setPf_photo1(String pf_photo1) {
		this.pf_photo1 = pf_photo1;
	}
	public String getPf_photo2() {
		return pf_photo2;
	}
	public void setPf_photo2(String pf_photo2) {
		this.pf_photo2 = pf_photo2;
	}
	public String getPf_photo3() {
		return pf_photo3;
	}
	public void setPf_photo3(String pf_photo3) {
		this.pf_photo3 = pf_photo3;
	}
	public String getPf_photo4() {
		return pf_photo4;
	}
	public void setPf_photo4(String pf_photo4) {
		this.pf_photo4 = pf_photo4;
	}
	public String getPf_photo5() {
		return pf_photo5;
	}
	public void setPf_photo5(String pf_photo5) {
		this.pf_photo5 = pf_photo5;
	}
	public int getPf_premium() {
		return pf_premium;
	}
	public void setPf_premium(int pf_premium) {
		this.pf_premium = pf_premium;
	}
	public String getPf_regdate() {
		return pf_regdate;
	}
	public void setPf_regdate(String pf_regdate) {
		this.pf_regdate = pf_regdate;
	}
	
	
	
	
	
}
