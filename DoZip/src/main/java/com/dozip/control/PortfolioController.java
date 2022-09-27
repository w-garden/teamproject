package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PortfolioVO;



public class PortfolioController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PortfolioDAOImpl pdao = new PortfolioDAOImpl();

		
		List<PortfolioVO> plist = new ArrayList<>(); 
		plist = pdao.getAllList();
		request.setAttribute("plist", plist);
		

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./portfolio/port_main.jsp"); // 뷰페이지 경로 설정

		return forward;
	}

}
