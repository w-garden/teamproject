package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.MemberVO;

public class MemberDAOImpl {

	Connection con=null;//DB연결
	PreparedStatement pt=null; //쿼리문 수행
	ResultSet rs=null;//검색 결과 레코드를 저장 rs
	DataSource ds=null;//DBCP 커넥션풀 관리 ds
	String sql=null; //SQL 쿼리문
	
	public MemberDAOImpl() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/xe");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	//일반회원저장
	public int insertMember(MemberVO m) {
		int res = -1; 
		
		try {
			con = ds.getConnection();
			sql = "insert into memberT"
					+ "(mem_id, mem_pwd, mem_name, mem_tel, mem_email, mem_domain, mem_joinType)"
					+ "values (?,?,?,?,?,?,'일반')";
			pt = con.prepareStatement(sql);
			pt.setString(1, m.getMem_id());
			pt.setString(2, m.getMem_pwd());
			pt.setString(3, m.getMem_name());
			pt.setString(4, m.getMem_tel());
			pt.setString(5, m.getMem_email());
			pt.setString(6, m.getMem_domain());
			
			res = pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pt != null) pt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return res;
	}//insertMember()

	
	//일반회원 로그인
	public String loginCheck(String mem_id) {
		String db_pwd = null;
		
		try {
			con = ds.getConnection();
			sql = "select mem_pwd from memberT where mem_id=? and mem_withdraw=0";
			pt = con.prepareStatement(sql);
			pt.setString(1, mem_id);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				db_pwd = rs.getNString("mem_pwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pt != null) pt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return db_pwd;
	}
}
