<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page = "../common/header.jsp"/>
<%-- 상단 공통부분 끝--%>
<link rel="stylesheet" type="text/css" href="/DoZip/css/port_detail.css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<div class="clear"></div>
		
	<!-- 본문영역 -->
	<div class = "detail_wrap">
	<hr>
		<div class = "detail_1">
			<div class = "detail_img">
				<img id = "main_img" src = "../images/portfolio/port001.png"/>
				<br><br>
				<div class = "d_main">
					<h2 id = "d_title">빔 프로젝트로 만들어낸 공간 인테리어</h2>
					<br>
					<pre id = "d_location"><img id = "d_loca" src = "../images/portfolio/location_icon.png"/>서울 용산구 이태원동 맥주펍</pre>
					<br>
					<div class = "d_tags">
						<button type = "button" id = "type">모던</button>
						<button type = "button" id = "cate" >카페/식당</button>
						<button type = "button" id = "amount">20평</button>
						<button type = "button" id = "price">1000만원대</button>
						<button type = "button" id = "time">공사기간 2주</button>
					</div>
					<div class = "d_check">
						<div class = "scrap">
							<h3>스크랩하기</h3>
							<label class="switch">
		  						<input type="checkbox">
		  						<span class="slider round"></span>
							</label>
							<p id = "scrap_no">Scrap하기</p><p id = "scrap_ok" style="display:none;">Scrap완료</p>
							<script>
								var check = $("input[type='checkbox']");
								check.click(function(){
										$("p").toggle();
								});
							</script>
						</div>
						<div class = "direct_contact">
							<button type = "button" id = "contact" onclick = "openContact()">업체컨택하기</button>
						</div>
						<%-- 업체와 직접 컨택 --%>
						<script>
							function openContact(){
								window.open("dir_contact.jsp","_blank",
										"toolbar = no, menubar = no, scrollbars=no, resizable=no, width=500, height=750, left=0, top=0");
							}
						</script>
					</div>
				</div>
			</div>
		</div>
		<br><br>
		<div class = "detail_2">
			<div class = "detail_cont1">
				<pre id = "start_cont"> 
				빔 프로젝트가 비추는 영상에 따라 인테리어가 달라지는 이색적인 맥주 펍으로
				화이트톤으로 도장한 실내에 맞춰 간판 역시 화이트로 제작했습니다.
				화이트톤으로 마감된 곳은 테이블로, 색상이 들어간 공간은 카운터 및 주방으로 활용 됩니다~
				카운터는 전체적인 내부 스타일에 맞춰 빈티지한 목재로 제작했고, 주방은 외부에서
				보이지 않도록 커튼으로 시선을 차단했습니다 :)
				</pre>
			</div>
			<div class = "detail_imgs">
				<img id = "d_imgs" src = "../images/portfolio/detail/d001.png"/>
				<img id = "d_imgs" src = "../images/portfolio/detail/d002.png"/>
				<img id = "d_imgs" src = "../images/portfolio/detail/d003.png"/>
				<img id = "d_imgs" src = "../images/portfolio/detail/d004.png"/>
				<img id = "d_imgs" src = "../images/portfolio/detail/d005.png"/>
				<img id = "d_imgs" src = "../images/portfolio/detail/d006.png"/>
			</div>
			<div class = "detail_cont2">
				<pre id = "end_cont">
				천장은 별다른 마감 없이 화이트톤 마감을, 바닥은 에폭시로 처리해 빈티지하게 연출!
				배치된 집기류 역시 목재 테이블로 단순하게 디자인 했으며 
				화이트로 마감된 벽이 보여지는 영상에 따라 수시로 변화 해 최대한의 효과를 연출합니다 :)
				</pre>
			</div>
		</div>
	</div>
	<br><br>
	<%-- 업체 명함 부분 --%>
	<div class = "comp_card">
		<div class=	"comp_img">
			<img id = "comp_logo" src = "../images/portfolio/detail/compHC.png"/>
		</div>
		<div class = "comp_name">
			<h2>호철 디자인</h2>
			<pre id = "comp_loca">경기 수원시 영통구 광교중앙로 170</pre>
		</div>	
		<div class = "comp_detail">
			<button type = "button" id = "comp" onclick = "location = 'comp_detail.do'">더보러가기</button>
		</div>
	</div>
	<br><br>
	

<%--하단 공통부분 --%>	
<jsp:include page = "../common/footer.jsp"/>	