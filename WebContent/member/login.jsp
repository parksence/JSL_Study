<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<!DOCTYPE html>
	<div class="sub_title">
	</div>

	<div class="bg_admin">
		<div class="container">
			<div class="grap">
				<form name="member" method="post" action="/LoginCheck">
					<fieldset>
						<legend class="sr-only">로그인</legend>

						<label for="id" class="sr-only">아이디입력</label>
						<input type="text" name="t_id" placeholder="아이디를 입력하세요" id="id">

						<label for="pw" class="sr-only">패스워드입력</label>
						<input type="password" name="t_pw" placeholder="패스워드를 입력하세요" id="pw">

						<a href="javascript:void(0)" onClick="member_check()" class="btn_admin">로그인</a>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<script>
		function member_check(){
			if(member.t_id.value==""){
				alert("아이디입력");
				member.t_id.focus();
				return false;
			}
			if(member.t_pw.value==""){
				alert("패스워드입력");
				member.t_pw.focus();
				return false;
			}
			member.submit();
		}
	</script>
	
	<script>
		$(function(){
			$(".location .dropdown>a").on("click",function(e){
				e.preventDefault();
				if($(this).next().is(":visible")){
					$(".location .dropdown > a").next().hide();
				}else{
					$(".location .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>

<%@ include file="/footer.jsp" %>
</body>
</html>
