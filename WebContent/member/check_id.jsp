﻿<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page import="dao.exam_DAO"%>
<%
	exam_DAO dao = new exam_DAO();
	String id      = request.getParameter("id");
	String result  = dao.getCheckCount(id);
%>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>아이디 중복 검사</title>
</head>
<style>
	#contain {
		width: 360px;
		margin: auto;
		padding: 10px;
		border: 1px solid #bcbcbc;
	}
	#box1 {
		width:340px;
		height:150px;
		padding: 10px;
		border: 1px solid #bcbcbc;
	}	
	#t2 {
		width:320px;
		border:0px solid #CAC9D2;
	}	
	.t1{
		text-align:center;
		font-size:25px;	
		color:#67656f;
	}	
</style>
<script language="JavaScript">
	function confirm(){		
		opener.document.all.id_check_value.value = "<%=id%>";
		opener.document.all.pw_1.focus();
		window.close();
	}
	function confirm_cancel(){
		opener.document.all.id_check_value.value = "";
		opener.document.all.id.focus();
		window.close();
	}
</script>
<body>
	<div id="contain">
		<div id="box1">
		
			<TABLE id="t2" >
<%
				// 중복 앙~ 되어있을때
				if(result.equals("0")){					
				
%>			
				<TR align=center >
					<td height="90"><p class="t1">사용 가능한 아이디 입니다.</p></td>
				</TR>
				<TR align=center >
					<td>
						<a href="javascript:confirm()"><img src="/images/member_confirm.gif"></a>
						&nbsp;&nbsp;
						<a href="javascript:confirm_cancel()"><img src="/images/member_confirm_cancel.gif"></a>
					</td>
				</TR>
<%
				}else{
				// 중복 되어있을때
%>	
				<TR align=center >
					<td height="90"><p class="t1">등록된 아이디 입니다.<br>다른 아이디를 사용하세요!</p></td>
				</TR>
				<TR align=center >
					<td>
						<a href="javascript:confirm_cancel()"><img src="/images/member_confirm_2.gif"></a>
					</td>
				</TR>
<%
				} 
%>	
			</TABLE>	

		</div>
	</div>
</body>
</html>