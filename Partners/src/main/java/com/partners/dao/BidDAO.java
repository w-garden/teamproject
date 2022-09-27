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
	
	public List<EstimateDTO> selectNearPartners(String applyAddress) {
		
		List<EstimateDTO> list=new ArrayList<EstimateDTO>();
	
	
	
}