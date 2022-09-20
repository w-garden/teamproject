package com.partners.controller;

import java.io.File;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.partners.dao.PortfolioDAO;

public class UploadPhotoOKController implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String saveFolder = request.getRealPath("upload"); //저장할 폴더 지정
		
		int fileSize = 10*1024*1024; //이진 파일 업로드 최대크기를 5M
		MultipartRequest multi = null;  // 이진 파일 업로드
		
		multi = new MultipartRequest(request, saveFolder, fileSize, "UTF-8");
		
		HttpSession session = request.getSession();
		
		

		 String business_num = (String)session.getAttribute("business_num");
		 
		 /*
		  * 포트폴리오의 제목을 불러와야함 
		  * 폴더 경로 지정시 필요 
		  * 
		  * 
		  */
		 
		 Cookie[] cookies = request.getCookies();
		 
		 for(Cookie c: cookies) {

			 if(c.getName().equals("pf_no")) {
				 System.out.println(c.getValue());
			 }
			 
			 
		 }
		 
		 
		 
		/**
		 * 폴더명 /upload/사업자번호
		 */
		String homedir=saveFolder+"/"+business_num; /* 업체 사업자 번호로 폴더 생성*/
		
		
		File [] upFile = new File[5];
		
		for(int i=0; i<5;i++) {
			upFile[i] = multi.getFile("photo0"+(i+1)); // 첨부한 이진파일을 가져옴
			if(upFile[i] != null) {
				String fileName = upFile[i].getName(); //첨부
				
				File path01 = new File(homedir); // 첨부할 사진 폴더 생성		
				
				int index=fileName.lastIndexOf("."); //첨부파일에서 마침표 위치를 구함
				String fileExtendsion = fileName.substring(index+1); //마침표 이후부터 마지막 문자까지 구함. 즉 파일의 확장자를 구함

				
				String refileName ="photo0"+(i+1)+"."+fileExtendsion;
				
				
				if(!(path01.exists())) { //첨부할 폴더가 없다면 
					path01.mkdir(); // 해당 포트폴리오 폴더 생성
				}
						
				upFile[i].renameTo(new File(homedir+"/"+refileName));  //새롭게 생성된 폴더 경로에 업로드
			
				
				//오라클에 저장될 레코드값
				//  /Partners/upload/사업자번호/포트폴리오제목/photo01.jpg
				//  /Partners/upload/사업자번호/"포트폴리오제목"/photo02.jpg
				//  /Partners/upload/"사업자번호"/"포트폴리오제목"/photo03.jpg
				//  /Partners/upload/"사업자번호"/"포트폴리오제목"/photo04.jpg
				//  /Partners/upload/"사업자번호"/"포트폴리오제목"/photo05.jpg
				
				
				
				PortfolioDAO dao = new PortfolioDAO();
				//dao.selectOnePortfolio(business_num);
				
				
				
				String fileDBName ="/Partners/upload/사업자번호/포트폴리오제목/"+refileName;
				
				
				
				
				
			} 
			if(i==4) {
				out.println("<script>");
				out.println("alert('정상적으로 등록되었습니다!')");
				out.println("location='/Partners/main.jsp'");
				out.println("</script>");
			}
		}
		return null;
	}
	
}
