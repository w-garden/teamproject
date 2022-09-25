<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
		<!--메인 content-->


		<article>

			<div>
				<form action="pw_change.jsp" method="post">
					<center>
						<h2>비밀번호 변경</h2>
							<table style="width: 50%; height:50px; border: 2px solid lightgray; border-collapse: collapse; text-align:center;
							 background-color:white;">
								<tr height ="40">
									<td width="150" align="center"><b>비밀번호 변경</b></td>
									<td width="250"><input type="password" name ="pPw" id="pPw" palceholder="기존 비밀번호를 입력해주세요"></td>
								</tr></br>
								<tr height ="40">
									<td width="150" align="center" ><b>새로운 비밀번호 입력</b></td>
									<td width="250">
										<input type="password" name ="password" placeholder="10자 이상(영문,숫자,특수문자 조합))"><br/><br/>
										<input type="password" name ="password" placeholder="비밀번호를 재입력해주세요">
									</td>
								</tr>
								<tr height ="40" >
									<td colspan="2" align="center"><input type="submit" value ="변경완료"/></td>		
								</tr>
							</table>
					</center>				
				</form>
			</div>

		</article>
<jsp:include page="../include/footer.jsp" />