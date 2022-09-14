<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
		<!--메인 content-->


		<article>

			<div id="main_cont">
				<section>
					<div>
						<form>
							<div>
								<h3><b>비밀번호 변경</b></h3>
								<div><input type="password" size="50%" placeholder="비밀번호를 입력해주세요." ></div>
								<h3><b>새로운 비밀번호 입력</b></h3>
								<div><input type="password" size="50%" placeholder="10자이상 16자(영문,숫자,특수문자조합)" ></div>
								<div><input type="password" size="50%" placeholder="비밀번호를 다시 입력해주세요." ></div>
								</br>
								<button type="button" style="width: 20%;">
									<span>변경완료</span>		
								</button>							
							</div>
						</form>
					</div>
				</section>
			</div>

		</article>
<jsp:include page="../include/footer.jsp" />