package com.partners.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



		int pf_no = 0; 
		Cookie[] cookies = request.getCookies();		 
		for(Cookie c: cookies) {
			if(c.getName().equals("pf_no")) {
				pf_no=Integer.parseInt(c.getValue()); //쿠키에서 포트폴리오 번호 가져옴 -> 사진 삽입 위해
			}
		}

		/**
		 * 폴더명 : /upload/포트폴리오번호 
		 */
		String homedir=saveFolder+"/"+pf_no;

		
		File [] upFile = new File[5];
		String [] fileDBName = new String[5];  //DB에 저장될 파일 레코드 값 배열로 담아서 DAO에 넘기기


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

				fileDBName[i] ="/Partners/upload/"+pf_no+"/"+refileName; //DB에 저장될 레코드 값
				//  /Partners/upload/포트폴리오번호/photo01.jpg
				

			}
			if(i==4) {
				PortfolioDAO dao = new PortfolioDAO();
				dao.selectOnePortfolio(fileDBName, pf_no);
				
				//등록된 쿠키 삭제
				Cookie delPf_no = new Cookie("pf_no", "");
				delPf_no.setMaxAge(0);
				response.addCookie(delPf_no); 
				out.println("<script>");
				out.println("alert('정상적으로 등록되었습니다!')");
				out.println("location='/Partners/index.jsp'");
				out.println("</script>");
			}
		}
		return null;
	}

}
