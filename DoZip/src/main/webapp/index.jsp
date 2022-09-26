<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>두꺼비집</title>
	<link rel="stylesheet" type="text/css" href="/DoZip/css/main.css" />
	
	<script src="https://kit.fontawesome.com/3624917c4f.js" crossorigin="anonymous"></script>
	<script src ="./js/header.js" defer></script>
	<script>
	    function openLogin(){
	        window.open("member_login.do", "_blank", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=550, height=750, left=0, top=0" );
	    }/* width=400, height=550 */
	</script>
</head>
<body>
		<!-- header 영역 -->
		<header id="header">
			<!-- 상단 메뉴 바 -->
			<nav class="header_nav">
				<!-- 로고 -->
				<div class="logo">
					<a href="home.do"> <img src="./images/main_logo.png"/>
					</a>
				</div>
				
				<ul class="menu">
					<li><a href="estimate_apply.do">견적신청</a></li>
					<li><a href="portfolio.do">포트폴리오</a></li>
					<li><a href="review.do">고객후기</a></li>
					<li><a href="#">스토리</a></li>
					<li><a href="partners.do">파트너스</a></li>
				</ul>
			
				<ul class="icons">
				<c:if test="${empty id}"> <!-- 로그인 전 -->
					<li><a href="#none" onclick="openLogin();"><img src="./images/user.png" width="30" height="30" /></a></li>
				</c:if>
				<c:if test="${!empty id}"> <!-- 로그인 후 -->
					<li><a href="mypage_go.do"><img src="./images/user.png" width="30" height="30" /></a></li>
				</c:if>
					<li><a href="counsel.do"><img src="./images/counsel.png" width="30" height="30" /></a></li>
				</ul>
				<a href="#" class="toggleBtn"><i class="fas fa-bars"></i></a> <!-- 반응형 메뉴 토글 버튼-->
			</nav>
		</header>
		<!-- header 영역 끝 -->

		<div class="clear"></div>

		<!-- 본문 -->

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
				<div class="part2_left">
					<p id="part2_title">주변의 인테리어 업체를 찾아보세요</p>
					<p id="part2_info">검색하고자 하는 위치를 입력하세요. (예. 강남구 역삼동, 서초구 반포동)</p>
					<p id="search_wrap">
						<input type="text"  name="search_map" id="search_map"/><button type="submit" id="search_map_btn">검색</button>
					</p>
				</div>
				<div id="map"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3d8bfa3cbe8aabf2dd47e365262af246"></script>
				<script>
					var container = document.getElementById('map');
					var options = {
						center: new kakao.maps.LatLng(33.450701, 126.570667),
						level: 3
					};			
					var map = new kakao.maps.Map(container, options);
				</script>
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
				<a id="part4_link" href="portfolio.do"><p>포트폴리오 보러가기 >></p></a>
			</span>
			
			<div id = "part4_area">
					
			<div class="cards-list">
				<c:if test= "${!empty plist}">
					<c:forEach var = "i" begin = "0" end = "${fn:length(plist)-1}" step = "1">
						<div class="card">
						  <div class="card_image"> 
						  	<img class = "ho" onclick = "location.href='port_detail.do?pf_no=${plist[i].pf_no}';" src= '${plist[i].pf_photo1}'/> 
						  	<%-- 클릭시 글번호를 넣어 상세로 연결 --%>
						  </div>
					  <div class="card_title">
						   	<li class = "corp">${plist[i].pf_title}</li>
						   	<li class = "card_tag">${plist[i].pf_type} ${plist[i].pf_area} ${plist[i].pf_cost}</li>
					  </div>
					</div>
					</c:forEach>
				</c:if>
				
				<c:if test = "${empty plist}">
					<div id = "none_pf">포트폴리오 목록이 없습니다</div>
				</c:if>
			</div>			
			
			</div>	
			
			<div class="clear"></div>
			
			<div id="part5">
				<span class="part_title">
					<a id="part5_link" href="review.do"><p>더 많은 후기 보러가기 >></p></a>
				</span>
				<div id="part5_area">
				
					<div class="part5_inner">
						<div><a class="part5_img" href="review_detail.do">
							<img src=""/>
						</a></div>
						<div class="part5_title"><p>후기 제목</p></div>
						<div class="part5_cont">
							<p>싱크대 상판을 세라믹으로 하고 화장대의 상판과 수납장 하나의 상판도 세라믹으로 해서 효율적으로 세라믹을 사용할 수 있어서 만족합니다. 인조대리석보다 비싸지만 아주 만족합니다.</p>
						</div>
						<p></p>					
					</div>
					<div class="part5_inner">
						<div><a class="part5_img" href="review_detail.do">
							<img src=""/>
						</a></div>
						<div class="part5_title"><p>후기 제목</p></div>
						<div class="part5_cont">
							<p>싱크대 상판을 세라믹으로 하고 화장대의 상판과 수납장 하나의 상판도 세라믹으로 해서 효율적으로 세라믹을 사용할 수 있어서 만족합니다. 인조대리석보다 비싸지만 아주 만족합니다.</p>
						</div>
						<p></p>					
					</div>
					<div class="part5_inner">
						<div><a class="part5_img" href="review_detail.do">
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
			<nav class="footer_nav">
				<ul class="footer_menu">
					<li><a href="#">회사소개</a></li>
					<li><a href="#">개인정보처리방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li><a href="partners.do">파트너스 페이지</a></li>
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