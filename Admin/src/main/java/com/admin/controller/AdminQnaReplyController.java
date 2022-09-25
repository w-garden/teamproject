package com.admin.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.QnaDAOImpl;
import com.admin.vo.QnaVO;

public class AdminQnaReplyController implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		
		QnaVO q = new QnaVO();
		q.setQna_ref(Integer.parseInt(request.getParameter("qna_ref")));
		q.setQna_step(Integer.parseInt(request.getParameter("qna_step")));
		q.setQna_level(Integer.parseInt(request.getParameter("qna_level")));
		q.setMem_id(request.getParameter("mem_id"));
		q.setQna_type(request.getParameter("qna_type"));
		q.setQna_title(request.getParameter("qna_title"));
		q.setQna_cont(request.getParameter("qna_cont"));
				
		QnaDAOImpl qdao = new QnaDAOImpl();
		int res = qdao.insertReply(q); //답글작성
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if(res == 1) { //성공
			out.println("<script>");
			out.println("alert('답글이 등록되었습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else { //실패
			out.println("<script>");
			out.println("alert('실패했습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}		
		return null;
	}

}
