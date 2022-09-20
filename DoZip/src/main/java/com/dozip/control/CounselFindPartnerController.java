package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dozip.dao.QnaDAOImpl;

public class CounselFindPartnerController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<String> list = new ArrayList<String>();
		
		QnaDAOImpl qdao = new QnaDAOImpl();
		
		list = qdao.parternList();
		request.setAttribute("list", list);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./counsel/counsel_find_partner.jsp");
		
		return forward;
	}

}
