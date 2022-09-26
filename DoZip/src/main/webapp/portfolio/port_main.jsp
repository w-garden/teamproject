<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page = "../common/header.jsp"/>
<%-- 상단 공통부분 끝--%>
<link rel="stylesheet" type="text/css" href="/DoZip/css/portfolio.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="./js/portfolio.js"defer></script>


	<div class="clear"></div>
		
	<!-- 본문영역-->
	
	<!-- 프리미엄 기업 리스트-->
		<div class = "premium_wrap">
			<div class = "premium_comp">
				
				<%--배너 시작 --%>
				<div id="wrapper">
			      <div id="slider-wrap">
			          <ul id="slider">
			             <li>
			                <div>
			                    <h3>호철 디자인</h3>
			                    <span>Sub-title #1</span>
			                </div>                
							<img src="/DoZip/images/portfolio/banner/HC_banner.png">
			             </li>
			             
			             <li>
			                <div>
			                    <h3>Slide #1</h3>
			                    <span>Sub-title #2</span>
			                </div>
							<img src="https://fakeimg.pl/350x200/D27328/000?text=22222">
			             </li>
			             
			             <li>
			                <div>
			                    <h3>Slide #3</h3>
			                    <span>Sub-title #3</span>
			                </div>
							<img src="https://fakeimg.pl/350x200/FF607F/000?text=33333">
			             </li>
			             
			             <li>
			                <div>
			                    <h3>Slide #4</h3>
			                    <span>Sub-title #4</span>
			                </div>
							<img src="https://fakeimg.pl/350x200/0A6E0A/000?text=44444">
			             </li>
			             
			             <li>
			                <div>
			                    <h3>Slide #5</h3>
			                    <span>Sub-title #5</span>
			                </div>
							<img src="https://fakeimg.pl/350x200/0064CD/000?text=55555">
			             </li>
			             
			             
			          </ul>
			          
			           <!--controls-->
			          <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
			          <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
			          <div id="counter"></div>
			          
			          <div id="pagination-wrap">
			            <ul>
			            </ul>
			          </div>
			          <!--controls-->  
                 
      			</div>
   			</div>
   			<%-- 배너 종료 --%>
		</div>
	</div>
		<br>	
	<!-- 드롭다운 버튼 -->
	<div class = "port_wrap">
		<div class = "dropdown">
			<select name="d1" class="dd_group">
				<option selected>주거유형</option>
				<option value="아파트">아파트</option>
				<option value="빌라">빌라</option>
				<option value="주택">주택</option>
				<option value="오피스텔">오피스텔</option>
			</select>
			<select name="d2" class="dd_group">
				<option selected>상업유형</option>
				<option value="카페/식당">카페/식당</option>
				<option value="상가/매장">상가/매장</option>
				<option value="학원/교육">학원/교육</option>
				<option value="사무실">사무실</option>
				<option value="숙박/병원">숙박/병원</option>
				<option value = "간판">간판</option>
				<option value = "기타">기타</option>
			</select>
			<select name="d3" class="dd_group">
				<option selected>스타일</option>
				<option value="모던">모던</option>
				<option value="심플/미니멀">심플/미니멀</option>
				<option value="내추럴">내추럴</option>
				<option value="빈티지">빈티지</option>
				<option value="럭셔리">럭셔리</option>
			</select>
			<select name="d4" class="dd_group">
				<option selected>비용</option>
				<option value="1000만원 이하">1000만원 이하</option>
				<option value="1000만원대">1000만원대</option>
				<option value="2000만원대">2000만원대</option>
				<option value="3000만원대">3000만원대</option>
				<option value="4000만원대">4000만원대</option>
				<option value="5000만원대">5000만원대</option>
				<option value="6000만원 이상">6000만원 이상</option>
			</select>
			<select name="d5" class="dd_group">
				<option selected>평수</option>
				<option value="10평대">10평대</option>
				<option value="20평대">20평대</option>
				<option value="30평대">30평대</option>
				<option value="50평대">50평대</option>
				<option value="60평대 이상">60평대 이상</option>
			</select>
		</div>	
		<!-- 드롭다운 끝 -->

		<!-- 검색창 -->
		<div class = "search_wrap">
			<div class = "search">
				<input type = "text" name = "keyword" id="keyword" onkeyup = "filter()" placeholder="업체명을 입력하세요">
				<button type = "submit" class = "search_Btn">
					<i class = "fas fa-search"></i>
				</button>
			</div>
		</div>
	</div>		
			
		<!-- 카드 리스트 -->
		<div class="construction_list">
			<div class="top_utile">
				<p class="top_title">포트폴리오</p> 
 			</div>
 			
 			<!-- 검색할 시 반환 -->
 			<c:if test = "${!empty cp}">
				<div class="cards-list">
				
				<c:forEach var="i" begin="0" end="${fn:length(cp)-1}" step="1">
					<div class="card">
					  <div class="card_image"> 
					  	<img class = "ho" onclick = "location.href='port_detail.do?pf_no=${cp[i].pf_no}';" src= '${cp[i].pf_photo1}'/> 
					  	<%-- onclick으로 클릭시 글번호를 넣어 상세로 연결되게 --%>
					  </div>
					  <div class="card_title">
						   	<li class = "corp">${cp[i].pf_title}</li>
						   	<li class = "card_tag">${cp[i].pf_type} ${cp[i].pf_area} ${cp[i].pf_cost}</li>
					  </div>
					</div>
				</c:forEach>
			</div>
			</c:if>
 			<!-- 반복문 시작 -->
			<div class="cards-list">
				<c:if test = "${!empty plist}">
				<c:forEach var="i" begin="0" end="${fn:length(plist)-1}" step="1">
					<div class="card">
					  <div class="card_image"> 
					  	<img class = "ho" onclick = "location.href='port_detail.do?pf_no=${plist[i].pf_no}';" src= '${plist[i].pf_photo1}'/> 
					  	<%-- onclick으로 클릭시 글번호를 넣어 상세로 연결되게 --%>
					  </div>
					  <div class="card_title">
						   	<li class = "corp">${plist[i].pf_title}</li>
						   	<li class = "card_tag">${plist[i].pf_type} ${plist[i].pf_area} ${plist[i].pf_cost}</li>
					  </div>
					</div>
				</c:forEach>
			</div>
			</c:if>
			<c:if test = "${empty plist}">
				<div id = "none_pf">포트폴리오 목록이 없습니다</div>
			</c:if>
			<c:if test = "${empty cp}">
				<div id = "none_search">해당 업체 포트폴리오 목록이 없습니다</div>
				<button type = "button" class="back_p">돌아가기</button>
			</c:if>
			
 		</div>
 		<br>
 		<br>	
 		

<%--하단 공통부분 --%>	
<jsp:include page = "../common/footer.jsp"/>	