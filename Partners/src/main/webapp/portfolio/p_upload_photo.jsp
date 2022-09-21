<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />



					<h1>사진등록페이지</h1>
					<form action ="upload_photo_ok.do" method="post" enctype="multipart/form-data">
					
						<input type="file" name="photo01" id="photo01"><br>
						<input type="file" name="photo02" id="photo02"><br>
						<input type="file" name="photo03" id="photo03"><br>
						<input type="file" name="photo04" id="photo04"><br>
						<input type="file" name="photo05" id="photo05"><br>
					
						<input type="submit" value="등록">
					
					</form>
		
<jsp:include page="../include/footer.jsp" />


		