<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.News_DAO,dto.News_DTO"%>
<%
	News_DAO dao  	= new News_DAO();
	String news_no 	= request.getParameter("t_news_no");
	int nHit 		= dao.newsHit(news_no);
	News_DTO dto	= dao.getNewsView(news_no);
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
		<form name ="news">
		<input type="hidden" name="t_work_gubun" value="update">
		<input type="hidden" name="t_news_no" value="${t_dto.getNews_no()}">
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> News-update</span></h2>	
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
								<th><label for="file">이미지 첨부</label></th>
								<td><input type="file" name="fileName_a" class="file" id="file">&nbsp;&nbsp;&nbsp;${t_dto.getImages()}&nbsp;&nbsp;<input type="checkbox" name="file_delete"></td>
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
				var fm = document.news;		
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
				fm.action = "/newsUpdateForm";
				fm.method = "post";
				fm.submit();
			}
		</script>
	</body>
</html>