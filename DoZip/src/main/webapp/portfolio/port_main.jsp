<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page = "../common/header.jsp"/>
<%-- 상단 공통부분 끝--%>
<link rel="stylesheet" type="text/css" href="../css/portfolio.css" />
	<div class="clear"></div>
		
	<!-- 본문영역-->
	<hr>
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
		<!-- 프리미엄 기업 리스트-->
		<div class = "premium_wrap">
			<img id = "crown" src = "../images/portfolio/detail/crown.png"/>
			<p class = "premium_title">프리미엄 업체 (광고)</p>
			<div class = "premium_comp">
					<%! int k = 0;%>
					<% for(int k = 1; k <3; k++){ %>
					<div class="premium_cards_wrap">
						<div class="card 1">
						  <div class="card_image"> 
						  	<img onclick = "location = './port_detail.jsp';" src= "../images/portfolio/port001.png" /> 
						  	<%-- onclick으로 클릭시 상세로 연결되게 --%>
						  </div>
						  <div class="card_title">
							   	<li class = "corp">★ 호철 디자인 ★</li>
							   	<li>#감성펍 #20평 1000만원대 </li>
						  </div> 
						</div>
				
					  <div class="card 2">
					  <div class="card_image">
					    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port002.png" />
					    </div>
					  <div class="card_title">
					    <li class = "corp">★ 지혜 디자인 ★</li>
					    <li>#모던 #22평 1000만원대</li>
					  </div>
					</div>
				
					<div class="card 3">
					  <div class="card_image">
					    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port003.png" />
					  </div>
					  <div class="card_title ">
					    <li class = "corp">★ 민우 디자인 ★</li>
					    <li>#모던 #80평 5000만원대</li>
					  </div>
					</div>
				  
					  <div class="card 4">
					  <div class="card_image">
					    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port004.png" />
					    </div>
					  <div class="card_title">
					    <li class = "corp">★ 수환 디자인 ★</li>
					    <li>#럭셔리 #80평 5000만원대</li>
					  </div>
					  </div>
					  
					  <div class="card 5">
					  <div class="card_image">
					    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port005.png" />
					    </div>
					  <div class="card_title">
					    <li class = "corp">★ 동민 디자인 ★</li>
					    <li>#내추럴 #50평 2000만원대</li>
					  </div>
					  </div>
					  
				</div>
				<%} %>
			</div>
		</div>
		<br>		
		<!-- 카드 리스트 -->
		<div class="construction_list">
			<div class="top_utile">
				<p class="top_title">총 1234 개</p> 
 			</div>
 		<%! int i=0; %>
		<% for(i=1; i<5; i++) { %>
			<div class="cards-list">
			<div class="card 1">
			  <div class="card_image"> 
			  	<img onclick = "location = './port_detail.jsp';" src= "../images/portfolio/port001.png" /> 
			  	<%-- onclick으로 클릭시 상세로 연결되게 --%>
			  </div>
			  <div class="card_title">
				   	<li class = "corp">★ 호철 디자인 ★</li>
				   	<li>#감성펍 #20평 1000만원대 </li>
			  </div> 
			</div>
			
			  <div class="card 2">
			  <div class="card_image">
			    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port002.png" />
			    </div>
			  <div class="card_title">
			    <li class = "corp">★ 지혜 디자인 ★</li>
			    <li>#모던 #22평 1000만원대</li>
			  </div>
			</div>
			
			<div class="card 3">
			  <div class="card_image">
			    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port003.png" />
			  </div>
			  <div class="card_title ">
			    <li class = "corp">★ 민우 디자인 ★</li>
			    <li>#모던 #80평 5000만원대</li>
			  </div>
			</div>
			  
			  <div class="card 4">
			  <div class="card_image">
			    <img onclick = "location = './port_detail.jsp';" src="../images/portfolio/port004.png" />
			    </div>
			  <div class="card_title">
			    <li class = "corp">★ 수환 디자인 ★</li>
			    <li>#럭셔리 #80평 5000만원대</li>
			  </div>
			  </div>
			
			</div>
		<% } %>
 		</div>	
 		

<%--하단 공통부분 --%>	
<jsp:include page = "../common/footer.jsp"/>	