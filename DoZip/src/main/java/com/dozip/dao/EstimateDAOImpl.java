package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
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

	//양식
	public int test(EstimateVO e) {
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
	public int insertEst(EstimateVO e) {
		int res=0;
		
		try {
			con = ds.getConnection();
			sql = "insert into estimateT"+
					"(est_num, mem_id, est_zoning, est_use, est_areaP, est_areaM, est_detail, est_detail01, est_detail02"
					+", est_detail03, est_detail04, est_detail05, est_detail06, est_detail07, est_detail08"+
					", est_bud, est_start, est_end, est_date, est_dateEnd, est_name, est_phone, est_desc, est_file)"
					+" values(est_num_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, e.getMem_id());
			pt.setString(2, e.getEst_zoning());
			pt.setString(3, e.getEst_use());
			pt.setString(4, e.getEst_areaP());
			pt.setString(5, e.getEst_areaM());
			pt.setString(6, e.getEst_detail());
			pt.setString(7, e.getEst_detail01());
			pt.setString(8, e.getEst_detail02());
			pt.setString(9, e.getEst_detail03());
			pt.setString(10, e.getEst_detail04());
			pt.setString(11, e.getEst_detail05());
			pt.setString(12, e.getEst_detail06());
			pt.setString(13, e.getEst_detail07());
			pt.setString(14, e.getEst_detail08());
			pt.setString(15, e.getEst_bud());
			pt.setString(16, e.getEst_start());
			pt.setString(17, e.getEst_end());
//			pt.setString(18, e.getEst_date());
			pt.setString(18, e.getEst_dateEnd());
			pt.setString(19, e.getEst_name());
			pt.setString(20, e.getEst_phone());
			pt.setString(21, e.getEst_desc());
			pt.setString(22, e.getEst_file());
			
			res = pt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}
		return res;
	}

	public void insertaa(String detail) {
		try {
			con = ds.getConnection();
			sql = "insert into aT (detail) values (?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, detail);
			pt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}		
	}

}
