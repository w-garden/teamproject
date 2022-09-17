package com.admin.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AFrontController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI(); // Admin/*.do
		String contextPath = request.getContextPath(); // ContextPath 경로를 구함 /Admin
		String command = RequestURI.substring(contextPath.length()); // ContextPath 경로 이후 URI 매핑 주소인 *.do를 구함
		
		ActionForward forward = null;
		Action action = null;
		
		Properties prop = new Properties(); //컬렉션 클래스 키, 값 쌍으로 저장하는 자료구조
		FileInputStream fis = new FileInputStream(request.getRealPath("WEB-INF/classes/admin.properties"));
		
		prop.load(fis);
		fis.close();
		
		String value = prop.getProperty(command); //키, 이름 매핑 주소에 해당하는 값을 구함
		
		if(value.subSequence(0, 7).equals("execute")) {
			try {
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken(); //execute를 구하고
				String url_2 = st.nextToken(); // | 이후 패키지 경로를 구함 => com.admin.controller
				Class url = Class.forName(url_2);
				
				action = (Action)url.newInstance();
				try {
					forward = action.execute(request, response);
					
				}catch(Exception e) {e.printStackTrace();}
			}catch(ClassNotFoundException ce) { // 해당 클래스 파일을 찾지 못하는 경우
				ce.printStackTrace(); 
			}catch(InstantiationException ex) { // 추상클래스나 인터페이스를 객체화 하고자 할때
				ex.printStackTrace();
			}catch(IllegalAccessException el) { // 클래스 접근을 하지 못할때
				el.printStackTrace();
			}
		}//if
		
		if(forward != null) {
			if(forward.isRedirect()) { // true => 새로운 매핑 주소로 이동
				response.sendRedirect(forward.getPath()); 
			} else { // false => 포워드 매핑 주소값, 세션객체 유지
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response); //
			}
		}//if	
	}	
}
 