package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.EstimateDAOImpl;
import com.dozip.vo.EstimateVO;

public class EstimateApplyOKController5 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		EstimateVO e = new EstimateVO();
		
		
		String est_name = request.getParameter("est_name");
		String est_phone = request.getParameter("est_phone");
		String est_addr = request.getParameter("est_addr");
		String est_desc = request.getParameter("est_desc");
		
		EstimateDAOImpl dao = new EstimateDAOImpl();
		int res = dao.imsitest(est_name,est_phone,est_desc);
		
		if(res==1) {System.out.println("성공");}
		else {System.out.println("실패");}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("home.do");
				
		return forward;
	}
}
