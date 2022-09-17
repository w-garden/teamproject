package com.dozip.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(request.getRealPath("WEB-INF/classes/dozip.properties"));
		prop.load(fis);
		fis.close();

		String value = prop.getProperty(command);

		if (value.substring(0, 7).equals("execute")) {
			try {
				StringTokenizer st = new StringTokenizer(value, "|");
				String url_1 = st.nextToken();
				String url_2 = st.nextToken();
				Class url = Class.forName(url_2);

				action = (Action) url.newInstance();

				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException ce) {// 해당 클래스 파일을 못찾는 경우
				ce.printStackTrace();
			} catch (InstantiationException ex) {// 추상클래스 나 인터페이스를 인스턴스 즉 객체화 하고자 할때
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {// 클래스 접근을 못할 때
				ex.printStackTrace();
			}
		} // if

		if (forward != null) {
			if (forward.isRedirect()) { // true 일 경우 - 리다이렉트
				response.sendRedirect(forward.getPath());
			} else { // false 일 경우 - 포워드
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		} // if
	}
}
