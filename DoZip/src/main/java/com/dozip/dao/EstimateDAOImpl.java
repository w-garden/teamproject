package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.EstimateVO;

public class EstimateDAOImpl {
	
	Connection con=null;//DB연결
	PreparedStatement pt=null; //쿼리문 수행
	ResultSet rs=null;//검색 결과 레코드를 저장 rs
	DataSource ds=null;//DBCP 커넥션풀 관리 ds
	String sql=null; //SQL 쿼리문
	
	public EstimateDAOImpl() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	public void close(Connection con) {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void close(PreparedStatement pt) {
		if (pt != null)
			try {
				pt.close();
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

	//견적서 등록
	public int insertEst(EstimateVO e) {
		int res=0;
		
		try {
			con = ds.getConnection();
			sql = "";
			pt = con.prepareStatement(sql);
			
			res = pt.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}
		
		return res;
	}

	//견적내용 DB에 저장
	public int imsitest(String est_name, String est_phone, String est_desc) {
		int res=0;
		try {
			con = ds.getConnection();
			sql = "insert into testT values (?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, est_name);
			pt.setString(2, est_phone);
			pt.setString(3, est_desc);
			res = pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}
		return res;
	}

}
