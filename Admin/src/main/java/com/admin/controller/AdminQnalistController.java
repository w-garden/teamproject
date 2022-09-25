package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.QnaDAOImpl;
import com.admin.vo.QnaVO;

public class AdminQnalistController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		QnaDAOImpl qdao = new QnaDAOImpl();
		
		//쪽나누기
		int page = 1; //현재 쪽번호
		int limit = 15; //한 페이지에 보여지는 개수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=qdao.getAllListCount();	//총 글 개수 확인
		System.out.println("전체글개수-"+listcount);
		
		int maxpage = (int)((double)listcount/limit+0.95); //총페이지
		System.out.println(maxpage);
		int startpage = (((int)((double)page/15+0.95))-1)*15+1; //시작페이지
		System.out.println(startpage);
		int endpage = maxpage; //마지막페이지
		System.out.println(endpage);
		
		if(endpage>startpage+15-1) endpage=startpage+15-1;
		
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage",endpage);
        request.setAttribute("maxpage",maxpage);
        request.setAttribute("listcount",listcount);
		
        //문의 리스트 출력(관리자+업체)
  		List<QnaVO> qlist = new ArrayList<QnaVO>();
  		qlist = qdao.getAllList(page, limit);
  		System.out.println("qlist.size() = "+qlist.size());
  		request.setAttribute("qlist", qlist);
  		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./views/qnaList.jsp");
		return forward;
	}

}
