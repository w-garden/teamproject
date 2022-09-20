package com.partners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.partners.dto.PortfolioDTO;

public class PortfolioDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = "";

	public PortfolioDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************** db close 메서드 ********************/
	/**** try~catch문 안에 close(conn); 이런식으로 사용하면됨 */
	/******************************************************/

	public void close(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/**************************************/
	/********* 포트폴리오 관련 메서드 ******/
	/**************************************/

	public int addPortfolio(PortfolioDTO dto) {
		int pf_no=0;
		try {
			conn = ds.getConnection();
			sql = "insert into portfolioT (pf_no, business_num, pf_title, pf_type, pf_subtype, pf_range, pf_zipcode, pf_addr1, pf_addr2, pf_addr3, pf_area, pf_cost, pf_period,"
					+ "pf_concept, pf_introduction, pf_closing, pf_regdate) values (portfolioT_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBusiness_num());
			pstmt.setString(2, dto.getPf_title());
			pstmt.setString(3, dto.getPf_type());
			pstmt.setString(4, dto.getPf_subtype());
			pstmt.setString(5, dto.getPf_range());
			pstmt.setString(6, dto.getPf_zipcode());
			pstmt.setString(7, dto.getPf_addr1());
			pstmt.setString(8, dto.getPf_addr2());
			pstmt.setString(9, dto.getPf_addr3());
			pstmt.setInt(10, dto.getPf_area());
			pstmt.setInt(11, dto.getPf_cost());
			pstmt.setInt(12, dto.getPf_period());
			pstmt.setString(13, dto.getPf_concept());
			pstmt.setString(14, dto.getPf_introduction());
			pstmt.setString(15, dto.getPf_closing());
			pstmt.executeUpdate();
			
			
			sql="select pf_no from portfolioT where business_num=? and pf_title=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBusiness_num());
			pstmt.setString(2, dto.getPf_title());
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				pf_no = rs.getInt("pf_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return pf_no;
	}
	//사진 파일 이름 저장 메서드
	public void selectOnePortfolio(String[] fileDBName, int pf_no) {
		try {
			conn=ds.getConnection();
			sql="update portfolioT set pf_photo1=?, pf_photo2=?, pf_photo3=?, pf_photo4=?, pf_photo5=? where pf_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, fileDBName[0]);
			pstmt.setString(2, fileDBName[1]);
			pstmt.setString(3, fileDBName[2]);
			pstmt.setString(4, fileDBName[3]);
			pstmt.setString(5, fileDBName[4]);
			pstmt.setInt(6, pf_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
