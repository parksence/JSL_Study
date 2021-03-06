<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
	<title>project1</title>
		<meta charset="utf-8">
		<link href="/css/common.css" rel="stylesheet">
		<link href="/css/noticewrite.css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="/js/jquery-3.3.1.min.js"></script>
	<body>
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> NOTICE-write</span></h2>	
			</div>
			
			<div class="notice-write">
			<form name="notice">
					<fieldset>
						<table class="table">
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							
							<tr>
								<th><label for="title">제목</label></th>
								<td><input type="text" name="t_title" id="title" class="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td><textarea type="cont" name="t_content" id="cont" class="cont" placeholder="내용을 입력해주세요"></textarea>
							</tr>
							<tr>
								<td colspan="2">
								<input type="button" value="입력" onClick="insert()" value="전송" class="btn">
								<input type="button" onClick="history.back();" value="목록" class="btn">
								</td>
							</tr>
							</table>
					</fieldset>
				</form>
			</div>
		<script>
			function insert(){
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
				
				fm.action = "/noticeInsert";
				fm.method = "post";
				fm.submit();
			}
		</script>
	
	</body>
</html>