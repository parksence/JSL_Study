<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.News_DAO,dto.News_DTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	News_DAO dao    = new News_DAO();
	String news_no  = request.getParameter("t_news_no");
	int nHit 		= dao.newsHit(news_no);
	News_DTO dto    = dao.getNewsView(news_no);
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
			<input type="hidden" name="t_news_no" value="${t_dto.getNews_no()}">
		</form>
		<div class="notice">
			<div class="sub-notice">
			<h2><a href="/noticeList"> NOTICE</a></h2>	
			<h2 class="color"><a href="/newsList"><i class="fas fa-check"></i> NEWS</a></h2>
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
<c:if test="${session_name == '관리자'}">			
				<a href="javascript:deleteNews()" class="btn-write">삭 제</a>
				<a href="/newsUpdateForm?t_news_no=${t_dto.getNews_no()}" class="btn-write">수 정</a>
</c:if>				
				<a href="/newsList">View list</a>&nbsp;&nbsp;
			</div>
		
		</div>

	</body>
</html>