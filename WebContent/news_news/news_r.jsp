<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/header.jsp"%>
<html lang="ko">
	<title>파크센스의 개발보드</title>
		<meta charset="utf-8">
		<link href="/css/common.css" rel="stylesheet">
		<link href="/css/sub-notice.css" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css">
		<script src="/js/jquery-3.3.1.min.js"></script>
	<body>
		<!-- sub page start -->
		<div class="notice">
			<!-- sub-news start-->
			<div class="news-box">
<c:if test="${news_dtos.size() > 0}">
	<c:forEach items="${news_dtos}"  var="dto">	
				<div class="news_layout">
				<ul class="news">
					<li>
						<a href="newsView?t_news_no=${dto.getNews_no()}">
							<span><img class="img_1" src="/file_room/news/${dto.getNews_no()}-${dto.getImages()}"></span>
							<br>${dto.getTitle()}<br>
							${dto.getContents()}
							<span class="size-up"></span>
						</a>
					</li>
				</ul>
				</div>
	</c:forEach>	
</c:if>				 
<c:if test="${news_dtos.size() == 0}">		
				   <TR align="center" bgcolor="white" >
					   <TD colspan="5" >등록된 내용이 없습니다.</TD>
				   </TR>
</c:if>							
			</div>
			<div class="write_a">
<c:if test="${session_name == '관리자'}">			
				<a href="/newsWriteForm" class="btn-write">글쓰기</a>
</c:if>				
			</div>				
			</div>
		<!--  footer start  -->
<%@ include file="/footer.jsp"%>		
	</body>
</html>