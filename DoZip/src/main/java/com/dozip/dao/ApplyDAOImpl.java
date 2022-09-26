package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.PartnersVO;


public class ApplyDAOImpl {
	Connection con=null;//DB연결
	PreparedStatement pt=null; //쿼리문 수행
	ResultSet rs=null;//검색 결과 레코드를 저장 rs
	DataSource ds=null;//DBCP 커넥션풀 관리 ds
	String sql=null; //SQL 쿼리문
	
	public ApplyDAOImpl() {
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
	//시공주소 주변에 있는 파트너스 정보 불러오기
	public List<PartnersVO> selectNearPartners(String applyAddress) {
		
		List<PartnersVO> list=new ArrayList<PartnersVO>();
	
		
		String str = "%"+applyAddress+"%"; //임시로 만들어 놓
		
		
		
		try {
			con = ds.getConnection();
			sql="select * from partnersT where pAddress like ? and pState=1";
			pt= con.prepareStatement(sql);
			pt.setString(1, str);
			rs=pt.executeQuery();
			while(rs.next()) {
				PartnersVO pdto = new PartnersVO();
				pdto.setBusiness_num(rs.getString("business_num"));
				pdto.setBusinessName(rs.getString("businessName"));
				pdto.setpTel(rs.getNString("pTel"));
				pdto.setpAddress(rs.getString("pAddress"));
				list.add(pdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pt);
				close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return list;
	}
	//시공주소 주변에 있는 파트너스 업체 수 불러오기

	public int countNearPartners(String applyAddress) {
		int count=0;	
		
		String str = "%"+applyAddress+"%"; //임시로 만들어 놓

		try {
			con=ds.getConnection();
			sql="select count(*) from partnersT where pAddress like ? and pState=1";
			pt=con.prepareStatement(sql);
			pt.setString(1, str);
			rs=pt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pt);
				close(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
}
