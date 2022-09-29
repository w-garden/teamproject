package com.dozip.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class DaoTest {

	Connection conn = null;// DB연결
	PreparedStatement pstmt = null; // 쿼리문 수행
	ResultSet rs = null;// 검색 결과 레코드를 저장 rs
	DataSource ds = null;// DBCP 커넥션풀 관리 ds
	String sql = null; // SQL 쿼리문
	String user = "admin";
	String pw = "1234";
	String drivername = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";

	// 문의글 100개 저장, 아이디는 20개씩 끊어서(member00~member01)
	// 사업자번호 123-12-12345 로 가입해야함
	public void insertQna() {
		sql = "insert into qnaT "
				+ "(qna_no, mem_id, business_num, qna_type, qna_title, qna_cont, qna_date, qna_ref, qna_step, qna_level, reply_state)"
				+ "values (qnaT_no_seq.nextval,?,?,?,?,?,sysdate,qnaT_no_seq.nextval,0,0,'미답변')";
		for (int i = 0; i < 99; i++) {

			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(url, user, pw);

				pstmt = conn.prepareStatement(sql);

				if (i < 20) {
					if (i < 10) {
						pstmt.setString(1, "member01");
						pstmt.setString(2, "123-12-12345");
						pstmt.setString(3, "1번 문의유형");
						pstmt.setString(4, "제목0" + i);
						pstmt.setString(5, "내용입니다0" + i);
					} else {
						pstmt.setString(1, "member02");
						pstmt.setString(2, "123-12-12345");
						pstmt.setString(3, "1번 문의유형");
						pstmt.setString(4, "제목" + i);
						pstmt.setString(5, "내용입니다" + i);
					}

				} else if (i < 40) {
					pstmt.setString(1, "member02");
					pstmt.setString(2, "123-12-12345");
					pstmt.setString(3, "2번 문의유형");
					pstmt.setString(4, "제목" + i);
					pstmt.setString(5, "내용입니다" + i);
				} else if (i < 60) {
					pstmt.setString(1, "member03");
					pstmt.setString(2, "123-12-12345");
					pstmt.setString(3, "3번 문의유형");
					pstmt.setString(4, "제목" + i);
					pstmt.setString(5, "내용입니다" + i);
				} else if (i < 80) {
					pstmt.setString(1, "member04");
					pstmt.setString(2, "123-12-12345");
					pstmt.setString(3, "4번 문의유형");
					pstmt.setString(4, "제목" + i);
					pstmt.setString(5, "내용입니다" + i);
				} else {
					pstmt.setString(1, "member05");
					pstmt.setString(2, "123-12-12345");
					pstmt.setString(3, "5번 문의유형");
					pstmt.setString(4, "제목" + i);
					pstmt.setString(5, "내용입니다" + i);
				}

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public void insertMember() {
		sql = "insert into memberT"
				+ "(mem_id, mem_pwd, mem_name, mem_tel, mem_email, mem_domain, mem_joinType)"
				+ "values (?,?,?,?,?,?,'일반')";
		for (int i = 1; i <= 5; i++) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(url, user, pw);

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, "member0"+i );
				pstmt.setString(2, "member0"+i);
				pstmt.setString(3, "사용자0"+i);
				pstmt.setString(4, "0101234123"+i);
				pstmt.setString(5, "member0"+i);
				pstmt.setString(6, "google.com");
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

	}
}
