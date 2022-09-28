package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.EstimateDAOImpl;
import com.dozip.vo.EstimateVO;

public class EstimateApplyOKController5 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		System.out.println("아이디"+id);
		
		EstimateVO e = new EstimateVO();
		e.setMem_id(id);
		e.setEst_zoning(request.getParameter("est_zoning"));
		e.setEst_use(request.getParameter("est_use"));
		e.setEst_areaP(request.getParameter("areaP"));
		e.setEst_areaM(request.getParameter("areaM"));
		e.setEst_detail(request.getParameter("detail"));
		e.setEst_detail01(request.getParameter("detail01"));
		e.setEst_detail02(request.getParameter("detail02"));
		e.setEst_detail03(request.getParameter("detail03"));
		e.setEst_detail04(request.getParameter("detail04"));
		e.setEst_detail05(request.getParameter("detail05"));
		e.setEst_detail06(request.getParameter("detail06"));
		e.setEst_detail07(request.getParameter("detail07"));
		e.setEst_detail08(request.getParameter("detail08"));
		
		e.setEst_bud(request.getParameter("est_bud"));
		e.setEst_start(request.getParameter("est_start"));
		e.setEst_end(request.getParameter("est_end"));
		
		e.setEst_name(request.getParameter("est_name"));
		e.setEst_phone(request.getParameter("est_phone"));
		e.setEst_addr(request.getParameter("est_addr"));
		e.setEst_desc(request.getParameter("est_desc"));
		
		System.out.println(e.toString());
		
		EstimateDAOImpl dao = new EstimateDAOImpl();
		int res = dao.insertEst(e);
		
		if(res==1) {System.out.println("성공");}
		else {System.out.println("실패");}
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("home.do");
				
		return forward;
	}
}
