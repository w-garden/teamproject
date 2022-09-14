<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<jsp:include page="../include/header.jsp" />
<%
request.setCharacterEncoding("UTF-8");
MultipartRequest multi = new MultipartRequest(request,"/DoZip/images/main_images/portfolio");
%>


		<article id="main_cont">
		<div style="width:1000px; height:700px; border:2px solid black;">
					
					
			<h1> 등록 완료</h1>					
					
					
		
		</div>
		</article>
<jsp:include page="../include/footer.jsp" />


		