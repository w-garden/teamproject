package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.dozip.vo.QnaVO;

public class QnaDAOImpl {

	Connection con=null;//DB연결
	PreparedStatement pt=null; //쿼리문 수행
	ResultSet rs=null;//검색 결과 레코드를 저장 rs
	DataSource ds=null;//DBCP 커넥션풀 관리 ds
	String sql=null; //SQL 쿼리문
	
	public QnaDAOImpl() {
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

	//문의글 작성
	public int insertQna(QnaVO q) {
		int res = 0;
		
		try {
			con = ds.getConnection();
			sql = "insert into qnaT "
					+ "(qna_no, mem_id, business_num, qna_type, qna_title, qna_cont, qna_step, reply_state)"
					+ "values (qnaT_no_seq.nextval,?,?,?,?,?,0,'미답변')"; //qna_date, qna_state는 디폴트 값이 설정되어있어서 자동으로 들어감
			pt = con.prepareStatement(sql);
			pt.setString(1, q.getMem_id());
			pt.setString(2, q.getBusiness_num());
			pt.setString(3, q.getQna_type());
			pt.setString(4, q.getQna_title());
			pt.setString(5, q.getQna_cont());
			
			res = pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}
		return res;
	}//insertQna()
	
	
}
