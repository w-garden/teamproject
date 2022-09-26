package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PortfolioDTO;



public class PortfolioController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PortfolioDAOImpl pdao = new PortfolioDAOImpl();

		
		List<PortfolioDTO> plist = new ArrayList<>(); 
		plist = pdao.getAllList();
		request.setAttribute("plist", plist);
		
		String keyword = request.getParameter("keyword"); //keyword 값을 가져와 검색
		System.out.println(keyword);
		
		List<PortfolioDTO> cp = new ArrayList<>();
		cp = pdao.searchComp(keyword);
		
		request.setAttribute("cp", cp);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/port_main.jsp"); // 뷰페이지 경로 설정

		return forward;
	}

}
