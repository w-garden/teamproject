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
		
		String est_zoning = request.getParameter("est_zoning");
		String est_use = request.getParameter("est_use");
		String areaP = request.getParameter("areaP");
		String areaM = request.getParameter("areaM");
		String detail = request.getParameter("detail");
		String detail01 = request.getParameter("detail01");
		String detail02 = request.getParameter("detail02");
		String detail03 = request.getParameter("detail03");
		String detail04 = request.getParameter("detail04");
		String detail05 = request.getParameter("detail05");
		String detail06 = request.getParameter("detail06");
		String detail07 = request.getParameter("detail07");
		String detail08 = request.getParameter("detail08");
		
		String est_bud = request.getParameter("est_bud");
		String est_start = request.getParameter("est_start");
		String est_end = request.getParameter("est_end");
		
		String est_name = request.getParameter("est_name");
		String est_phone = request.getParameter("est_phone");
		String est_addr = request.getParameter("est_addr");
		String est_desc = request.getParameter("est_desc");
		
		EstimateVO e = new EstimateVO();
		e.setEst_zoning(est_zoning); e.setEst_use(est_use); e.setEst_areaP(areaP); e.setEst_areaM(areaM);
		e.setEst_detail(detail); e.setEst_detail01(detail01); e.setEst_detail02(detail02); e.setEst_detail03(detail03); e.setEst_detail04(detail04);
		e.setEst_detail05(detail05); e.setEst_detail06(detail06); e.setEst_detail07(detail07); e.setEst_detail(detail08);
		e.setEst_bud(est_bud); e.setEst_start(est_start); e.setEst_end(est_end); e.setEst_name(est_name);
		e.setEst_phone(est_phone); e.setEst_addr(est_addr); e.setEst_desc(est_desc);
		
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
