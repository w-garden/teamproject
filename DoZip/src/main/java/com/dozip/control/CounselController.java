package com.dozip.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dozip.dao.MemberDAOImpl;
import com.dozip.dao.QnaDAOImpl;
import com.dozip.vo.MemberVO;
import com.dozip.vo.QnaVO;

public class CounselController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		
		QnaDAOImpl qdao = new QnaDAOImpl();
		
		//쪽나누기
		int page = 1; //현재 쪽번호
		int limit = 5; //한 페이지에 보여지는 개수
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=qdao.getListCount(id);
		int maxpage = (int)((double)listcount/limit+0.95); //총페이지
		int startpage = (((int)((double)page/5+0.9))-1)*5+1; //시작페이지
		int endpage = maxpage; //마지막페이지
		
		if(endpage>startpage+5-1) endpage=startpage+5-1;
		
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage",endpage);
        request.setAttribute("maxpage",maxpage);
        request.setAttribute("listcount",listcount);
		
        //문의 리스트 출력(관리자)
  		List<QnaVO> qlist = new ArrayList<QnaVO>();
  		qlist = qdao.getQlist(id, page, limit);
  		System.out.println("qlist.size() = "+qlist.size());
  		request.setAttribute("qlist", qlist);
  		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./counsel/counsel_main.jsp"); //뷰페이지 경로 설정
		
		return forward;
	}

}
