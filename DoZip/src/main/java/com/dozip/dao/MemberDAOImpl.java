package com.dozip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;
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
			close(pt);
			close(con);
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
				db_pwd = rs.getString("mem_pwd");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return db_pwd;
	}//loginCheck()

	//회원가입 아이디 체크
	public int checkID(String mem_id) {
		int checkid = 0;
		
		try {
			con = ds.getConnection();
			sql = "select count(mem_id) from memberT where mem_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, mem_id);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				checkid = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}		
		return checkid;
	}//checkID()

	//아이디 회원의 정보를 불러옴
	public MemberVO getMemberInfo(String id) {
		MemberVO m = null;

		try {
			con = ds.getConnection();
			sql = "select * from memberT where mem_id=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, id);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				m = new MemberVO();
				m.setMem_id(rs.getString("mem_id"));
				m.setMem_pwd(rs.getString("mem_pwd"));
				m.setMem_name(rs.getString("mem_name"));
				m.setMem_tel(rs.getString("mem_tel"));
				m.setMem_email(rs.getString("mem_email"));
				m.setMem_domain(rs.getString("mem_domain"));
				m.setMem_zip(rs.getString("mem_zip"));
				m.setMem_addr1(rs.getString("mem_addr1"));
				m.setMem_addr2(rs.getString("mem_addr2"));
				m.setMem_joinType(rs.getString("mem_joinType"));
				m.setMem_joinDate(rs.getString("mem_joinDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return m;
	}//getMemberInfo()

	//마이페이지-회원정보수정
	public int updateMember(MemberVO m) {
		int res = 0; 
		
		try {
			con = ds.getConnection();
			sql = "update memberT set mem_name=?, mem_tel=?, mem_email=?, mem_domain=?, "
					+ "mem_zip=?, mem_addr1=?, mem_addr2=? where mem_id=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, m.getMem_name());
			pt.setString(2, m.getMem_tel());
			pt.setString(3, m.getMem_email());
			pt.setString(4, m.getMem_domain());
			pt.setString(5, m.getMem_zip());
			pt.setString(6, m.getMem_addr1());
			pt.setString(7, m.getMem_addr2());
			pt.setString(8, m.getMem_id());
			
			res = pt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}		
		return res;
	}//updateMember()

	//아이디 찾기
	public String getFindID(String mem_name, String mem_tel) {
		String mem_id=null;
		
		try {
			con = ds.getConnection();
			sql = "select mem_id from memberT where mem_name=? and mem_tel=?";
			pt = con.prepareStatement(sql);
			pt.setString(1, mem_name);
			pt.setString(2, mem_tel);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				mem_id = rs.getString(1);
			}
			System.out.println(mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}		
		return mem_id;
	}//getFindID()

	//비밀번호 변경
	public int changePwd(String id, String current_pwd, String new_pwd) {
		int res = 0;
		try {
			con = ds.getConnection();
			sql = "update memberT set mem_pwd=? where mem_id=? and (select mem_pwd from memberT where mem_id=?)=?";
			//where mem_id=? 가 없으면 전체 비밀번호가 바뀌게 된다. 
			pt=con.prepareStatement(sql);
			pt.setString(1, new_pwd);
			pt.setString(2, id);
			pt.setString(3, id);
			pt.setString(4, current_pwd);			
			res = pt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pt);
			close(con);
		}		
		return res;
	}//changePwd()

	//비번찾기
	public String getFindPW(MemberVO m) {
		String pwd = "";
		System.out.println(m.toString());
		try {
			con = ds.getConnection();
			sql = "select mem_pwd from memberT where mem_id=? and mem_name=? and mem_tel=? and mem_email=? and mem_domain=?";
			pt=con.prepareStatement(sql);
			pt.setString(1, m.getMem_id());
			pt.setString(2, m.getMem_name());
			pt.setString(3, m.getMem_tel());
			pt.setString(4, m.getMem_email());
			pt.setString(5, m.getMem_domain());
			rs = pt.executeQuery();
			
			if(rs.next()) {
				pwd = rs.getString(1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pt);
			close(con);
		}
		return pwd;
	}

	//메일로 임시비번 발송
	public int sendEmail(MemberVO m, String pwd) {
		int result=0;
		String imsiPw = "";
		for (int i = 0; i < 12; i++) {
			imsiPw += (char) ((Math.random() * 26) + 97);
		}
		int r = changePwd(m.getMem_id(),pwd,imsiPw);
		if(r==1) {
			
			String subject = "[두꺼비집] 임시비밀번호 발송메일입니다.";
			String msg = "";
			
	        msg += m.getMem_name() + "님의 임시 비밀번호입니다.\n 비밀번호를 변경하여 사용하세요.";
	        msg += "\n임시 비밀번호 : "+imsiPw;
	        
	        String host = "smtp.naver.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
	        String user = "dandell92@naver.com"; // 패스워드
	        String password = "비번입력후사용평소에는지워놓음"; 
	        String email = m.getMem_email()+"@"+m.getMem_domain();

	        // SMTP 서버 정보를 설정한다.
	        Properties props = new Properties();
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", 587);
	        props.put("mail.smtp.auth", "true");
	        
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        });

	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(user));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

	            // 메일 제목
	            message.setSubject(subject);

	            // 메일 내용
	            message.setText(msg);

	            // send the message
	            Transport.send(message);
	            result=1;
			} catch (Exception e) {
				System.out.println("메일발송 실패 : " + e);
			} finally {
				close(pt);
				close(con);
			}
		}else {result=0;}
		return result;
	}

	
	
	
	
}
