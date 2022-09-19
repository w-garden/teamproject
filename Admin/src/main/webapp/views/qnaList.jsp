<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page = "../include/header.jsp"/>
<%-- 상단 공통부분 끝 --%>
<link rel="stylesheet" type="text/css" href="/Admin/css/admin_qnaList.css" />
<script>
	function openPopUp() {
	    window.open("./admin_qna.jsp", "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=600, left=0, top=0");
	}
</script>


<div class="all_qna_list_wrap">
	<div>
		<p id="all_qna_list_title">고객문의 목록</p>
		<p>고객이 올린 문의글 전체를 관리며하며, 답변을 작성할 수 있습니다.</p>
	</div>
	<div>
		<table class="all_qna_list_table">
			<tr>
				<th> </th>
				<th id="qna_number">글번호</th><th>고객정보</th>
				<th>문의유형</th><th>제목</th><th>문의날짜</th>
				<th>답변상태</th><th>답변일자</th><th>답변작성</th>
			</tr>
			<tr>
				<th><input type="checkbox" /></th>
				<th><input type="text"/></th>
				<th><input type="text"/></th>
				<th>
					<select name="cw_check" id="cw_check">
						<option selected>문의유형</option>
						<option value="1">1번 문의유형</option>
						<option value="2">2번 문의유형</option>
						<option value="3">3번 문의유형</option>
						<option value="4">4번 문의유형</option>
						<option value="5">5번 문의유형</option>
					</select>
				</th>
				<th><input type="text"/></th>
				<th><input type="text"/></th>
				<th>
					<select name="answer_check" id="answer_check">
						<option selected>답변상태</option>
						<option value="1">미답변</option>
						<option value="2">답변완료</option>
					</select>
				</th>
				<th><input type="text"/></th>
				<th> - </th>
			</tr>
			<%! int i=0; %>
			<% for(i=1; i<20; i++){ %>
			<tr>
				<td><input type="checkbox" /></td>
				<td><%=i %></td><td>고객정보</td><td>문의유형</td>
				<td><a onclick="openPopUp()">제목은 길겠지요?</a></td>
				<td>2022-09-<%=i %></td><td>답변상태</td><td>2022-09-<%=i %></td>
				<td><button>작성</button></td>
			</tr>
			<%} %>
		</table>
	</div>
</div>



<%-- 하단 공통부분--%>
<jsp:include page = "../include/footer.jsp"/>