<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<!--메인 content-->


<article id="main_cont">
	<div style="width: 1000px; height: 700px; border: 1px solid black; margin:0 auto;">
	<h1> 포트폴리오 목록</h1>
		<table style="margin:0 auto;">
			<tr>
				<th>시공번호</th>
				<th>제목</th>
				<th>수정/삭제</th>
			</tr>
			<tr>
				<td>2</td>
				<td>이름</td>
				<td><input type="button" value="수정/삭제" onclick="location='p_modify.jsp'"></td>
			</tr>
			<tr>
				<td>1</td>
				<td>이름</td>
				<td><input type="button" value="수정/삭제" onclick="location='p_modify.jsp'"></td>
			</tr>
		</table>

	</div>

</article>
<jsp:include page="../include/footer.jsp" />

