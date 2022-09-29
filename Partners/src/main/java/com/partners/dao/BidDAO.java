package com.partners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.partners.dto.EstimateDTO;
import com.partners.dto.Partners_subDTO;

public class BidDAO {
	Connection conn=null;  //DB연결 con
	PreparedStatement pstmt=null; //쿼리문 수행 pt
	ResultSet rs=null;  //검색결과 레코드를 저장할 rs
	DataSource ds=null;  //커넥션 풀 관리 ds
	String sql=null;  //쿼리문 저장변수

	public BidDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xe"); //커넥션 풀 관리 ds생성
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
	
	//파트너스 정보 검색(사업자 번호 기준)
	public EstimateDTO selectBid(String est_num) {
		EstimateDTO edto = null;
		try {
			conn = ds.getConnection();
			sql = "select * from estimateT where est_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, est_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				edto = new EstimateDTO();
	
				edto.setEst_num(rs.getString("mem_id"+"견적 문의"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return edto;
	}

	
}