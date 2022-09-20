package com.partners.dao;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.partners.dto.PartnersDTO;
import com.partners.dto.PortfolioDTO;

public class PartnersDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = "";

	public PartnersDAO() {
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

	/***********************************/
	/***** 파트너스 정보관련메서드 *****/
	/***********************************/

	// 아이디를 기준으로 파트너스 정보 검색
	public PartnersDTO selectPartner(String pId) {
		PartnersDTO dto = null;
		try {
			conn = ds.getConnection();
			sql = "select * from partnersT where pId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PartnersDTO();

				dto.setBusiness_num(rs.getString("business_num"));
				dto.setBusinessName(rs.getString("businessName"));
				dto.setpId(rs.getString("pId"));
				dto.setpPw(rs.getString("pPw"));
				dto.setpName(rs.getString("pName"));
				dto.setpTel(rs.getString("pTel"));
				dto.setpMail_id(rs.getString("pMail_id"));
				dto.setpMail_domain(rs.getString("pMail_domain"));
				dto.setpAddress(rs.getString("pAddress"));
				dto.setpDate(rs.getString("pDate"));
				dto.setPDeldate(rs.getString("PDeldate"));
				dto.setpDelcont(rs.getString("pDelcont"));
				dto.setpState(rs.getInt("pState"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
				close(conn);
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
			sql = "insert into partnersT (business_num, businessName, pId, pPw, pName, pTel, pMail_id, pMail_domain, pDate) values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
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

	public PartnersDTO findID(String findid_business_num) {
		PartnersDTO dto = null;

		try {
			conn = ds.getConnection();
			sql = "select * from partnersT where business_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, findid_business_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new PartnersDTO();
				dto.setBusiness_num(rs.getString("business_num"));
				dto.setpId(rs.getString("pId"));
				dto.setpTel(rs.getString("pTel"));
				dto.setpMail_id(rs.getString("pMail_id"));
				dto.setpMail_domain(rs.getString("pMail_domain"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return dto;
	}

	// 파트너스 아이디 찾기 메서드

	// 파트너스 정보 수정 메서드

	// 파트너스 탈퇴 메서드

	/**************************************/
	/********* 포트폴리오 관련 메서드 ******/
	/**************************************/

	public void addPortfolio(PortfolioDTO dto) {
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
	}
}
