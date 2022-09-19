package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.MemberDAOImpl;

public class MemberIdCheckController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String mem_id=request.getParameter("mem_id");//비동기식으로 전달된 아이디값을 저장
		
		MemberDAOImpl mdao=new MemberDAOImpl();
		int checkid = mdao.checkID(mem_id);
		
		out.println(checkid);//값 반환
		
		return null;
	}

}
