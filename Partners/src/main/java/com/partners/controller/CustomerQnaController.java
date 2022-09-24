package com.partners.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.QnaDAO;
import com.partners.dto.QnaDTO;

public class CustomerQnaController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인한 파트너스 사업자 번호(세션에 저장되 있음) 불러오기 
		HttpSession session= request.getSession();
		String business_num =(String) session.getAttribute("business_num");
		
		//사업자 번호 기준으로 qnaT 에서 정보 담아서 list에 저장하기
		QnaDAO dao = new QnaDAO();
		List<QnaDTO> qlist = dao.selectAllQna(business_num);
		
		/**
		 * 두집 회원 이름가져오기
		 * 다른 코드로 수정가능하면 바꿀예정 **/
		
		
		/*
		 * QnaT 에 두집 회원 이름 넣을지 고민중..
		 * 
		 */
		String mem_id = qlist.get(0).getMem_id();
		
		String mem_name = dao.selectMem_name(mem_id);
		
		
		
		
		
		request.setAttribute("qlist", qlist);
		request.setAttribute("mem_name", mem_name);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/customer/qna.jsp");
		return forward;
	}

}
