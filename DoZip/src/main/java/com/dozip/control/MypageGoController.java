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

public class MypageGoController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("id"); //현재 로그인 되어있는 세션의 아이디 값
		
		QnaDAOImpl qdao = new QnaDAOImpl();
		
		/*관리자문의*/
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
  		request.setAttribute("qlist", qlist);
  		
  		
  		/*업체문의*/
		//쪽나누기
		int pageP = 1; //현재 쪽번호
		int limitP = 5; //한 페이지에 보여지는 개수
		
		if(request.getParameter("pageP")!=null) {
			pageP=Integer.parseInt(request.getParameter("pageP"));
		}
		
		int listcountP=qdao.getPListCount(id);	
		
		int maxpageP = (int)((double)listcountP/limitP+0.95); //총페이지
		int startpageP = (((int)((double)pageP/5+0.9))-1)*5+1; //시작페이지
		int endpageP = maxpageP; //마지막페이지
		
		if(endpageP>startpageP+5-1) endpageP=startpageP+5-1;
		
		request.setAttribute("pageP", pageP);
		request.setAttribute("startpageP", startpageP);
		request.setAttribute("endpageP",endpageP);
        request.setAttribute("maxpageP",maxpageP);
        request.setAttribute("listcountP",listcountP);
  		
		//문의 리스트 출력(업체)
  		List<QnaVO> qlist2 = new ArrayList<QnaVO>();
  		qlist2 = qdao.getPartnersQlist(id, pageP, limitP);
  		request.setAttribute("qlist2", qlist2);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./mypage/mypage_main.jsp");
		
		return forward;
	}
}
