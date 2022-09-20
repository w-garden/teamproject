<%@ page  contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />


  <article>
   <div id="main_cont">
  	<div id="main_cont_color">
    <h1 class="item_title">내 정보관리</h1>
  	<div class="item_tab_box">
  		<div role="tablist" class="item_tab_inbox">
  			<div id="tab1"><a href="#business" class="tab-link">사업자 정보</a></div>
  			<div id="tab2"><a href="#additional" class="tab-link">부가 정보</a></div>
  			<div id="tab3"><a href="#preference" class="tab-link">선호 시공정보</a></div>
  			<div id="tab4"><a href="#representative" class="tab-link">담당자 정보</a></div>
  			<div id="tab5"><a href="#payment" class="tab-link">정산 정보</a></div>  			
  		</div>
  	</div>    
    <div class="all_information">
		<form method="post" action="#">
			<fieldset id="business">
				<legend>
					<b>사업자 정보</b>
				</legend>
				<div class="business-01">
					<div>
						<label><b>사업자등록번호</b></label><br />
						<div>
							<input type="text" size="5"> <input type="text" size="5">
							<input type="text" size="5">
						</div>
					</div>
					<br />
					<div>
						<label><b>상호</b></label><br />
						<div>
							<input type="text" size="20">
						</div>
					</div>
				</div>
				<br />
				<div class="business-03">
					<label><b>대표자 이름</b></label><br />
					<div>
						<input type="text" size="20">
					</div>
					<br />
				</div>
				<div class="business-04">
					<label><b>대표자 연락처</b></label><br />
					<div>
						<input type="text" size="20">
						<button type="button">변경</button>
					</div>
					<br />
				</div>
				<div class="business-05">
					<label><b>영업장 주소</b></label><br />
					<div>
						<input type="text" size="5" disabled="true"> <input
							type="text" size="10" disabled="true">
						<button type="button">변경</button>
					</div>
					<div>
						<input type="text" size="29">
					</div>
					<br />
				</div>
			</fieldset>
		</form>

		<form method="post" action="#">
			<fieldset id="additional">
				<legend>
					<b>부가 정보</b>
				</legend>
				<div class="additional-01">
					<label><b>전문가 한마디</b></label><br />
						<textarea class="one_word" autocomplete="off"
							placeholder="(EX. 따듯함이 느껴지는 원목과 화이트 컬러의 내추럴 스타일, 33평 아파트 인테리어입니다.)" rows="5"></textarea>
					<span class="text">0/2000</span>
				</div>
				<div class="additional-02">
					<label class="upload_image_title"><b>대표 인테리어 이미지</b></label><br />
					<div class="upload_image_size">(권장 이미지 사이즈 750 x 600)</div>
					<div tabindex="0" class="upload_image" >
						<label for="choosefile" class="upload_lbl">
							<img src="../images/upload_plus.png" width="40px" height="40px">
						</label>
						<input type="file" id="choosefile" name="file" accept="image/*">
					</div>
					<br />
				</div>
				<div class="additional-03">
					<label class="upload_image_title"><b>파트너스 로고 이미지</b></label><br />
					<div class="upload_image_size">(권장 이미지 사이즈 300 x 300)</div>
					<div tabindex="0" class="upload_image" >
						<label for="choosefile" class="upload_lbl">
							<img src="../images/upload_plus.png" width="40px" height="40px">
						</label>
						<input type="file" id="choosefile" name="file" accept="image/*">
					</div>
					<br />
				</div>
				<div class="additional-04">
					<label><b>제공 서비스</b></label><br />
					<div>제공하는 서비스를 모두 선택해 주세요.</div>

						<label for="check1" class="lbl-checkbox"> <input type="checkbox" id="check1">3D도면</label>
						<label for="check2" class="lbl-checkbox"> <input type="checkbox" id="check2">일반도면</label>
						<label for="check3" class="lbl-checkbox"> <input type="checkbox" id="check3">카드결제</label>
						<label for="check4" class="lbl-checkbox"> <input type="checkbox" id="check4">쇼룸</label>
						<label for="check5" class="lbl-checkbox"> <input type="checkbox" id="check5">정부지원사업</label></br>
						<label for="check7" class="lbl-checkbox-disabled"><input type="checkbox" id="check7" aria-hidden="false">두집예치제</label>
						<label class="deposit_label">예치금</label> <input type="text" id="deposit_money">
						<p id="red">* 두집예치제는 두집(****-****)으로 추가 문의주세요.</p>
					</div>
					


				<div class="additional-05">
					<label><b>홈페이지</b></label><br />
					<textarea class="homepage" autocomplete="off" placeholder="홈페이지를 입력하세요" rows="3"></textarea>
				</div>
				<br />
				<div class="additional-06">
					<label><b>업체사진(실내)</b></label><br />
					<div tabindex="0" class="upload_image2" >
						<label for="choosefile" class="upload_lbl2">
							<img src="../images/upload_plus.png" width="40px" height="40px">
						</label>
						<input type="file" id="choosefile" name="file" accept="image/*">
					</div>
					<br />
				</div>
				<div class="additional-07">
					<label><b>업체사진(실외)</b></label><br />
					<div tabindex="0" class="upload_image2" >
						<label for="choosefile" class="upload_lbl2">
							<img src="../images/upload_plus.png" width="40px" height="40px">
						</label>
						<input type="file" id="choosefile" name="file" accept="image/*">
					</div>
				</div>
			</fieldset>
		</form>

		<form method="post" action="#">
			<fieldset id="preference">
				<legend>
					<b>선호 시공정보</b>
				</legend>
				<div>
					<span><b>주거공간</b></span> <span>▼</span>
				</div>
				<br />

				<div class=''>
					<div>
						<b><span id="red">*</span></b><span> 건물 유형(최소 2개 이상)</span>
					</div>
					<article class="residence" style="border: 1px solid gray;">
							<label for="check8" class="lbl-checkbox"> <input type="checkbox" id="check8"></input> 전체</label><br />
						<div>
							<label for="check9" class="lbl-checkbox"> <input type="checkbox" id="check9">아파트</input></label>
							<label for="check10" class="lbl-checkbox"> <input type="checkbox" id="check10">빌라</input></label>
							<label for="check11" class="lbl-checkbox"> <input type="checkbox" id="check11">주택</input></label>
							<label for="check12" class="lbl-checkbox"> <input type="checkbox" id="check12">오피스텔(원룸)</input></label>
						</div>
						<br />
					</article>
					<br />

					<div>
						<b><span id="red">*</span></b><span> 가능한 공간</span>
					</div>
					<article class="residence" style="border: 1px solid gray;">
						<label for="check13" class="lbl-checkbox"> <input type="checkbox" id="check"></input> 전체
						</label><br />
						<h5 class="sigong">시공</h5>
						<div>
							<label for="check14" class="lbl-checkbox"> <input type="checkbox" id="check14">도배</input></label>
							<label for="check15" class="lbl-checkbox"> <input type="checkbox" id="check15">마루</input></label>
							<label for="check16" class="lbl-checkbox"> <input type="checkbox" id="check16">장판</input></label>
							<label for="check17" class="lbl-checkbox"> <input type="checkbox" id="check17">타일</input></label>
							<label for="check18" class="lbl-checkbox"> <input type="checkbox" id="check18">몰딩</input></label>
							<label for="check19" class="lbl-checkbox"> <input type="checkbox" id="check19">창호</input></label>
							<label for="check20" class="lbl-checkbox"> <input type="checkbox" id="check20">주방</input></label>
							<label for="check21" class="lbl-checkbox"> <input type="checkbox" id="check21">욕실</input></label>
							<label for="check22" class="lbl-checkbox"> <input type="checkbox" id="check22">도장</input></label>
							<label for="check23" class="lbl-checkbox"> <input type="checkbox" id="check23">필름</input></label>
							<label for="check24" class="lbl-checkbox"> <input type="checkbox" id="check24">목공</input></label>
							<label for="check25" class="lbl-checkbox"> <input type="checkbox" id="check25">문</input></label>
							<label for="check26" class="lbl-checkbox"> <input type="checkbox" id="check26">전기</input></label>
							<label for="check27" class="lbl-checkbox"> <input type="checkbox" id="check27">조명</input></label>
							<label for="check28" class="lbl-checkbox"> <input type="checkbox" id="check28">가구</input></label>
							<label for="check29" class="lbl-checkbox"> <input type="checkbox" id="check29">기타</input></label>
						</div>

						<h5 class="gicho">기초공사</h5>
						<div>
							<label for="check30" class="lbl-checkbox"> <input type="checkbox" id="check30">철거</input></label>
							<label for="check31" class="lbl-checkbox"> <input type="checkbox" id="check31">설비</input></label>
							<label for="check32" class="lbl-checkbox"> <input type="checkbox" id="check32">방수</input></label>
							<label for="check33" class="lbl-checkbox"> <input type="checkbox" id="check33">단열</input></label>
							<label for="check34" class="lbl-checkbox"> <input type="checkbox" id="check34">확장</input></label>
						</div>
						<br />
					</article>
					<br />
				</div>

				<div>
					<span><b>상업공간</b></span> <span>▼</span>
				</div>
				<br />

				<div class=''>
					<div>
						<b><span id="red">*</span></b><span> 건물 유형(최소 3개 이상)</span>
					</div>
					<article class="residence" style="border: 1px solid gray;">
							<label for="check35" class="lbl-checkbox"> <input type="checkbox" id="check35"></input> 전체</label><br />
						<div>
							<label for="check36" class="lbl-checkbox"> <input type="checkbox" id="check36">카페</input></label>
							<label for="check37" class="lbl-checkbox"> <input type="checkbox" id="check37">음식점</input></label>
							<label for="check38" class="lbl-checkbox"> <input type="checkbox" id="check38">주점</input></label>
							<label for="check39" class="lbl-checkbox"> <input type="checkbox" id="check39">매장/전시</input></label>
							<label for="check40" class="lbl-checkbox"> <input type="checkbox" id="check40">미용/뷰티</input></label>
							<label for="check41" class="lbl-checkbox"> <input type="checkbox" id="check41">교육/학원</input></label>
							<label for="check42" class="lbl-checkbox"> <input type="checkbox" id="check42">사무/작업공간</input></label>
							<label for="check43" class="lbl-checkbox"> <input type="checkbox" id="check43">체육</input></label>
							<label for="check44" class="lbl-checkbox"> <input type="checkbox" id="check44">오락/취미</input></label>
							<label for="check45" class="lbl-checkbox"> <input type="checkbox" id="check45">의료</input></label>
							<label for="check46" class="lbl-checkbox"> <input type="checkbox" id="check46">숙박</input></label>
							<label for="check47" class="lbl-checkbox"> <input type="checkbox" id="check47">세탁/수선</input></label>
							<label for="check48" class="lbl-checkbox"> <input type="checkbox" id="check48">반려동물</input></label>
							<label for="check49" class="lbl-checkbox"> <input type="checkbox" id="check49">종교시설</input></label>
							<label for="check50" class="lbl-checkbox"> <input type="checkbox" id="check50">기타</input></label>
						</div>
						<br />
					</article>
					<br />

					<div>
						<b><span id="red">*</span></b><span> 가능한 공간</span>
					</div>
					<article class="residence" style="border: 1px solid gray;">
						<label for="check51" class="lbl-checkbox"> <input type="checkbox" id="check51"></input> 전체
						</label><br />
						<h5 class="sigong">시공</h5>
						<div>
							<label for="check52" class="lbl-checkbox"> <input type="checkbox" id="check52">도배</input></label>
							<label for="check53" class="lbl-checkbox"> <input type="checkbox" id="check53">마루</input></label>
							<label for="check54" class="lbl-checkbox"> <input type="checkbox" id="check54">장판</input></label>
							<label for="check55" class="lbl-checkbox"> <input type="checkbox" id="check55">타일</input></label>
							<label for="check56" class="lbl-checkbox"> <input type="checkbox" id="check56">몰딩</input></label>
							<label for="check57" class="lbl-checkbox"> <input type="checkbox" id="check57">창호</input></label>
							<label for="check58" class="lbl-checkbox"> <input type="checkbox" id="check58">주방</input></label>
							<label for="check59" class="lbl-checkbox"> <input type="checkbox" id="check59">욕실</input></label>
							<label for="check60" class="lbl-checkbox"> <input type="checkbox" id="check60">도장</input></label>
							<label for="check61" class="lbl-checkbox"> <input type="checkbox" id="check61">필름</input></label>
							<label for="check62" class="lbl-checkbox"> <input type="checkbox" id="check62">목공</input></label>
							<label for="check63" class="lbl-checkbox"> <input type="checkbox" id="check63">문</input></label>
							<label for="check64" class="lbl-checkbox"> <input type="checkbox" id="check64">전기</input></label>
							<label for="check65" class="lbl-checkbox"> <input type="checkbox" id="check65">조명</input></label>
							<label for="check66" class="lbl-checkbox"> <input type="checkbox" id="check66">가구</input></label>
							<label for="check67" class="lbl-checkbox"> <input type="checkbox" id="check67">기타</input></label>
						</div>
						<br />

						<h5 class="gicho">기초공사</h5>
						<div>
							<label for="check68" class="lbl-checkbox"> <input type="checkbox" id="check68">철거</input></label>
							<label for="check69" class="lbl-checkbox"> <input type="checkbox" id="check69">설비</input></label>
							<label for="check70" class="lbl-checkbox"> <input type="checkbox" id="check70">방수</input></label>
							<label for="check71" class="lbl-checkbox"> <input type="checkbox" id="check71">단열</input></label>
							<label for="check72" class="lbl-checkbox"> <input type="checkbox" id="check72">확장</input></label>
							<label for="check73" class="lbl-checkbox"> <input type="checkbox" id="check73">간판</input></label>
						</div>
						<br /> <br />
					</article>
					<br />
				</div>

				<div>
					<label></label>
				</div>
			</fieldset>
		</form>

		<form method="post" action="#">
			<fieldset id="representative">
		 	  <legend><b>담당자 정보</b></legend>
				<div>
					<div>
						<label><b>주거 담당자</b></label>
						<div><input type="text" size="20" placeholder="담당자명"></div></br>
						<label><b>담당자 연락처</b></label>
						<div><input type="text" size="20" placeholder="담당자 연락처"></div>
						<label>
							<input type="checkbox" aria-hidden="false">
							<span class="">대표자 정보와 동일 <!----></span>
						</label>			
					</div></br>
					<div>
						<label><b>상업 담당자</b></label>
						<div><input type="text" size="20" placeholder="담당자명"></div></br>
						<label><b>담당자 연락처</b></label>
						<div><input type="text" size="20" placeholder="담당자 연락처"></div>		
						<label>
							<input type="checkbox" aria-hidden="false">
							<span class="">대표자 정보와 동일 <!----></span>
						</label>								
					</div>			
				</div>
			</fieldset>
		</form>
		
		<form method="post" action="#">
			<fieldset id="payment">
		 	  <legend><b>정산 정보</b></legend>
				<div>
					<label><b>세금계산서 이메일</b></label>
					<div><input type="text" size="20"></div></br>					
				</div>
				<div>
					<label><b>예치금</b></label>
					<div><input type="text" size="20" readonly="readonly" autocomplete="off"></div></br>								
				</div>
				<div>
					<label><b>입금계좌</b></label>
					<div><input type="text" size="20" placeholder="은행명"></div>
					<div><input type="text" size="20" placeholder="예금주"></div>	
					<div><input type="text" size="20" placeholder="계좌번호"></div>						
				</div></br>
				<div>
					<div>
						<label><b>통장 사본</b></label>
						<div>
								<input type="file" accept=".gif,.jpg,.png,.pdf" name="file">
						</div></br>
					</div>
					<div>
						<label><b>사업자 등록증 사본</b></label>
						<div>
								<input type="file" accept=".gif,.jpg,.png,.pdf" name="file">
						</div>
						<p id="red">* 입금계좌, 통장 사본, 사업자 등록증 사본은 1회만 입력 가능합니다. 
						수정희망 시 집닥담당자 (1600-3069) 에게 문의 해주세요.</p>
					</div>
				</div>
			</fieldset>
		</form>

     </div>
    </div>
   </div>
  </article>


<jsp:include page="../include/footer.jsp" />


		