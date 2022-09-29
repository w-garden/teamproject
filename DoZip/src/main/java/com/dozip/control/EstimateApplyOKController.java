package com.dozip.control;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.vo.EstimateVO;

public class EstimateApplyOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		EstimateVO e = new EstimateVO();
	      
		String[] detail= {};
		String[] detail01 = {};
		String[] detail02 = {};
		String[] detail03 = {};
		String[] detail04 = {};
		String[] detail05 = {};
		String[] detail06 = {};
		String[] detail07 = {};
		String[] detail08 = {};

		
		String est_zoning = request.getParameter("est_zoning");
			System.out.println("공간유형 : "+est_zoning);
		String est_use = request.getParameter("est_use");
			System.out.println("건물유형 : "+est_use);
		String areaP = request.getParameter("areaP");
			System.out.println("평수 : "+areaP);
		String areaM = request.getParameter("areaM");
			System.out.println("제곱미터 : "+areaM);
			
		if(request.getParameterValues("check") != null) {
			detail = request.getParameterValues("check");
			System.out.print("원하는 공간 선택 : ");
				for(int i=0; i<detail.length; i++) {
					System.out.print(detail[i]+"|");
			}
		}
		if(request.getParameterValues("group_wallpaper_item") != null) {
			detail01 = request.getParameterValues("group_wallpaper_item");
			System.out.print("\n"+"도배/벽 세부사항 : ");
				for(int i=0; i<detail01.length; i++) {
					System.out.print(detail01[i]+"|");
			}
		}
		if(request.getParameterValues("group_floor_item") != null) {
			detail02 = request.getParameterValues("group_floor_item");
			System.out.print("\n"+"바닥 세부사항 : ");
				for(int i=0; i<detail02.length; i++) {
					System.out.print(detail02[i]+"|");
			}
		}
		if(request.getParameterValues("group_kitchen_item") != null) {
			detail03 = request.getParameterValues("group_kitchen_item");
			System.out.print("\n"+"주방 세부사항 : ");
			for(int i=0; i<detail03.length; i++) {
				System.out.print(detail03[i]+"|");
			}
		}
		if(request.getParameterValues("group_washroom_item") != null) {
			detail04 = request.getParameterValues("group_washroom_item");
			System.out.print("\n"+"욕실 세부사항 : ");
			for(int i=0; i<detail04.length; i++) {
				System.out.print(detail04[i]+"|");
			}
		}
		if(request.getParameterValues("group_porch_item") != null) {
			detail05 = request.getParameterValues("group_porch_item");
			System.out.print("\n"+"현관 세부사항 : ");
			for(int i=0; i<detail05.length; i++) {
				System.out.print(detail05[i]+"|");
			}
		}
		if(request.getParameterValues("group_window_item") != null) {
			detail06 = request.getParameterValues("group_window_item");
			System.out.print("\n"+"발코니/샷시 세부사항 : ");
			for(int i=0; i<detail06.length; i++) {
				System.out.print(detail06[i]+"|");
			}
		}
		if(request.getParameterValues("group_light_item") != null) {
			detail07 = request.getParameterValues("group_light_item");
			System.out.print("\n"+"조명 세부사항 : ");
			for(int i=0; i<detail07.length; i++) {
				System.out.print(detail07[i]+"|");
			}
		}
		if(request.getParameterValues("group_door_item") != null) {
			detail08 = request.getParameterValues("group_door_item");
			System.out.print("\n"+"문 세부사항 : ");
			for(int i=0; i<detail08.length; i++) {
				System.out.print(detail08[i]+"|");
			}
		}

			/*유효성검증
			if(est_use == null) {
				out.println("<script>");
				out.println("alert('건물 유형을 선택해 주세요!');");
				out.println("history.go(-1)");
				out.println("</script>");
			}
			if(areaP.equals("0") || areaP == "") {
				out.println("<script>");
				out.println("alert('평수를 입력해 주세요!');");
				out.println("history.go(-1)");
				out.println("</script>");
			}
			if(request.getParameterValues("check") == null) {
				out.println("<script>");
				out.println("alert('원하는 공간을 선택 주세요!');");
				out.println("history.go(-1)");
				out.println("</script>");
			}*/
			/*유효성검증끝*/
			
				ActionForward forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("estimate_apply2.do");
				
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
