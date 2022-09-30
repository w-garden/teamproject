package com.partners.controller;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.PartnersDAO;
import com.partners.dto.PartnersDTO;

public class PartnersFindInfoPwdController implements Action {
	static Properties prop;
	static Session session;
	static MimeMessage message;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String findpwd_business_num = request.getParameter("findpwd_business_num");
		String findpwd_pId = request.getParameter("findpwd_pId");
		String findpwd_pName = request.getParameter("findpwd_pName");

		PartnersDAO dao = new PartnersDAO();
		PartnersDTO dto = dao.selectPartner(findpwd_pId);
		
		try {		
			String db_business_num = dto.getBusiness_num();
			String db_pId = dto.getpId();
			String db_pName = dto.getpName();		
			if (db_business_num.equals(findpwd_business_num)  && db_pId.equals(findpwd_pId)  && db_pName.equals(findpwd_pName)) {
				final String user = "w.garden316@gmail.com";
				final String password = "";

				// Step 1 프로퍼티 생성
				prop = new Properties();
				// "mail.smtp.host" 은 이메일 발송을 처리해줄 SMTP 서버를 나타냄
				// gmail 을 사용할 때는 "smtp.gmail.com"

				prop.put("mail.smtp.host", "smtp.gmail.com");
				// "mail.smtp.port " 은 SMTP서버와 통신하는 포트를 말함 gmail 은 465 네이버는 587을 사용
				prop.put("mail.smtp.port", 465);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.ssl.enable", "true");
				prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

				// Step 2 세션 설정
				Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

				// Step 3 메시지 작성
				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(user));

					
					String email_id = dto.getpMail_id();		
					String email_domain = dto.getpMail_domain();		
					String email =email_id+"@"+email_domain;
					
					
					
					
					// 수신자 이메일 주소
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					
					
					message.setSubject("[DOZIP]비밀번호 찾기 결과");
					
					
					message.setText("당신의 비밀번호는 " + dto.getpPw() + " 입니다.");

					// Step 4 이메일 보내기
					Transport.send(message);
					System.out.println("메시지가 성공적으로 전송되었습니다.");
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				
				 out.println("<script>"); 
				 out.println("alert('이메일 전송 완료!')");
   				 out.println("location='partners_login.do'");
				 out.println("</script>");
			} 
			else {
				out.println("<script>");
				out.println("alert('일치하는 정보가 없습니다!')");
				out.println("location='partners_login.do'");
				out.println("</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("<script>");
			out.println("alert('일치하는 정보가 없습니다!')");
			out.println("location='partners_login.do'");
			out.println("</script>");
		}
		return null;
	}
}