package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
		System.out.println("실행");
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
				dto.setPf_photo6(rs.getString(22));
				dto.setPf_photo7(rs.getString(23));
				dto.setPf_premium(rs.getInt(24));
				dto.setPf_regdate(rs.getString(25));
				System.out.println(dto);
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
	
}
