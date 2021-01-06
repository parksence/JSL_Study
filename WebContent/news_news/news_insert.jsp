<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%-- <%@ include file="/common_session_info.jsp" %> --%>
<%@ page import ="dao.News_DAO,common.CommonUtil,dto.News_DTO"%>
<%@ page import ="com.oreilly.servlet.*,java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	News_DAO dao = new News_DAO();
	String news_no = dao.getNewsNo();
	int sizeLimit = 1024 * 1024 * 5;

	String file_dir = CommonUtil.file_dir_news;
	String images = CommonUtil.image_dir;
	
	MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"UTF-8");
	
// 	String fileName = mpr.getFilesystemName("fileName_a");
	
// 	String saveFileName = "";
// 	if(fileName != null){
// 		File oldFile = new File(file_dir,fileName);
// 		File newFile = new File(file_dir,news_no+"-"+fileName);
// 		oldFile.renameTo(newFile);
// 		saveFileName = newFile.getName();
// 	} 
	
	String title 		= mpr.getParameter("t_title");	
	String contents		= mpr.getParameter("t_content");
	String reg_date 	= CommonUtil.getToday();
	int hit 			= 0;
	
	News_DTO dto = new News_DTO(news_no, title, contents, images, reg_date, hit);
	int result = dao.insertNews(dto);
%>
<html>
	<head>
		<script>
			<%if(result > 0){%>
				alert("등록되었습니다~");
			<%}else{%>
				alert("정상처리 되지 못했습니다~");
			<%}%>
  			location.href = "/newsList";
		</script>
	</head>
</html>