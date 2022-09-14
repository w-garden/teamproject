<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
%>
<meta charset="UTF-8">
<title>파트너스 메인</title>
<link rel="stylesheet" href="/Partners/css/main_style.css">
<link rel='stylesheet' href="/Partners/css/calendar.css"/> 
<link rel="stylesheet" href="/Partners/css/partners_style.css">
<link rel="stylesheet" href="/Partners/css/partners_style2.css">
<script src="/Partners/js/jquery.js"></script>
<script src="/Partners/js/javascript.js"></script>
<script src="/Partners/js/javascript2.js"></script>
<script src='/Partners/js/calendar.js'></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>


<body>
<!-- 좌측 사이드바 영역 -->
<div id="wrap">
	<div id="side_wrap">
			<ul id="side_menu">
				<li><a href="#" style="height:49px;"></a></li>
				<li><a href="/Partners/index.jsp">파트너스홈</a></li>
				<li><a href="#">요금제 ▼</a>
					<ul>
						<li><a href="/Partners/interior_Plan/plan.jsp">요금제안내</a></li>
					</ul>
				</li>
				<li><a href="#">견적의뢰 ▼</a>
					<ul>
						<li><a href="/Partners/estimate_request/bid.jsp">입찰의뢰</a></li>
						<li><a href="/Partners/estimate_request/construct_request.jsp">시공요청</a></li>
					</ul></li>
				<li><a href="#">견적관리 ▼</a>
					<ul>
						<li><a href="/Partners/estimate/estimate_list.jsp">견적목록</a></li>
					</ul></li>
				<li><a href="#">내 공사 ▼</a>
					<ul>
						<li><a href="/Partners/myinterior/interior_List.jsp">내 공사내역</a></li>
						<li><a href="/Partners/myinterior/schedule_List.jsp">일정 및 정산관리</a></li>
						<li><a href="/Partners/myinterior/settlement_details.jsp">정산내역</a></li>
					</ul></li>
				<li><a href="#">시공사례관리 ▼</a>
					<ul>
						<li><a href="/Partners/portfolio/p_upload.jsp">등록</a></li>
						<li><a href="/Partners/portfolio/p_list.jsp">수정/삭제</a></li>
					</ul></li>
				<li><a href="#">광고관리 ▼</a>
					<ul>
						<li><a href="/Partners/marketing/marketing.jsp">노출프로모션</a></li>
					</ul></li>
				<li><a href="#">고객관리 ▼</a>
					<ul>
						<li><a href="/Partners/customer/qna.jsp">고객문의</a></li>
						<li><a href="/Partners/customer/review.jsp">고객후기</a></li>
					</ul></li>
				<li><a href="#">마이페이지 ▼</a>
					<ul>
						<li><a href="/Partners/mypage/data_manage.jsp">내 정보관리</a></li>
						<li><a href="/Partners/mypage/pw_change.jsp">비밀번호 변경</a></li>
					</ul></li>
				
			</ul>
		</div>
	<div id="cont_wrap">
		<header>
			<div id="top_bar">
				<div id=top_title>
					<div>
						<a href="/DoZip/index.jsp"><img
							src="/Partners/images/logo.png" alt="메인로고"></a>
					</div>
					<div>파트너스 페이지</div>
				</div>
				<div class="msg">
					<span class="hide_1"> ${param.id} 님 환영합니다 <span id="timer"></span></span> <span
						class="hide_2"><input type="button" value="로그아웃"
						onclick="logout();"></span>
				</div>
			</div>
		</header>


		<article id="main_cont">