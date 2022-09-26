package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.vo.EstimateVO;

public class EstimateApplyOKController2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		EstimateVO e = new EstimateVO();
		
		String est_bud = request.getParameter("est_bud");
		String est_start = request.getParameter("est_start");
		String est_end = request.getParameter("est_end");

		System.out.println("예산 : "+est_bud);
		System.out.println("시작일 : "+est_start);
		System.out.println("종료일 : "+est_end);


		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("estimate_apply3.do");
				
		return forward;


		/*
		EstimateDAOImpl edao = new EstimateDAOImpl();
		
		e.setEst_zoning(request.getParameter("est_zoning"));
		
		int res=0;
		res = edao.insertEst(e); 
		/*
		int areaP = Integer.parseInt(request.getParameter("est_areaP"));
		int areaM = Integer.parseInt(request.getParameter("est_areaM"));
		
		e.setEst_zoning(request.getParameter("est_zoning")); //공간유형
		e.setEst_use(request.getParameter("est_use")); //건물유형
		String use = e.getEst_use();
		e.setEst_areaP(areaP); //평수(평)
		e.setEst_areaM(areaM); //평수(제곱미터)
		e.setEst_detail01(request.getParameter("est_detail01")); //도배/벽
		e.setEst_detail02(request.getParameter("est_detail02")); //바닥
		e.setEst_detail03(request.getParameter("est_detail03")); //주방
		e.setEst_detail04(request.getParameter("est_detail04")); //욕실
		e.setEst_detail05(request.getParameter("est_detail05")); //현관
		e.setEst_detail06(request.getParameter("est_detail06")); //발코니/샷시
		e.setEst_detail07(request.getParameter("est_detail07")); //조명
		e.setEst_detail08(request.getParameter("est_detail08")); //문
		
		*/
		

	}
}
