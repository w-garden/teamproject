package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.PartnersDTO;
import com.dozip.vo.PortfolioDTO;



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

	//전체 리스트 내용 불러오기 ( 모든 컬럼 포함 )
	public List<PortfolioDTO> getAllList() {
		
		List<PortfolioDTO> list = new ArrayList<>();
		PortfolioDTO dto =null;
		/* System.out.println("실행"); */
		try {
			con = ds.getConnection();
			sql = "select * from portfolioT order by pf_no desc";
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				dto = new PortfolioDTO();
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
	public PortfolioDTO getOnelist(int pf_no) {
		
		
		PortfolioDTO dto =new PortfolioDTO();
		
		try {
			
			con = ds.getConnection();
			sql = "select * from portfolioT where pf_no=?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, pf_no);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				dto = new PortfolioDTO();
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
				/* System.out.println(dto); dto 찍어보기*/

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
	public PartnersDTO getComplist(int pf_no) {
		
		PartnersDTO dto = new PartnersDTO();
		
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
	public PartnersDTO getOnecomp(String business_num) {
		
		PartnersDTO dto = new PartnersDTO();
		
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
	
	
	//업체명 검색시 해당 업체 포트폴리오 나오게
	public List<PortfolioDTO> searchComp(String keyword) {
		
		List<PortfolioDTO> list = new ArrayList<>();
		
		PortfolioDTO dto = new PortfolioDTO();
		
		try {
			con = ds.getConnection();
			sql = "select * from portfolioT where business_num = (select business_num from partnersT where businessName like ?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, "%" + keyword + "%");
			rs = pt.executeQuery();
			
			while(rs.next()) {
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
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return list;
	}
	
	

}
