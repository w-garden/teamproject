<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="include/header.jsp" />
<style>
.image-box {
    width:700px;
    height:300px;
    overflow:hidden;
    margin:0 auto;
    border: 3px solid black;
}

.image-thumbnail {
    width:100%;
    height:100%;
    object-fit:cover;
}
</style>
		<div style="width:100%; height:900px;"> 
					<h1>메인내용</h1>
					<div class="image-box">
					<img src="/Partners/images/logo2.png" alt="메인로고" class="image-thumbnail">
					</div>
			</div>
	
<jsp:include page="include/footer.jsp" />