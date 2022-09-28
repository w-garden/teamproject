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
	Connection conn = null;
	PreparedStatement pstmt = null;
	DataSource ds = null;
	ResultSet rs = null;
	String sql = "";

	public QnaDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xe");
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

	// 검색전후 고객문의글 불러오기
	public List<QnaDTO> getQnaList(String business_num, QnaDTO findQ) {
		System.out.println(findQ.getAnswer());
		List<QnaDTO> qlist = new ArrayList<QnaDTO>();
		try {
			conn = ds.getConnection();
			sql = "select mem_name, qnaT.* from qnaT Left Join memberT On qnaT.mem_id = memberT.mem_id where business_num=? and qna_state=1 ";
			
			/*
			 * 
			 * 답변, 미답변 검색 쿼리문 추가부분
			 * 
			*/
			if(findQ.getAnswer()!=null) {
				if(findQ.getAnswer().equals("yes")) { //답변완료
					sql+=" and reply_state='답변완료'";
				}
				else if(findQ.getAnswer().equals("no")){ //답변 미완료
					sql+=" and reply_state='미답변'";
				}
			}

			/*
			 * 
			 * 검색어 쿼리문 추가 부분
			 * 
			*/
			
			if (findQ.getFind_field() != null && !findQ.getFind_field().equals("default"))  {
				if (findQ.getFind_field().equals("customer_name")) {
					sql += " and mem_name=?";
				} else if (findQ.getFind_field().equals("qna_type")) {
					sql += " and qna_type like ?";
				}
			}
			sql += " order by qna_ref desc, qna_level asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, business_num);

			if (findQ.getFind_field() != null && !findQ.getFind_field().equals("default")) { // 검색하는 경우
				System.out.println(findQ.getFind_text()+ "으로검색합니다");
				pstmt.setString(2, findQ.getFind_text());
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QnaDTO dto = new QnaDTO();
				dto.setQna_no(rs.getInt("qna_no"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setQna_type(rs.getString("qna_type"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_cont(rs.getString("qna_cont").replace("\n", "<br>"));
				dto.setQna_date(rs.getString("qna_date"));
				dto.setQna_ref(rs.getInt("qna_ref"));
				dto.setQna_step(rs.getInt("qna_step"));
				dto.setQna_level(rs.getInt("qna_level"));
				dto.setReply_state(rs.getString("reply_state"));
				dto.setReply_date(rs.getString("reply_date"));
				dto.setMem_name(rs.getString("mem_name"));

				qlist.add(dto);

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
		return qlist;
	}

	// 답변글 등록
	public int insertQna(QnaDTO qdto) {
		int result = 0;

		try {
			conn = ds.getConnection();
			sql = "update qnaT set qna_level=qna_level+1 where qna_ref=? and qna_level > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qdto.getQna_ref());
			pstmt.setInt(2, qdto.getQna_level());
			pstmt.executeUpdate();

			sql = "insert into qnaT (qna_no, mem_id, business_num, qna_type, qna_title, qna_cont, qna_ref, qna_step, qna_level, reply_state, reply_date) values"
					+ "(qnaT_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, '답변완료', sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qdto.getMem_id());
			pstmt.setString(2, qdto.getBusiness_num());
			pstmt.setString(3, qdto.getQna_type());
			pstmt.setString(4, "RE:");
			pstmt.setString(5, qdto.getQna_cont());
			pstmt.setInt(6, qdto.getQna_ref());
			pstmt.setInt(7, qdto.getQna_step() + 1);
			pstmt.setInt(8, qdto.getQna_level() + 1);
			result = pstmt.executeUpdate();
			
			sql="update qnat set reply_state='답변완료' where qna_ref=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qdto.getQna_ref());
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
		return result;
	}

	public void deleteReply(int qna_no) {
		try {
			conn = ds.getConnection();
			sql = "delete qnaT where qna_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qna_no);
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
