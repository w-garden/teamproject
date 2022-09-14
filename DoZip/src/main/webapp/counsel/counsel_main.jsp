<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp" />
<script src="../js/jquery.js" ></script>

<%-- 상단 공통부분 끝 --%>


<div class="counsel_wrap">
	<div class="counsel_info">
		<div id="info_text">
			<p id="info_text_b">질문과 답변</p>
			<p id="info_text_s">자주하는 질문과 답변을 확인해보세요</p>
		</div>
		<div class="btn_group">
			<button id="qna_write_btn"><a href="./counsel_write.jsp" >문의글 작성하기</a></button>
			<button id="real_counsel_btn"><a href="#" >1:1 실시간 상담하기</a></button>
		</div>
	</div>
	
	<div class="my_qna">
		<div class="my_qna_title"><p>나의 문의</p></div>
		<div class="my_qna_cont">
			<table>
				<tr>
					<th id="head_num">번호</th> <th id="head_title">제목</th> <th id="qna_state">답변상태</th><th id="head_date">작성일</th>
				</tr>
				<%! int i = 0; %>
				<% for(i=1; i<5; i++) { %>
				<tr>
					<td id="num"><%=i %></td> <td id="title"><a href="#"><%=i %>번 글 제목</a></td> <td id="state">답변대기중</td> <td id="date"><%=i %>번 글 날짜</td>
				</tr>
				<% } %>
			</table>
		</div>
	</div>

	<div class="qna_part">
		<div class="qna_btn_group">
			<button type="button" onclick="">서비스안내</button>
			<button type="button" onclick="">견적</button>
			<button type="button" onclick="">상담</button>
			<button type="button" onclick="">계약</button>
			<button type="button" onclick="">공사</button>
			<button type="button" onclick="">시공후</button>
			<button type="button" onclick="">파트너스</button>
		</div>
		
		<div class="qna_cont">
			<div class="qna_menu">
				<span>회원 아이디와 비밀번호가 기억나지 않아요.</span>
			</div>
			<div class="qna_hide">
				집닥​ 홈페이지 상단 → 로그인 메뉴를 누르신 다음 노출되는 창에서 제일 하단 '이메일로 로그인하기' 로 들어가시면 아이디 또는 비밀번호를 찾으실 수 있습니다. 
				그래도 찾지 못하실 경우, 고객센터로 연락주시면 신속히 도움 드리겠습니다.
			</div>
			<% for(i=1; i<4; i++){ %>
			<div class="qna_menu">
				<span><%=i %>번 질문</span>
			</div>
			<div class="qna_hide">
				<%=i %>번 답변
			</div>
		<%} %>
		</div>
	</div>
	


</div>

<script>
	$(".qna_menu").click(function() {
		$(this).next(".qna_hide").stop().slideToggle(300);
		$(this).toggleClass('on').siblings().removeClass('on');
		$(this).next(".qna_hide").siblings(".qna_hide").slideUp(300);
	});
</script>


<%-- 하단 공통부분 --%>
<jsp:include page="../common/footer.jsp" />