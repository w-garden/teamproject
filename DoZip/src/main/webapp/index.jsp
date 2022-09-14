<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>두꺼비집</title>
	<link rel="stylesheet" type="text/css" href="./css/main.css" />
	
	<script src="https://kit.fontawesome.com/3624917c4f.js" crossorigin="anonymous"></script>
	<script src ="./js/header.js" defer></script>
	<script>
	    function openLogin(){
	        window.open("./common/login.jsp", "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=550, left=0, top=0" );
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
					<a href="./index.jsp"> <img src="./images/logo.png"/>
					</a>
				</div>
				
				<ul class="menu">
					<li><a href="./apply/applicationSheet.jsp">견적신청</a></li>
					<li><a href="./portfolio/port_main.jsp">포트폴리오</a></li>
					<li><a href="./review/review_main.jsp">고객후기</a></li>
					<li><a href="./mypage/mypage_main.jsp">스토리</a></li>
				</ul>
			
				<ul class="icons">
					<li><a href="#none" onclick="openLogin();"><img src="./images/user.png" width="30" height="30" /></a></li>
					<li><a href="./counsel/counsel_main.jsp"><img src="./images/counsel.png" width="30" height="30" /></a></li>
				</ul>
				<a href="#" class="toggleBtn"><i class="fas fa-bars"></i></a> <!-- 반응형 메뉴 토글 버튼-->
			</nav>
		</header>
		<!-- header 영역 끝 -->

		<div class="clear"></div>

		<!-- 본문 -->
<div id="wrap">
		<div id="part">
			<div id="part1">
				<!-- <div id="slide_banner"> -->
					<a id="banner1" href="#">
						<img src="./images/banner_01.png">
					</a>
					<div id="btn_group">
						<button id="btn1" type="button" onclick=""><img src="./images/next1.png" width="20" height="20"/></button>
						<button id="btn2" type="button" onclick=""><img src="./images/next2.png" width="20" height="20"/></button>
					</div>					
				<!-- </div> -->				
			</div>
			
			<div class="clear"></div>
			
			<div id="part2">
				<ul class="quick_menu">
					<li><a class="icon01" href="#"><img src="./images/imsi_icon.png" width="40" height="40"/><span class="icon_title">1번이동</span></a></li>
					<li><a class="icon01" href="#"><img src="./images/imsi_icon.png" width="40" height="40"/><span class="icon_title">2번이동</span></a></li>
					<li><a class="icon01" href="#"><img src="./images/imsi_icon.png" width="40" height="40"/><span class="icon_title">3번이동</span></a></li>
					<li><a class="icon01" href="#"><img src="./images/imsi_icon.png" width="40" height="40"/><span class="icon_title">4번이동</span></a></li>
				</ul>
			</div>
			
			<div class="clear"></div>
			
			<div id="part3">
				<span class="part_title"><p>인테리어, 왜 두집에 맡겨야 할까요?</p></span>
				<span id="part3_img">
					<a id="part3_image" href="#"><img src="./images/part3.png" /></a>
				</span>
			</div>
			
			<div class="clear"></div>
			

			<span class="part_title">
				<a id="part4_link" href='./portfolio/port_main.jsp'><p>포트폴리오 보러가기 >></p></a>
			</span>
			
			<div id = "part4_area">
					
			<div class="cards-list">
	
				<div class="card 1">
					<div class="card_image">
						<img onclick="location = './portfolio/port_detail.jsp';"
							src="./images/portfolio/port001.png" />
						<%-- onclick으로 클릭시 상세로 연결되게 --%>
					</div>
					<div class="card_title">
						<li class="corp">★ 호철 디자인 ★</li>
						<li>#감성펍 #20평 1000만원대</li>
					</div>
				</div>
	
	
				<div class="card 2">
					<div class="card_image">
						<img onclick="location = './portfolio/port_detail.jsp';"
							src="./images/portfolio/port002.png" />
					</div>
					<div class="card_title">
						<li class="corp">★ 지혜 디자인 ★</li>
						<li>#모던 #22평 1000만원대</li>
					</div>
				</div>
	
				<div class="card 3">
					<div class="card_image">
						<img onclick="location = './portfolio/port_detail.jsp';"
							src="./images/portfolio/port003.png" />
					</div>
					<div class="card_title">
						<li class="corp">★ 민우 디자인 ★</li>
						<li>#모던 #80평 5000만원대</li>
					</div>
				</div>
	
				<div class="card 4">
					<div class="card_image">
						<img onclick="location = './portfolio/port_detail.jsp';"
							src="./images/portfolio/port004.png" />
					</div>
					<div class="card_title">
						<li class="corp">★ 수환 디자인 ★</li>
						<li>#럭셔리 #80평 5000만원대</li>
					</div>
				</div>
	
			</div>			
			
			</div>	
			</div>
			
			<div class="clear"></div>
			
			<div id="part5">
				<span class="part_title">
					<a id="part5_link" href='./review/review_main.jsp'><p>더 많은 후기 보러가기 >></p></a>
				</span>
				<div id="part5_area">
				
					<div class="part5_inner">
						<div><a class="part5_img" href="./review/review_detail.jsp">
							<img src=""/>
						</a></div>
						<div class="part5_title"><p>후기 제목</p></div>
						<div class="part5_cont">
							<p>싱크대 상판을 세라믹으로 하고 화장대의 상판과 수납장 하나의 상판도 세라믹으로 해서 효율적으로 세라믹을 사용할 수 있어서 만족합니다. 인조대리석보다 비싸지만 아주 만족합니다.</p>
						</div>
						<p></p>					
					</div>
					<div class="part5_inner">
						<div><a class="part5_img" href="./review/review_detail.jsp">
							<img src=""/>
						</a></div>
						<div class="part5_title"><p>후기 제목</p></div>
						<div class="part5_cont">
							<p>싱크대 상판을 세라믹으로 하고 화장대의 상판과 수납장 하나의 상판도 세라믹으로 해서 효율적으로 세라믹을 사용할 수 있어서 만족합니다. 인조대리석보다 비싸지만 아주 만족합니다.</p>
						</div>
						<p></p>					
					</div>
					<div class="part5_inner">
						<div><a class="part5_img" href="./review/review_detail.jsp">
							<img src=""/>
						</a></div>
						<div class="part5_title"><p>후기 제목</p></div>
						<div class="part5_cont">
							<p>싱크대 상판을 세라믹으로 하고 화장대의 상판과 수납장 하나의 상판도 세라믹으로 해서 효율적으로 세라믹을 사용할 수 있어서 만족합니다. 인조대리석보다 비싸지만 아주 만족합니다.</p>
						</div>
						<p></p>					
					</div>
				
				</div>
			</div>
		</div>
		
		<!-- footer영역 -->
		<div class="clear"></div>

		<footer id="footer">
			<hr/>
			<nav class="footer_nav">
				<ul class="footer_menu">
					<li><a href="#">회사소개</a></li>
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li><a href="/Partners/Join/signin.jsp">파트너스 페이지</a></li>
				</ul>
			</nav>

			<div id="footer_company">
					<div class="footer_company_call">
						<p class="footer_company_call_number">1600 - 0000</p>
						<p class="footer_company_call_info">
							<span>월 - 금: 09:00 - 18:00 (주말/공휴일 제외) | </span>
							<span class="_modis">팩스 : 02-1111-1111 | </span>
							<span class="_modis">고객문의: <a class="footer_mail" href="mailto:5140lovely@naver.com">5140lovely@naver.com</a> | </span> 
							<span class="_modis">제휴문의: <a class="footer_mail" href="mailto:5140lovely@naver.com">5140lovely@naver.com</a> | </span>
						</p>
					</div>
					
					<div class="footer_company_text" >
							<span>두집주식회사 대표이사 : 1조 | </span>
							<span>주소 : 서울 강남구 | </span> 
							<span>사업자등록번호 : 000-81-12345 | </span> 
							<span>통신판매번호 : 2022-서울강남-11111호</span>
					</div>
					<div class="footer_company_copyright">
						<p>두집주식회사는 통신판매중개자로서 건축 공사의 주 거래 당사자가 아니며, 시공전문가가 제공한 견적 및 공사
							시공 서비스에 대해 일체 책임을 지지 않습니다.</p>
						<p>copyright © DOZIP</p>
					</div>
			</div>
		</footer>
</body>
</html>