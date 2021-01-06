<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<%@ include file="/header.jsp"%>

	<div class="container">
		<div class="text_center">
			<p><span class="support_text"><strong>사회적 기업을 최우선으로 하는 믿음</strong></span></p></br>
			글로벌 경쟁력을 기반으로 최고의 IT 서비스 가치를 업그레이드하며</br>
			한단계 앞서는 새로운 패러다임을 이끌어가는 기업
			<span class="col_bar"></span>
			
		</div>
		<div class="greeting_cont">
<div class="table-box">
				<table class="table">
					<colgroup>
						<col width="12%">
						<col width="*">
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
<tr>
	<td colspan="1" style="text-align:left">					
					&nbsp;&nbsp; 총 게시건수 : ${notice_dtos.size()} 건
	</td>
	<td colspan="3" style="text-align:right">
	<div class="search_group">				
		<form name="notice">
		<input type="hidden" name="t_notice_no">
			<select name="t_sel" class="select">
            	<option value="title" <c:if test="${selValue =='title'}"> out.print("selected");</c:if>>제목</option>
                <option value="content" <c:if test="${selValue =='content'}"> out.print("selected");</c:if>>내용</option>
        	</select>
		<input type="text" name="t_search" value="${txtValue}" class="search_word">
		<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
		</form>
	</div>
	</td>		
</tr>		
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					
					<tbody>
<c:set var="forYN" value="true"/>	
<c:if test="${notice_dtos.size() > 0}">
	<c:forEach items="${notice_dtos}" var="dto">	
		<c:if test="${forYN}">	
	
			<c:if test="${v_count == for_count}">
						 <tr>
							<td><a href="noticeView?t_notice_no=${dto.getNotice_no()}">${dto.getNotice_no()}</a></td>
							<td class="txt">
								<a href="noticeView?t_notice_no=${dto.getNotice_no()}">${dto.getTitle()}</a>
<c:if test="${session_name == '관리자'}">								
								<a href="javascript:noticeUpdate('${dto.getNotice_no()}')">[수정]</a>
								<a href="javascript:noticeDelete('${dto.getNotice_no()}')">[삭제]</a>
</c:if>								
							</td>
							<td>${dto.getReg_date()}</td>
							<td>${dto.getHit()}</td>
						 </tr>
				<c:set var="v_count" value="${v_count+1}"/>
				<c:set var="for_count" value="${for_count+1}"/>
				
	 		</c:if>
		 	<c:if test="${v_count != for_count}">
		 		<c:set var="v_count" value="${v_count+1}"/>
		 	</c:if>
		 	<c:if test="${v_count == a_count}">
		 		<c:set var="forYN" value="false"/>
		 	</c:if>
	 	</c:if>
	</c:forEach>	
</c:if>				 
<c:if test="${notice_dtos.size() == 0}">
			   <TR align="center" bgcolor="white" >
				   <TD colspan="5" >등록된 내용이 없습니다.</TD>
			   </TR>
</c:if>					 
					</tbody>
				</table>
<script>
	function noticeUpdate(aa){
		var fm = document.notice;
		fm.t_notice_no.value = aa;
 		fm.action ="/noticeUpdateForm";
 		fm.method ="post";
 		fm.submit();		
	}
	
	function noticeDelete(aa){
		var fm = document.notice;
		fm.t_notice_no.value = aa;
 		fm.action ="/noticeDelete";
 		fm.method ="post";
 		fm.submit();		
	}
</script>				
${t_notice_no}				
			</div>
			
			<div class="page-number">
<%


	out.println(common.CommonUtil.pageList(0, 0, ""));
	
%>			
<c:if test="${session_name == '관리자'}">
				<a href="/noticeWriteForm" class="btn-write">글쓰기</a>
</c:if>					
<%
//		}
%>				
			</div>
		</div>
		</div>
	</div>


<%@ include file="/footer.jsp"%>
</body>
</html>