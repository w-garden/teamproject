package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.admin.vo.QnaVO;

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

	//관리자 답변 작성
	public int insertReply(QnaVO q) {
		int res = 0;
		
		System.out.println("아이디" + q.getMem_id());
		System.out.println("타입" + q.getQna_type());
		System.out.println(q.getQna_title());
		System.out.println(q.getQna_cont());
		System.out.println(q.getQna_ref());
		System.out.println(q.getQna_step());
		System.out.println(q.getQna_level());
		try {
			con = ds.getConnection();
			
			sql="update qnaT set qna_level=qna_level+1 where qna_ref=? and qna_level>?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, q.getQna_ref());
			pt.setInt(2, q.getQna_level());
			pt.executeUpdate(); 
			
			sql = "insert into qnaT (qna_no,mem_id,qna_type,qna_title,qna_cont,qna_ref,qna_step,qna_level) "
					+ "values (qnaT_no_seq.nextval,?,?,?,?,?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, q.getMem_id());
			pt.setString(2, q.getQna_type());
			pt.setString(3, q.getQna_title());
			pt.setString(4, q.getQna_cont());
			pt.setInt(5, q.getQna_ref());
			pt.setInt(6, q.getQna_step()+1);
			pt.setInt(7, q.getQna_level()+1);			
			res = pt.executeUpdate();
			
			sql = "update qnaT set reply_state='답변완료', reply_date=sysdate where qna_no=?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, q.getQna_ref());
			pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}
		return res;
	}//insertReply()

	//전체 리스트 불러오기
	public List<QnaVO> getAllList(int page, int limit) {
		List<QnaVO> list = new ArrayList<>();
		QnaVO vo = null;
		int startrow = (page-1)*15+1;
		int endrow = startrow+limit-1;
		
		try {//답글순서와 상관없이 글작성순으로 출력
			con = ds.getConnection();
			sql = "select * from ("
					+ "select rowNum r, qna_no, q.mem_id, q.business_num, qna_type,qna_title,"
					+ "qna_cont,qna_date,edit_date,qna_state,qna_ref,qna_step,"
					+ "qna_level,reply_state,reply_date, p.businessName, m.mem_name "
					+ "from (select*from qnaT order by qna_no desc) q,partnersT p, memberT m  "
					+ "where q.business_num=p.business_num(+) and q.mem_id=m.mem_id(+)"
					+ ")where r>=? and r<=?";
			pt = con.prepareStatement(sql);
			pt.setInt(1,startrow);
			pt.setInt(2,endrow);
			rs = pt.executeQuery();			
			
			while(rs.next()) {
				vo = new QnaVO();
				vo.setQna_no(rs.getInt(2));
				vo.setMem_id(rs.getString(3));
				vo.setBusiness_num(rs.getString(4));
				vo.setQna_type(rs.getString(5));
				vo.setQna_title(rs.getString(6));
				vo.setQna_cont(rs.getString(7));
				vo.setQna_date(rs.getString(8));
				vo.setEdit_date(rs.getString(9));
				vo.setQna_state(rs.getInt(10));
				vo.setQna_ref(rs.getInt(11));
				vo.setQna_step(rs.getInt(12));
				vo.setQna_level(rs.getInt(13));
				vo.setReply_state(rs.getString(14));
				vo.setReply_date(rs.getString(15));	
				vo.setBusinessName(rs.getString(16));
				vo.setMem_name(rs.getString(17));
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

	//전체 작성 글 개수 확인
	public int getAllListCount() {
		int listcount = 0;
		
		try {
			con = ds.getConnection();
			sql = "select count(qna_no) from qnaT";
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			
			if(rs.next()) {listcount = rs.getInt(1);}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return listcount;
	}

	//글번호로 글 내용 가져오기
	public QnaVO getDetail(int qna_no) {
		QnaVO q = null;
		
		try {
			con = ds.getConnection();
			sql = "select * from qnaT where qna_no=?";
			pt = con.prepareStatement(sql);
			pt.setInt(1, qna_no);
			rs = pt.executeQuery();
			
			if(rs.next()) { //일단 필요한 값만 받아옴
				q = new QnaVO();
				q.setQna_no(rs.getInt("qna_no"));
				q.setMem_id(rs.getString("mem_id"));
				q.setQna_type(rs.getString("qna_type"));
				q.setQna_title(rs.getString("qna_title"));
				q.setQna_cont(rs.getString("qna_cont"));
				q.setQna_ref(rs.getInt("qna_ref"));
				q.setQna_step(rs.getInt("qna_step"));
				q.setQna_level(rs.getInt("qna_level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return q;
	}
	
	
}
