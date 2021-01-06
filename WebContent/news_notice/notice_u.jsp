<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.Notice_DAO,dto.Notice_DTO"%>
<%
	Notice_DAO dao  = new Notice_DAO();
	String notice_no = request.getParameter("t_noticeNo");
	int nHit 		 = dao.noticeHit(notice_no);
	Notice_DTO dto  = dao.getNoticeView(notice_no);
%> 
<!doctype html>
<html lang="ko">
	<title>박희준 HTML</title>
		<meta charset="utf-8">
		<link href="/css/common.css" rel="stylesheet">
		<link href="/css/noticewrite.css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="/js/jquery-3.3.1.min.js"></script>
	<body>
		<!-- sub page start -->
		<form name ="notice">
		<input type="hidden" name="t_work_gubun" value="update">
		<input type="hidden" name="t_notice_no" value="${t_dto.getNotice_no()}">
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> NOTICE-write</span></h2>	
			</div>
			<div class="notice-write">
					<fieldset>
						<table class="table">
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							
							<tr>
								<th><label for="title">제목</label></th>
								<td>
									<input type="text" name="t_title" value="${t_dto.getTitle()}" id="title" class="title">
								</td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td><textarea type="cont" name="t_content" id="cont" class="cont">${t_dto.getContents()}</textarea>
							</tr>
							<tr>
								<td colspan="2">
								<input type="button" onClick="javascript:save();" value="전송" class="btn">
								<input type="button" onClick="history.back();" value="목록" class="btn">
								</td>
							</tr>

							</table>
					</fieldset>
			</div>
		</form>			
		<!--  footer start  -->
		<script>
			function save(){
				var fm = document.notice;		
				if(fm.t_title.value == ""){
					alert("제목을 입력해주세요!");
					fm.t_title.focus();
					return;
				}
				if(fm.t_content.value == ""){
					alert("내용을 입력해주세요!");
					fm.t_content.focus();
					return;
				}
				
				fm.action = "/noticeUpdate";
				fm.method = "post";
				fm.submit();
			}
		</script>
	</body>
</html>