<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
		<!--메인 content-->


		<div id="main_cont">
			<div class="my_bid_list">
					<h1>내 입찰목록</h1>
			<div class="my_bid_title1"><h3 id="bid_fin">입찰 완료</h3></div>
			<table border="1" style="width: 90%; border: 2px solid #0064CD; border-collapse: collapse; text-align:center; margin-top:10px;">
				<tr class="my_bid_label">
					<th>입찰 내용</th> <th>예상 계약금액</th> <th>모집 마감일</th> <th>견적 마감일</th> <th>세부정보</th> <th>입찰결과</th>
				</tr>
				<tr class="my_bid_cont">
					<td>목동 사무실 원상복구 견적 문의</td> <td>5,000,000원</td> <td>2022.07.13</td>  <td>2022.07.25</td> 
					<td><div class="bid_detail"><a href="./bid_detail.jsp;" class="my_bid_btn-d-view" >자세히 보기</a></div></td>
					<td class="bid_result"><span class="success1">성공</span></td>
				</tr>
				<tr class="my_bid_cont">
					<td>목동 사무실 원상복구 견적 문의</td> <td>5,000,000원</td> <td>2022.07.13</td>  <td>2022.07.25</td>
					<td><div class="bid_detail"><a href="./bid_detail.jsp;" class="my_bid_btn-d-view" >자세히 보기</a></div></td>
					<td class="bid_result"><span class="fail1">실패</span></td>
				</tr>
			</table>
			<div class="my_bid_title2"><h3 id="bid_proc">입찰 진행중</h3></div>
			<table border="1" style="width: 90%; border: 2px solid #0064CD; border-collapse: collapse; text-align:center; margin-top:10px;">
				<tr class="my_bid_label">
					<th>입찰 내용</th> <th>예상 계약금액</th> <th>모집 마감일</th> <th>견적 마감일</th> <th>세부정보</th> <th>입찰취소</th>
				</tr>
				<tr class="my_bid_cont">
					<td>목동 사무실 원상복구 견적 문의</td> <td>5,000,000원</td> <td>2022.07.13</td>  <td>2022.07.25</td> 
					<td><div class="bid_detail"><a href="./bid_detail.jsp;" class="my_bid_btn-d-view" >자세히 보기</a></div></td>
					<td><a href="#" class="btn-cancel" onclick="confirm('입찰을 취소하시겠습니까?')" >취소</a></td>
				</tr>
		
			</table>
			</div>

		</div>
		
<jsp:include page="../include/footer.jsp" />
