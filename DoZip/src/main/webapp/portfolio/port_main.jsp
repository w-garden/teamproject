<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page = "../common/header.jsp"/>
<%-- 상단 공통부분 끝--%>
<link rel="stylesheet" type="text/css" href="/DoZip/css/portfolio.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="../js/portfolio.js" defer></script>


	<div class="clear"></div>
		
	<!-- 본문영역-->
	<!-- 프리미엄 기업 리스트-->
		<div class = "premium_wrap">
			<!-- <div class = "premium_top">
				<img id = "crown" src = "/DoZip/images/portfolio/detail/crown.png"/>
				<p class = "premium_title">프리미엄 업체 (광고)</p>
			</div> -->
			<div class = "premium_comp">
				<div class="outer">
				  <div class="inner-list">
				    <div class="inner">
				      <h2>업체 1</h2>
				    </div>
				    <div class="inner">
				      <h2>업체 2</h2>
				    </div>
				    <div class="inner">
				      <h2>업체 3</h2>
				    </div>
				    <div class = "inner">
				    	<h2>업체 4</h2>
				    </div>
				  </div>
				
				<!-- 버튼에 이벤트를 등록해 버튼을 삭제하면 안됨 (hidden)으로 처리 -->
				<div class="button-list">
				  <button class="button-left">← Left</button>
				  <button class="button-right">Right →</button>
				</div> 
					
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
				<input type = "text" id="searchTerm" onkeyup = "filter()" placeholder="업체명을 입력하세요">
				<button type = "submit" class = "search_Btn">
					<i class = "fa fa-search"></i>
				</button>
			</div>
		</div>
	</div>		
			
		<!-- 카드 리스트 -->
		<div class="construction_list">
			<div class="top_utile">
				<p class="top_title">포트폴리오</p> 
 			</div>
 			<!-- 반복문 시작 -->
			<div class="cards-list">
				<c:forEach var="i" begin="0" end="${fn:length(plist)}" step="1">
					<div class="card">
					  <div class="card_image"> 
					  	<img class = "ho" onclick = "location = 'port_detail.do';" src= "/DoZip/images/portfolio/port001.png" /> 
					  	<%-- onclick으로 클릭시 상세로 연결되게 --%>
					  </div>
					  <div class="card_title">
						   	<li class = "corp">${plist[i].pf_title}</li>
						   	<li class = "card_tag">${plist[i].pf_type} ${plist[i].pf_area}  ${plist[i].pf_cost}</li>
					  </div>
					</div>
				</c:forEach>
			</div>
 		</div>	
 		

<%--하단 공통부분 --%>	
<jsp:include page = "../common/footer.jsp"/>	