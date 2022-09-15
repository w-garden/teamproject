<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>두꺼비집</title>
	<link rel="stylesheet" type="text/css" href="/DoZip/css/main.css" />
	<link rel="stylesheet" type="text/css" href="/DoZip/css/review.css" />
	<link rel="stylesheet" type="text/css" href="/DoZip/css/counsel.css" />
	<link rel="stylesheet" type="text/css" href="/DoZip/css/mypage.css" />
	
	<script src ="/DoZip/js/header.js" defer></script>
    <script src="/DoZip/js/jquery.js"></script>
    <script src="/DoZip/js/mypage.js"></script>
  
	<script>
	    function openLogin(){
	        window.open("../common/login.jsp", "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=550, left=0, top=0" );
	    }
	</script>
</head>
<body>
		<!-- header 영역 -->
		<header id="header">
			<!-- 상단 메뉴 바 -->
			<nav class="header_nav">
				<!-- 로고 -->
				<div class="logo">
					<a href="../index.jsp"> <img src="../images/logo.png"/>
					</a>
				</div>
				
				<ul class="menu">
					<li><a href="../apply/applicationSheet.jsp">견적신청</a></li>
					<li><a href="../portfolio/port_main.jsp">포트폴리오</a></li>
					<li><a href="../review/review_main.jsp">고객후기</a></li>
					<li><a href="../mypage/mypage_main.jsp">스토리</a></li>
				</ul>
			
				<ul class="icons">
					<li><a href="#none" onclick="openLogin();"><img src="../images/user.png" width="30" height="30" /></a></li>
					<li><a href="../counsel/counsel_main.jsp"><img src="../images/counsel.png" width="30" height="30" /></a></li>
				</ul>
				<a href="#" class="toggleBtn"><i class="fas fa-bars"></i></a> <!-- 반응형 메뉴 토글 버튼-->
			</nav>
		</header>
		<!-- header 영역 끝 -->

		<div class="clear"></div>

<div id="wrap"> <!-- #wrap 시작 -->