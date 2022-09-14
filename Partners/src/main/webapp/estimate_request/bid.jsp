<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<!--메인 content-->


<article>

	<div id="main_cont">
		<div class="request_page">
			<div class="request_spot">
				<h1 class="item_title">입찰의뢰</h1>
					<form action="." method="post">
						<div class="search_box">
					    <input class="search-txt" type="text" placeholder="검색어를 입력해 주세요">
					    <button class="search-btn" type="submit">
					    	<img src="../images/search.png" width="20px" height="20px">
					    </button>
						</div>
					</form>
					<div class="my_bid_icon">
						<a href="./my_bid.jsp;"
							class="to_my_bid" target="_blank"><img src="../images/bid_list.png" width="55px" height="55px"></a>
					</div>
			</div>
			<div class="request_list_container">
				<div class="request_list">
					<div class="request_list_top">
						<input type="checkbox" id="filter"> 
							<label for="filter" class="filter">완료 의뢰 건 제외</label> 
						<div class="request_list_top_right">
							<select class="fd_search_filter" id="pr_order" data-self="pr_order" data-type="simple">
								<option value="recent">최신 등록 순</option>
								<option value="due_date">마감 임박 순</option>
								<option value="request_budget">예산 규모 순</option>
							</select>
						</div>
					</div>
					<div class="request_list_card">
						<div class="request_list_item01">
							<p class="request_day">
								모집중 D-<span>2</span>
							</p>
							<p class="label_badge">
								<span class="label_val1">사무실</span>
								<span class="label_val2">도배/바닥/욕실 공사</span>
							</p>
							<p class="request_title">
								<a href="/projectView/PR-3A90TFtPUUs?tab=default&amp;&amp;p=" >목동 사무실 원상복구 견적 문의</a>
							</p>
							<div class="request_desc_div">
								<p class="request_desc">
								1. 이사예정이 7/19(화)이라 18일까지는 완료가 되어야 합니다.(기존3층에 임대사무실 사용 후 9층 매매완료하여 이사) 이사예정인 사무실은 15일 오전중에 공실이 됩니다.</br>
								2. 바닥재은 어두운계열로, 벽면은 합판이 덧대어져있는것 같은데 페이트 혹은 들뜨지않게 마감처리하여 깔끔하게 될 수 있도록 페인트 혹은 벽지 두가지 생각하고 있습니다.
								3. 전등갓이 불량하여 변경이 이뤄져야합니다.
								4. 외부시트지 디자인작업이 필요합니다.
								</p>
							</div>
								<ul class="request_info">
									<li class="info">
										<p class="request_info_tit">예상 계약금액</p>
										<p class="request_info_val">
											<span><b>80,000,000</b></span> 원
										</p>
									</li>
									<li class="info">
										<p class="request_info_tit">모집 마감일</p>
										<p class="request_info_val">
											<span><b>2022.08.31</b></span>
										</p>
									</li>
									<li class="info">
										<p class="request_info_tit">견적 마감일</p>
										<p class="request_info_val">
											<span><b>2022.09.01</b></span>
										</p>
									</li>
									<li class="info">
										<p class="request_info_tit">참여 파트너 수</p>
										<p class="request_info_val">
											<span><b>9</b></span>
										</p>
									</li>
								</ul>
						</div>
						<div class="request_list_item02">
							<ul class="company_profile">
								<li class="info2">
									<p class="key">기업형태</p>
									<p class="val"><b>(공공)기관</b></p></li>
								<li class="info2">
									<p class="key">지역</p>
									<p class="val"><b>서울 용산구</b></p></li>
								<li class="info2">
									<p class="key">업종</p>
									<p class="val"><b>그 외 기타 협회 및 단체</b></p></li>
							</ul>
							<div class="bid_detail">
								<a href="./bid_detail.jsp;" class="btn-d-view" >자세히 보기</a>
							</div>
						</div>						
					</div></br>
				</div>
			</div>
			<div class="bottom-btn-wrap">
				<button type="button" class="more_button"><img src="../images/more_plus.png"></br><span>더보기</span></button>
			</div>
		</div>
	</div>
</article>
<jsp:include page="../include/footer.jsp" />


