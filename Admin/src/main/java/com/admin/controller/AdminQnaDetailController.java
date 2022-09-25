package com.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.QnaDAOImpl;
import com.admin.vo.QnaVO;

public class AdminQnaDetailController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));		
		System.out.println("넘어온 글번호 "+ qna_no);
		//문의글은 조회수 체크하지 않음
		//팝업으로 띄울거라 페이지 받아오지 않음
		
		QnaDAOImpl qdao = new QnaDAOImpl();
		QnaVO q = qdao.getDetail(qna_no);
		String qna_cont = q.getQna_cont().replace("\n", "<br/>");
		
		request.setAttribute("q", q);
		request.setAttribute("qna_cont", qna_cont);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./views/qna_detail.jsp"); //뷰페이지 경로 설정
		
		return forward;
	}

}
