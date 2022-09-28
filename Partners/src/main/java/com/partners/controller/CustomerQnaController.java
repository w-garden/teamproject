package com.partners.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.QnaDAO;
import com.partners.dto.QnaDTO;

public class CustomerQnaController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// 로그인한 파트너스 사업자 번호(세션에 저장되 있음) 불러오기
		HttpSession session = request.getSession();
		String business_num = (String) session.getAttribute("business_num");

		String find_field = null;
		String find_text = null;
		String answer = null;
		QnaDTO findQ = new QnaDTO();

		
		if(request.getParameter("answer")!=null) {
			answer=request.getParameter("answer");
		}
		
		if(request.getParameter("find_text")!= null && request.getParameter("find_field") != null) {
			find_text = request.getParameter("find_text").trim();
			find_field = request.getParameter("find_field");
			if (find_field.equals("customer_name")) {
				findQ.setFind_text(find_text);
			} else if (find_field.equals("qna_type")) {
				findQ.setFind_text("%" + find_text + "%");
			}
		}
		findQ.setFind_field(find_field);
		findQ.setAnswer(answer);

		// 사업자 번호 기준으로 qnaT 에서 정보 담아서 list에 저장하기
		QnaDAO qdao = new QnaDAO();
		List<QnaDTO> qlist = qdao.getQnaList(business_num, findQ); // 검색 전후 목록

		
		request.setAttribute("answer", answer);
		request.setAttribute("find_text", find_text);
		request.setAttribute("find_field", find_field);
		request.setAttribute("qlist", qlist);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/customer/qna.jsp");
		return forward;
	}

}
