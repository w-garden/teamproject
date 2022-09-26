package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.PortfolioDAOImpl;
import com.dozip.vo.PortfolioVO;

//메인 홈 화면으로 들어가기
public class HomeController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PortfolioDAOImpl pdao = new PortfolioDAOImpl();
		
		List<PortfolioVO> plist = new ArrayList<>();
		plist = pdao.getAllList();
		request.setAttribute("plist", plist);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		
		return forward;
	}

}
