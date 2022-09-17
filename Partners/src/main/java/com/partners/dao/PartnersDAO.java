package com.partners.dao;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.partners.dto.PartnersDTO;

public class PartnersDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = "";

	public PartnersDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
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

	/*********************************/
	/***** 파트너스 정보관련메서드 *****/
	/*********************************/

	// 아이디를 기준으로 파트너스 정보 검색
	public PartnersDTO selectPartner(String pId) {
			PartnersDTO dto=null;
		try {
			conn = ds.getConnection();
			sql = "select * from partnersT where pId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new PartnersDTO();
				
				/* 일단 상호명 이름만 조회 가능하게 만듬 */
				
				
				dto.setBusinessName(rs.getString("businessName"));
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	// 아이디 중복 검색 메서드

	// 파트너스 저장 메서드
	public int insertPartners(PartnersDTO dto) {
		int result = 0;

		try {
			conn = ds.getConnection();
			sql = "insert into partnersT (business_num, businessName, pId, pPw, pName, pTel, pMail_id, pMail_domain) values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getBusiness_num());
			pstmt.setString(2, dto.getBusinessName());
			pstmt.setString(3, dto.getpId());
			pstmt.setString(4, dto.getpPw());
			pstmt.setString(5, dto.getpName());
			pstmt.setString(6, dto.getpTel());
			pstmt.setString(7, dto.getpMail_id());
			pstmt.setString(8, dto.getpMail_domain());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

	// 로그인 체크 메서드
	// 아이디가 없는경우 0, 비번이 일치하지 않는경우 2, 로그인 성공 1
	public int loginCheck(String pId, String pPw) {

		int result = 0;
		try {
			conn = ds.getConnection();
			sql = "select * from partnersT where pId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String db_pPw = rs.getString("pPw");

				if (db_pPw.equals(pPw)) {
					result = 1;
				} else {
					result = 2;
				}
			}
		} catch (Exception e) {
		} finally {
			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// 로그인 체크 메서드

	// 파트너스 정보 수정 메서드

	// 파트너스 탈퇴 메서드

}
