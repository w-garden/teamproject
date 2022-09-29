package com.partners.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.partners.dao.QnaDAO;
import com.partners.dto.QnaDTO;

public class CustomerReplyOKController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		
		QnaDTO qdto = new QnaDTO();
		qdto.setMem_id(request.getParameter("mem_id")); //원본글 작성한 회원 아이디
		qdto.setBusiness_num((String)session.getAttribute("business_num")); //사업자번호
		qdto.setQna_type(request.getParameter("qna_type")); //질문유형
		qdto.setQna_cont(request.getParameter("qna_cont")); //답글내용
		qdto.setQna_ref(Integer.parseInt(request.getParameter("qna_ref"))); //그룹번호
		qdto.setQna_step(Integer.parseInt(request.getParameter("qna_step"))); //몇번째 답글인지
		qdto.setQna_level(Integer.parseInt(request.getParameter("qna_level")));//정렬순서
		QnaDAO qdao = new QnaDAO();
		
		int result = qdao.insertQna(qdto);
		
		
		
		if(result==1) {
			System.out.println("저장완료");
		}
		return null;
	}

}
