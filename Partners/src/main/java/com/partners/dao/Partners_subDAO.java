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
	
	//data_manage에 정보 가져오기
	public int insertPartnersSub(Partners_subDTO dto) {
		int result=0;
		
		try {
			conn=ds.getConnection();
			sql="insert into partners_subT (business_num,pShortstate,pInt_img,pComp_logo,pService,pHomepg,"
			+ "pRes_build_type,pRes_space_type,pCom_build_type,pCom_space_type,pRes_person_name,pRes_person_tel,"
			+ "pBalance,pAccount_bank,pAccount_name,pAccount_num,pAccount_file,pBusiness_lic_file) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBusiness_num());
			pstmt.setString(2, dto.getpShortstate());
			pstmt.setString(3, dto.getpInt_img());
			pstmt.setString(4, dto.getpComp_logo());
			pstmt.setString(5, dto.getpService());
			pstmt.setString(6, dto.getpHomepg());
			pstmt.setString(7, dto.getpRes_build_type());
			pstmt.setString(8, dto.getpRes_space_type());
			pstmt.setString(9, dto.getpCom_build_type());
			pstmt.setString(10, dto.getpCom_space_type());
			pstmt.setString(11, dto.getpRes_person_name());
			pstmt.setString(12, dto.getpRes_person_tel());
			pstmt.setString(13, dto.getpCom_person_name());
			pstmt.setString(14, dto.getpCom_person_tel());
			pstmt.setInt(15, dto.getpBalance());
			pstmt.setString(16, dto.getpAccount_bank());
			pstmt.setString(17, dto.getpAccount_name());
			pstmt.setString(18, dto.getpAccount_num());
			pstmt.setString(19, dto.getpAccount_file());
			pstmt.setString(20, dto.getpBusiness_lic_file());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
		}
		return result;
	}
	
}