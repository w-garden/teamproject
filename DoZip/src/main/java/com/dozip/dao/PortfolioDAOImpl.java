package com.dozip.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.PartnersVO;
import com.dozip.vo.PortfolioVO;



public class PortfolioDAOImpl {

	Connection con=null;//DB연결
	PreparedStatement pt=null; //쿼리문 수행
	ResultSet rs=null;//검색 결과 레코드를 저장 rs
	DataSource ds=null;//DBCP 커넥션풀 관리 ds
	String sql=null; //SQL 쿼리문
	
	public PortfolioDAOImpl() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자

	//전체 리스트 내용 불러오기 ( 모든 컬럼 포함 ) + 아웃조인
	public List<PortfolioVO> getAllList() {
		
		List<PortfolioVO> list = new ArrayList<>();
		PortfolioVO dto =null;
		/* System.out.println("실행"); */
		try {
			con = ds.getConnection();
			sql = "select pf.*, pt.businessName from portfolioT pf, partnersT pt where pf.business_num = pt.business_num(+) order by pf_no desc";
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				dto = new PortfolioVO();
				dto.setPf_no(rs.getInt(1));
				dto.setBusiness_num(rs.getString(2));
				dto.setPf_title(rs.getString(3));
				dto.setPf_type(rs.getString(4));
				dto.setPf_subtype(rs.getString(5));
				dto.setPf_range(rs.getString(6));
				dto.setPf_zipcode(rs.getString(7));
				dto.setPf_addr1(rs.getString(8));
				dto.setPf_addr2(rs.getString(9));
				dto.setPf_addr3(rs.getString(10));
				dto.setPf_area(rs.getInt(11));
				dto.setPf_cost(rs.getInt(12));
				dto.setPf_period(rs.getInt(13));
				dto.setPf_concept(rs.getString(14));
				dto.setPf_introduction(rs.getString(15));
				dto.setPf_closing(rs.getString(16));
				dto.setPf_photo1(rs.getString(17));
				dto.setPf_photo2(rs.getString(18));
				dto.setPf_photo3(rs.getString(19));
				dto.setPf_photo4(rs.getString(20));
				dto.setPf_photo5(rs.getString(21));				
				dto.setPf_premium(rs.getInt(22));
				dto.setPf_regdate(rs.getString(23));
				dto.setBusinessName(rs.getString(24));
				/* System.out.println(dto); */
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally { 
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e){e.printStackTrace();}
		}
		return list;
	}//getAllList();

	
    //해당 글번호의 리스트 값 가져오기
	public PortfolioVO getOnelist(int pf_no) {
		
		
		PortfolioVO dto =new PortfolioVO();
		
		try {
			
			con = ds.getConnection();
			sql = "select * from portfolioT where pf_no=?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, pf_no);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				dto = new PortfolioVO();
				dto.setPf_no(rs.getInt(1));
				dto.setBusiness_num(rs.getString(2));
				dto.setPf_title(rs.getString(3));
				dto.setPf_type(rs.getString(4));
				dto.setPf_subtype(rs.getString(5));
				dto.setPf_range(rs.getString(6));
				dto.setPf_zipcode(rs.getString(7));
				dto.setPf_addr1(rs.getString(8));
				dto.setPf_addr2(rs.getString(9));
				dto.setPf_addr3(rs.getString(10));
				dto.setPf_area(rs.getInt(11));
				dto.setPf_cost(rs.getInt(12));
				dto.setPf_period(rs.getInt(13));
				dto.setPf_concept(rs.getString(14));
				dto.setPf_introduction(rs.getString(15));
				dto.setPf_closing(rs.getString(16));
				dto.setPf_photo1(rs.getString(17));
				dto.setPf_photo2(rs.getString(18));
				dto.setPf_photo3(rs.getString(19));
				dto.setPf_photo4(rs.getString(20));
				dto.setPf_photo5(rs.getString(21));				
				dto.setPf_premium(rs.getInt(22));
				dto.setPf_regdate(rs.getString(23));
				

			}
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return dto;
	}
	
	
	//해당 글의 파트너스 업체 정보 가져오기
	public PartnersVO getComplist(int pf_no) {
		
		PartnersVO dto = new PartnersVO();
		
		try {
			con = ds.getConnection();
			sql = "select * from partnersT where business_num = (select business_num from portfolioT where pf_no =?)";
			pt = con.prepareStatement(sql);
			pt.setInt(1, pf_no);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				dto.setBusiness_num(rs.getString("business_num"));
				dto.setBusinessName(rs.getString("businessName"));
				dto.setpName(rs.getString("pName"));
				dto.setpTel(rs.getString("pTel"));
				dto.setpMail_id(rs.getString("pMail_id"));
				dto.setpMail_domain(rs.getString("pMail_domain"));
				dto.setpAddress(rs.getString("pAddress"));
				/* System.out.println(dto.toString()); */
			}
			}catch(Exception e) {e.printStackTrace();}
			finally {
				try {
					if(rs != null) rs.close();
					if(pt != null) pt.close();
					if(con!= null) con.close();
				}catch(Exception e){e.printStackTrace();}
			}
			return dto;
		}//getComplist();
		
	
	//업체 상세 페이지
	public PartnersVO getOnecomp(String business_num) {
		
		PartnersVO dto = new PartnersVO();
		
		try {
			con = ds.getConnection();
			sql = "select * from partnersT where businessName = ?";
			pt = con.prepareStatement(sql);
			pt.setString(1, business_num);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				dto.setBusiness_num(rs.getString("business_num"));
				dto.setBusinessName(rs.getString("businessName"));
				dto.setpName(rs.getString("pName"));
				dto.setpTel(rs.getString("pTel"));
				dto.setpMail_id(rs.getString("pMail_id"));
				dto.setpMail_domain(rs.getString("pMail_domain"));
				dto.setpAddress(rs.getString("pAddress"));
			}
			}catch(Exception e) {e.printStackTrace();}
			finally {
				try {
					if(rs != null) rs.close();
					if(pt != null) pt.close();
					if(con != null) con.close();
				}catch(Exception e) {e.printStackTrace();}
			}
			return dto;
		}//getOneComp()

	
	//필터 검색
	public List<PortfolioVO> getSearchList(PortfolioVO p) {
		List<PortfolioVO> list = new ArrayList<>();
		PortfolioVO dto =null;
		try {
			con = ds.getConnection();
			sql = "select * from ("
					+ "select pf.*, pt.businessName from portfolioT pf, partnersT pt where pf.business_num = pt.business_num(+) order by pf_no desc)"
					+ " where ((pf_no is not null) ";
			if(!p.getPf_subtype().equals("선택안됨")) {
				sql += " and pf_subtype=? ";
			}else if(!p.getPf_concept().equals("스타일")) {
				sql += " and pf_concept=? ";
			}else if(p.getPf_cost()!=0) {
				sql += " and pf_cost=? ";
			}else if(p.getPf_area()!=0) {
				sql += " and pf_area=? ";
			}
			
			sql += ")";
					
			pt = con.prepareStatement(sql);
			pt.setString(1, p.getPf_concept());
			
			
			
			
			rs = pt.executeQuery();
			
			while(rs.next()) {
				dto = new PortfolioVO();
				dto.setPf_no(rs.getInt(1));
				dto.setBusiness_num(rs.getString(2));
				dto.setPf_title(rs.getString(3));
				dto.setPf_type(rs.getString(4));
				dto.setPf_subtype(rs.getString(5));
				dto.setPf_range(rs.getString(6));
				dto.setPf_zipcode(rs.getString(7));
				dto.setPf_addr1(rs.getString(8));
				dto.setPf_addr2(rs.getString(9));
				dto.setPf_addr3(rs.getString(10));
				dto.setPf_area(rs.getInt(11));
				dto.setPf_cost(rs.getInt(12));
				dto.setPf_period(rs.getInt(13));
				dto.setPf_concept(rs.getString(14));
				dto.setPf_introduction(rs.getString(15));
				dto.setPf_closing(rs.getString(16));
				dto.setPf_photo1(rs.getString(17));
				dto.setPf_photo2(rs.getString(18));
				dto.setPf_photo3(rs.getString(19));
				dto.setPf_photo4(rs.getString(20));
				dto.setPf_photo5(rs.getString(21));				
				dto.setPf_premium(rs.getInt(22));
				dto.setPf_regdate(rs.getString(23));
				dto.setBusinessName(rs.getString(24));
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally { 
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e){e.printStackTrace();}
		}
		return list;
	}
	
}
