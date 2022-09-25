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

import com.partners.dto.QnaDTO;

public class QnaDAO {
	Connection conn=null;
	PreparedStatement pstmt =null;
	DataSource ds = null;
	ResultSet rs=null;
	String sql="";
	
	public QnaDAO() {
		try {
			Context context = new InitialContext();
			ds= (DataSource) context.lookup("java:comp/env/jdbc/xe");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
	
	
	//고객문의글 불러오기
	public List<QnaDTO> selectAllQna(String business_num) {
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		
		try {
			conn=ds.getConnection();
			sql="select * from qnaT where business_num=? and qna_state=1 order by qna_no DESC";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, business_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setQna_no(rs.getInt("qna_no"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setQna_type(rs.getString("qna_type"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_cont(rs.getString("qna_cont"));
				dto.setQna_date(rs.getString("qna_date"));
				dto.setReply_state(rs.getString("reply_state"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(rs);
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	//문의 페이지에서 쓸 회원 정보 가져오기
	public String selectMem_name(String mem_id) {
		String mem_name=null;
		try {
			conn= ds.getConnection();
			sql = "select mem_name from memberT where mem_id=?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				mem_name=rs.getString(1);
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
		return mem_name;
	}

	
	
	
	public int insertQna(QnaDTO qdto) {
		int result =0;
		
		try {
			conn =ds.getConnection();
			sql ="update qnaT set qna_level=qna_level+1 where qna_ref=? and qna_level > ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, qdto.getQna_ref());
			pstmt.setInt(2, qdto.getQna_level());
			pstmt.executeUpdate();
			
				
			
			sql="insert into qnaT (qna_no, mem_id, business_num, qna_title, qna_cont, qna_ref, qna_step, qna_level, reply_state, reply_date) values"+
							"(qnaT_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, '답변완료', sysdate) ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, qdto.getMem_id());
			pstmt.setString(2, qdto.getBusiness_num());
			pstmt.setString(3, "답변(수정전)");
			pstmt.setString(4, qdto.getQna_cont());
			pstmt.setInt(5, qdto.getQna_ref());
			pstmt.setInt(6, qdto.getQna_step()+1);
			pstmt.setInt(7, qdto.getQna_level()+1);
			
			
			result=pstmt.executeUpdate();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close(pstmt);
				close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
				
		return result;
	}

	
	
	
	
	
	
	
	
}
