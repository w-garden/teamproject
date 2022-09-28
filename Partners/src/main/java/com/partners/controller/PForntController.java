package com.partners.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//실행 partners_login
public class PForntController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		
		String RequestURI = request.getRequestURI(); // /Partners/*.do 를 구함
		String contextPath = request.getContextPath(); // 컨텍스트 패스 경로를 구함 /Partners
		String command = RequestURI.substring(contextPath.length()); // /Partners 컨텍스트 패스 경로 이후 URI 매핑 주소인 *.do 를 구함

		ActionForward forward = null;
		Action action = null;

		Properties prop = new Properties(); // 컬랙션 클래스 키, 값 쌍으로 저장하는 자료 구조
		FileInputStream fis = new FileInputStream(request.getRealPath("WEB-INF/classes/partners.properties"));

		prop.load(fis);
		fis.close();

		String value = prop.getProperty(command); // 키 이름 매핑 주소에 해당하는 값을 구함
		if (value.subSequence(0, 7).equals("execute")) {
			try {
				StringTokenizer st = new StringTokenizer(value, "@");
				String url_1 = st.nextToken(); // 분리된 토큰 문자열을 execute를 구함.
				String url_2 = st.nextToken(); // @이후 풀패키지 경로는 구함. => com.partners.controller.컨트롤러클래스명
				Class url = Class.forName(url_2);

				action = (Action) url.newInstance();
				try {
					forward = action.execute(request, response); // 컨트롤러에 오버라이딩 된 execute()메서드를 호출해서 Actionforward 생성
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			} catch (InstantiationException ex) {
				ex.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath()); // 새로운 매핑 주소로 이동
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);// 매핑주소값 , 리퀘스트와 세션객체 유지
			}
		}
	}
}
