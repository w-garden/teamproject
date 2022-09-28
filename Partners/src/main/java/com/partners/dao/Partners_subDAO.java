package com.partners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.partners.dto.PartnersDTO;
import com.partners.dto.Partners_subDTO;

public class Partners_subDAO {
	Connection conn=null;  //DB연결 con
	PreparedStatement pstmt=null; //쿼리문 수행 pt
	ResultSet rs=null;  //검색결과 레코드를 저장할 rs
	DataSource ds=null;  //커넥션 풀 관리 ds
	String sql=null;  //쿼리문 저장변수

	public Partners_subDAO() {
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
	
	//파트너스 data_manage의 정보 수정페이지(업데이트)
	public int updatePartnersSub(Partners_subDTO psdto) {
		int result=0;
		
		try {
			conn = ds.getConnection();
			/*
			 * sql="update PartnersT set businessName=?,pName=?,pTel=?,pAddress=? where business_num=?"
			 * ; pstmt=conn.prepareStatement(sql); pstmt.setString(1,
			 * pdto.getBusinessName()); pstmt.setString(2, pdto.getpName());
			 * pstmt.setString(3, pdto.getpTel()); pstmt.setString(4, pdto.getpAddress());
			 * 
			 * pstmt.executeUpdate();
			 */
			
			
			sql="update partners_subT set business_num=?, pShortstate=?,pInt_img=?,pComp_logo=?,pService=?,pHomepg=?,"
			+ "pRes_build_type=?,pRes_space_type=?,pCom_build_type=?,pCom_space_type=?,pRes_person_name=?,pRes_person_tel=?,"
			+ "pCom_person_name=?, pCom_person_tel=?,pBalance=?,pAccount_bank=?,pAccount_name=?,pAccount_num=?,pAccount_file=?,"
			+ "pBusiness_lic_file=? where business_num=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, psdto.getBusiness_num());
			pstmt.setString(2, psdto.getpShortstate());
			pstmt.setString(3, psdto.getpInt_img());
			pstmt.setString(4, psdto.getpComp_logo());
			pstmt.setString(5, psdto.getpService());
			pstmt.setString(6, psdto.getpHomepg());
			pstmt.setString(7, psdto.getpRes_build_type());
			pstmt.setString(8, psdto.getpRes_space_type());
			pstmt.setString(9, psdto.getpCom_build_type());
			pstmt.setString(10, psdto.getpCom_space_type());
			pstmt.setString(11, psdto.getpRes_person_name());
			pstmt.setString(12, psdto.getpRes_person_tel());
			pstmt.setString(13, psdto.getpCom_person_name());
			pstmt.setString(14, psdto.getpCom_person_tel());
			pstmt.setInt(15, psdto.getpBalance());
			pstmt.setString(16, psdto.getpAccount_bank());
			pstmt.setString(17, psdto.getpAccount_name());
			pstmt.setString(18, psdto.getpAccount_num());
			pstmt.setString(19, psdto.getpAccount_file());
			pstmt.setString(20, psdto.getpBusiness_lic_file());
			pstmt.setString(21, psdto.getBusiness_num());
			pstmt.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);	
		}
		return result;
	}
	
	//파트너스 data_manage 전체 저장 메서드
	public int insertPartnersSub(Partners_subDTO psdto) {
		int result = 0;

		try {
			conn = ds.getConnection();
//			
			/*
			 * sql =
			 * "insert into partners_subT (business_num, pShortstate, pInt_img, pComp_logo, pService, pHomepg, pRes_build_type,"
			 * +
			 * "pRes_space_type,pCom_build_type,pCom_space_type,pRes_person_name,pRes_person_tel,pCom_person_name,"
			 * +
			 * "pCom_person_tel,pBalance,pAccount_bank,pAccount_name,pAccount_num,pAccount_file,pBusiness_lic_file)"
			 * + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			 */
			sql = "insert into partners_subT (business_num,pShortstate,pService,pHomepg,pRes_build_type,pRes_space_type,"
					+ "pCom_build_type,pCom_space_type,pRes_person_name,pRes_person_tel,pCom_person_name,pCom_person_tel,"
					+ "pBalance,pAccount_bank,pAccount_name,pAccount_num)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, psdto.getBusiness_num());
			pstmt.setString(2, psdto.getpShortstate());
			//pstmt.setString(2, psdto.getpInt_img());
			//pstmt.setString(3, psdto.getpComp_logo());
			pstmt.setString(3, psdto.getpService());
			pstmt.setString(4, psdto.getpHomepg());
			pstmt.setString(5, psdto.getpRes_build_type());
			pstmt.setString(6, psdto.getpRes_space_type());
			pstmt.setString(7, psdto.getpCom_build_type());
			pstmt.setString(8, psdto.getpCom_space_type());
			pstmt.setString(9, psdto.getpRes_person_name());
			pstmt.setString(10, psdto.getpRes_person_tel());
			pstmt.setString(11, psdto.getpCom_person_name());
			pstmt.setString(12, psdto.getpCom_person_tel());
			pstmt.setInt(13, psdto.getpBalance());
			pstmt.setString(14, psdto.getpAccount_bank());
			pstmt.setString(15, psdto.getpAccount_name());
			pstmt.setString(16, psdto.getpAccount_num());
			//pstmt.setString(18, psdto.getpAccount_file());
			//pstmt.setString(19, psdto.getpBusiness_lic_file());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}

	//파트너스 정보 검색(사업자 번호 기준)
	public Partners_subDTO selectPartnerSub(String business_num) {
		Partners_subDTO psdto = null;
		try {
			conn = ds.getConnection();
			sql = "select * from partners_subT where business_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, business_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				psdto = new Partners_subDTO();
	
				psdto.setBusiness_num(rs.getString("business_num"));
				psdto.setpShortstate(rs.getString("pShortstate")); 
			//	psdto.setpInt_img(rs.getString("pInt_img")); psdto.setpComp_logo(rs.getString("pComp_logo")); 
				psdto.setpService(rs.getString("pService")); 
				psdto.setpHomepg(rs.getString("pHomepg")); 
				psdto.setpRes_build_type(rs.getString("pRes_build_type")); psdto.setpRes_space_type(rs.getString("pRes_space_type")); 
				psdto.setpCom_build_type(rs.getString("pCom_build_type")); psdto.setpCom_space_type(rs.getString("pCom_space_type"));
				psdto.setpRes_person_name(rs.getString("pRes_person_name")); 
				psdto.setpRes_person_tel(rs.getString("pRes_person_tel"));
				psdto.setpCom_person_name(rs.getString("pCom_person_name")); 
				psdto.setpCom_person_tel(rs.getString("pCom_person_tel"));
				psdto.setpBalance(rs.getInt("pBalance"));
				psdto.setpAccount_bank(rs.getString("pAccount_bank")); 
				psdto.setpAccount_name(rs.getString("pAccount_name"));
				psdto.setpAccount_num(rs.getString("pAccount_num"));
			//	psdto.setpAccount_num(rs.getString("pAccount_file")); psdto.setpAccount_num(rs.getString("pBusiness_lic_file"));

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
		return psdto;
	}

	
	
	
	//등록된 정보가 있는지 확인
	public int nullCheck(String business_num) {
		int res = 0;
		try {
			conn = ds.getConnection();
			sql = "select count(business_num) from partners_subT where business_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, business_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res=rs.getInt(1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return res;
	}
	
}