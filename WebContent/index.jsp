<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html lang="ko">

 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="Author" content="구송이">
  <meta name="Keywords" content="문화재청 덕수궁, 반응형 홈페이지">
  <meta name="Description" content="응용sw개발자를 위한 반응형 홈페이지">
  <title>파크센스의 개발보드</title>
  <script src="js/jquery-3.3.1.min.js"></script>
  <link href="css/font-awesome.min.css" rel="stylesheet">
	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
  <link href="css/common.css" rel="stylesheet">
  <link href="css/layout.css" rel="stylesheet">	
 
 	<!-- jquery언어 사용법
	1. jquery.js 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크 건다
	2. $(function() {
	실행문;
	});
	-->
 </head>
<script>
		$(function(){
			$(".gnb>.nav_1depth>li").hover(function(){
				//console.log("gnb>.nav_1depth>li");
				//$(".main_center .box3 nav ul li").removeClass("active");
				//$(this).addClass("active");
				//$(".clearfix").hide();

				//var activeTab = $(this).find("a").attr("href"); 
                //$(activeTab).fadeIn(); 
                //return false;

				$(this).children(".nav_2depth").stop().slideDown("fast");
				}, function(){
					$(".gnb>.nav_1depth>li").removeClass();
					$(this).children(".nav_2depth").stop().slideUp("fast");
				}
			);
				//$(".main_center .box3 nav ul li").click(function(e){
					//$(this).addClass("active")
					//var num = $(this).index();
					//$(".taball").hide().eq(num).show();
				//}
		});
</script>

 <body>
 <!-- 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<div class="sr-only">
		<p><a href="#contents">본문 바로가기</a></p>
	</div>
	
	<div class="top_navigation">
		<header class="header">
			<nav class="top_left">
				<ul>
					<li class="first"><a href="/Index">HOME</a></li>
					<li><a href="#">카카오톡</a></li>
					<li><a href="#">인스타그램</a></li>
					<li><a href="#">네이버톡톡</a></li>
				</ul>
			</nav>

			<nav class="top_right">
<c:if test="${session_name == null}">			
				<ul>
					<li class="first"><a href="/Login">LOGIN</a></li>
					<li><a href="/Join">JOIN</a></li>
					<li><a href="#">CART</a></li>
					<li><a href="#">ORDER</a></li>
				</ul>
</c:if>
<c:if test="${session_name != null}">			
				<ul>
					<li class="first"><a href="/Logout">LOGOUT</a></li>
					<li><a href="/Myinpo">MYINPO</a></li>
					<li><a href="#">CART</a></li>
					<li><a href="#">ORDER</a></li>
				</ul>
</c:if>								
			</nav>

			<div class="gnb_group">
				<h1 class="logo"><a href="/Index"><img src="/images/logo.jpg" width="80px" height="70px"></a></h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="/noticeList">NEWS</a>
							<ul class="nav_2depth">
								<li><a href="/noticeList">NOTICES</a></li>
								<li><a href="/newsList">NEWS</a></li>
								<li><a href="/qnaList">Q&A</a></li>
								<li><a href="/faq">FAQ</a></li>
							</ul>
						</li>
						<li><a href="/Video">VIDEOS</a>
							<ul class="nav_2depth">
								<li><a href="/Video">Highlight</a></li>
							</ul>
						</li>
						<li><a href="/Matches">MATCHES</a>
							<ul class="nav_2depth">
								<li><a href="/Matches">The schedule of a game</a></li>
							</ul>
						</li>
						<li><a href="/Ticket">TICKETS & MEMBERSHIP</a>
							<ul class="nav_2depth">
								<li><a href="/Ticket">TICKETS</a></li>
								<li><a href="/MemberShip">MEMBERSHIP</a></li>
							</ul>
						</li>
						<li><a href="/Shop">SHOP</a>
						</li>
					</ul>
				</nav>
			</div>
		</header>
		<div class="line">
		</div>
	</div>

	<section id="main_visual">
		<div class="visual_wrap">
			<h2 class="sr-only">메인 비쥬얼</h2>
			<ul>
				<!-- <li><img src="images/bg.png" alt="학생단체관람" class="w100"></li> -->
				<li class="one"></li>
			</ul>
			<div class="visual_inner">
				<p class="title">DREAM <strong>SCENE</strong></p> 
				<p class="txt">CHELSEA'S GREATEST OF ALL TIME. IN ONE DRESSING ROOM.<br/>  WHO WOULD YOU CHOOSE?</p>
			</div>
		</div>
	</section>

	<section class="news_group">
		<div class="news_tit">
			<p class="sub_tit">OUR OBJECTIVE</p>
			<h2>Chelsea</h2>
			<p class="text">with the aim of winning the championship</p>
			<a href="" class="btn-border">Watch the game</a>
		</div>
		<ul class="news_list">
			<li>
				<a href="/newsList">
					<img src="images/4.jpg" class="w100">
					<strong>NEWS</strong>
					<p>올해의 베스트 선수단, 함께 응원해주세요.</p>
					<span>2018-09-20</span>
					<div class="over">
						<strong>NEWS</strong>
						<p>올해의 베스트 선수단, 함께 응원해주세요.</p>
						<span>2018-09-20</span>
					</div>
				</a>
			</li>
			<li>
				<a href="/Video">
					<img src="images/2.jpg" class="w100">
					<strong>VIDEOS</strong>
					<p>우승은 첼시! 그 외는 상상 할 수 없다.</p>
					<span>2018-09-20</span>
					<div class="over">
						<strong>VIDEOS</strong>
						<p>우승은 첼시! 그 외는 상상 할 수 없다.</p>
						<span>2018-09-20</span>
					</div>
				</a>
			</li>
			<li class="news_end">
				<a href="/newsEvent">
					<img src="images/3.jpg" class="w100">
					<strong>EVENT</strong>
					<p>역대급 규모의 이벤트! 첼시!</p>
					<span>2018-09-20</span>
					<div class="over">
						<strong>EVENT</strong>
						<p>역대급 규모의 이벤트! 첼시!</p>
						<span>2018-09-20</span>
					</div>
				</a>
			</li>
		</ul>
	</section>

		<div class="main_right">
		</div>
	</section>

	
	<script>
		$(function(){
			$(".gnb>.nav_1depth>li").hover(function(){
				//console.log("gnb>.nav_1depth>li");
				$(this).parent().addClass("active");
				$(".taball").hide();
				$($(this).attr("href")).show();
			});
		});
	</script>

	<div class="right_quick">
		<button class="btn btn-open" type="button"></button>
	</div>
<footer class="footer">
	<div class="container clearfix">
		<address class="address">
			<p class="title">본사</p>
			(우)12345 대전광역시 서구 관저로48<br>
			전화번호 042) 123-4567 팩스 042) 123-4567
		</address>
		<p class="copyright">COPYRIGHT &copy.VISION. ALL RIGHTS RESERVED.</p>
	</div>
</footer>
 </body>


</html>