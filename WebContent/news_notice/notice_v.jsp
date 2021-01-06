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
		<link href="/css/notice-cont.css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="/js/jquery-3.3.1.min.js"></script>
		
	<body>
		<!-- sub page start -->
		<form name="notice">
			<input type="hidden" name="t_work_gubun" value="delete">
			<input type="hidden" name="t_notice_no" value="${t_dto.getNotice_no()}">
		</form>
		<div class="notice">
			<div class="sub-notice">
			<h2 class="color"><a href="/noticeList"><i class="fas fa-check"></i> NOTICE</a></h2>	
			<h2><a href="/newsList"> NEWS</a></h2>
			<h2><a href="/qnaList"> Q&A</a></h2>	
			<h2><a href="/faqList"> FAQ</a></h2>	
			</div>
			
			<!-- cont start(내용에 양식그대로 받으려면 textarea사용하면됨)-->
			<div class="cont-box">
				<h3>${t_dto.getTitle()}<br>
					<span>${t_dto.getReg_date()} / 공지사항 </span></h3>
				<div>${t_dto.getContents()}</div>
			</div>
				
			<!-- sub button start-->
			
			<div class="list">
<!-- 				<a href="javascript:deleteNotice()" class="btn-write">삭 제</a> -->
<%-- 				<a href="/noticeUpdateForm?t_noticeNo=${t_dto.getNotice_no()}" class="btn-write">수 정</a> --%>
				<a href="/noticeList">View list</a>&nbsp;&nbsp;
			</div>
		
		</div>

	</body>
</html>