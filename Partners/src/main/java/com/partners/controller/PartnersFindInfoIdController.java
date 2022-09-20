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

public class PartnersFindInfoIdController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String findid_business_num = request.getParameter("findid_business_num");
		String tmpfindid_pTel = request.getParameter("findid_pTel");
		String findid_pTel = tmpfindid_pTel.replaceAll("-", "");
		String findid_email = request.getParameter("findid_email");
		
		PartnersDAO dao = new PartnersDAO();
		PartnersDTO dto = dao.findID(findid_business_num);
		
		try {		
			String db_business_num = dto.getBusiness_num();
			String db_pTel = dto.getpTel();
						
			String email_id = dto.getpMail_id();		
			String email_domain = dto.getpMail_domain();		
			String db_email =email_id+"@"+email_domain;
			
			if (db_business_num.equals(findid_business_num)  && db_pTel.equals(findid_pTel)  && db_email.equals(findid_email)) {
				
				 out.println("<script>"); 
				 out.println("alert('당신의 아이디는 " + dto.getpId() + " 입니다.')");
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
			out.println("<script>");
			out.println("alert('일치하는 정보가 없습니다!')");
			out.println("location='partners_login.do'");
			out.println("</script>");
		}
		return null;
	}
}