<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />



		<article id="main_cont">
		<div style="width:1000px; height:700px; border:2px solid black;">
					<h1>사진등록페이지</h1>
					<form action ="p_upload_check.jsp" method="post" enctype="multipart/form-data">
					
						<input type="file" name="photo"><br>
						<input type="file" name="photo"><br>
						<input type="file" name="photo"><br>
						<input type="file" name="photo"><br>
					
						<input type="submit" value="등록">
					
					</form>
		
		</div>
		</article>
<jsp:include page="../include/footer.jsp" />


		