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

		
		
		int page =1; //쪽번호
		int limit = 8; 																													//한페이지에 보여질 개수
		
		
		
		String find_field = null;
		String find_text = null;
		String answer = null;
		
		if(request.getParameter("page")!= null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		if(request.getParameter("answer")!=null) {
			answer=request.getParameter("answer");
		}
		QnaDTO findQ = new QnaDTO();

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
		findQ.setBusiness_num(business_num);
		QnaDAO qdao = new QnaDAO();
		
		int listcount = qdao.getListCount(findQ); //검색전후 레코드 개수 
		System.out.println("page : "+ page);
		List<QnaDTO> qlist = qdao.getQnaList(page, limit, findQ); // 검색 전후 목록
		int maxpage = (int)((double)listcount/limit+0.95); //총 페이지 수
		System.out.println("============================");
		int startpage = (((int)((double)page/10+0.9))-1)*10+1; //시작 페이지
		int endpage = maxpage; //마지막 페이지
		
		if(endpage>startpage+10-1) endpage=startpage+10-1;
		
		
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("listcount", listcount); //레코드 개수
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
