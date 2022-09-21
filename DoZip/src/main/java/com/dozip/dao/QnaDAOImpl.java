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

	//업체 리스트 출력
	public List<String> parternList() {
		List<String> list = new ArrayList<String>();
		try {
			con = ds.getConnection();
			sql = "select businessName from partnersT";
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				list.add(name);
			}						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return list;
	}

	//업체명으로 사업자번호 가져오기
	public String getBnum(String businessName) {
		String bNum = null;
		try {
			con = ds.getConnection();
			sql = "select business_num from partnersT where businessName=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, businessName);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				bNum = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return bNum;
	}
	
	//사업자번호로 업체명 가져오기
	public String getBname(String business_num) {
		String bName = null;
		try {
			con = ds.getConnection();
			sql = "select businessName from partnersT where business_num=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, business_num);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				bName = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return bName;
	}

	//아이디로 문의 리스트 불러오기
	public List<QnaVO> getPlist(String id) {
		List<QnaVO> list = new ArrayList<>();
		QnaVO vo = null;
		try {
			con = ds.getConnection();
			sql = "select * from qnaT where mem_id=? order by qna_no desc";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			
			while(rs.next()) {
				vo = new QnaVO();
				vo.setQna_no(rs.getInt(1));
				vo.setMem_id(rs.getString(2));
				vo.setBusiness_num(rs.getString(3));
				vo.setQna_type(rs.getString(4));
				vo.setQna_title(rs.getString(5));
				vo.setQna_cont(rs.getString(6));
				vo.setQna_date(rs.getString(7));
				vo.setEdit_date(rs.getString(8));
				vo.setQna_state(rs.getInt(9));
				vo.setQna_ref(rs.getInt(10));
				vo.setQna_step(rs.getInt(11));
				vo.setQna_level(rs.getInt(12));
				vo.setReply_state(rs.getString(13));
				vo.setReply_date(rs.getString(14));	
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return list;
	}
	
	
}
