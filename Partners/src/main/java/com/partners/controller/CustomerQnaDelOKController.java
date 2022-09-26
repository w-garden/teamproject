package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.partners.dao.QnaDAO;

public class CustomerQnaDelOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		
		QnaDAO qdao = new QnaDAO();
		qdao.deleteReply(qna_no);
		return null;
	}

}
