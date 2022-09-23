package com.partners.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email_test {
	static Properties prop;
	static Session session;
	static MimeMessage message;

	public static void main(String[] args) {
		gernerateAndSendEmail();
		System.out.println("전송중");
	}

	private static void gernerateAndSendEmail() {
		final String user = "w.garden316@gmail.com";
		final String password = "";
		
		
		//Step 1 프로퍼티 생성
		prop = new Properties();
		// "mail.smtp.host" 은 이메일 발송을 처리해줄 SMTP 서버를 나타냄
		// gmail 을 사용할 때는 "smtp.gmail.com"

		prop.put("mail.smtp.host", "smtp.gmail.com");
		// "mail.smtp.port " 은 SMTP서버와 통신하는 포트를 말함 gmail 은 465 네이버는 587을 사용
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		
		//Step 2 세션 설정
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		//Step 3 메시지 작성
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			//수신자 이메일 주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("shc729@naver.com"));
			
			message.setSubject("안녕하세요");
			
			message.setText("내용입니다");
			
			
			//Step 4 이메일 보내기
			
			Transport.send(message);
			System.out.println("메시지가 성공적으로 전송되었습니다.");
		} catch (AddressException e) {
			e.printStackTrace();
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
