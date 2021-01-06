package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import common.*;
import dto.News_DTO;

public class News_DAO {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection 			  con = null;
	PreparedStatement 	   ps = null;
	ResultSet 			   rs = null;	
	
	//오늘날짜
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	
	public int newsHit(String news_no){ //조회수 증가
		int result = 0;
		String query = " update A08_SERVLET_TEST_NEWS set hit = hit+1 where news_no ='"+news_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException newsHit():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception newsHit():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("newsHit() close:"+e.getMessage());
			}
		}
		return result;		
	}
	public News_DTO getNewsView(String new_no){ //상세조회
		News_DTO dto = null;
		String query = " select news_no, title, contents, images, file_name_1, to_char(reg_date, 'yy-MM-dd'), hit "+
					   " from A08_SERVLET_TEST_NEWS "+
					   " where news_no = '"+new_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String news_no 		= rs.getString(1);
				String title 		= rs.getString(2);
				String contents 	= rs.getString(3);
				String images		= rs.getString(4);
				String file_name_1  = rs.getString(5);
				String reg_date 	= rs.getString(6);
				int    hit 			= rs.getInt(7);
				dto = new News_DTO(news_no, title, contents, images, file_name_1, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getNewsView():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getNewsView():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getNewsView() close:"+e.getMessage());
			}
		}
		return dto;
	}
	public ArrayList<News_DTO> getNewsList(String selValue, String txtValue){ //목록조회
		ArrayList<News_DTO> dtos = new ArrayList<News_DTO>();
		String query = " select news_no, title, contents, images, file_name_1, to_char(reg_date, 'yy-MM-dd'), hit "+
					   " from A08_SERVLET_TEST_NEWS "+
					   " where "+selValue+" like '%"+txtValue+"%' "+
					   " order by news_no desc";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String news_no 		= rs.getString(1);
				String title 		= rs.getString(2);
				String contents 	= rs.getString(3);
				String images		= rs.getString(4);
				String file_name_1	= rs.getString(5);
				String reg_date 	= rs.getString(6);
				int    hit 			= rs.getInt(7);
				News_DTO dto = new News_DTO(news_no, title, contents, images, file_name_1,reg_date, hit);
				dtos.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getNewsList():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getNewsList():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getNewsList() close:"+e.getMessage());
			}
		}
		return dtos;
	}
	
	public int deleteNews(String news_no) { //공지사항 삭제
		int result = 0;	
		String query = " delete from A08_SERVLET_TEST_NEWS where news_no = '"+news_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("SQLException deleteNews():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception deleteNews():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("deleteNews() close:"+e.getMessage());
			}
		}
		return result;		
	}
	
	public int updateNews(News_DTO dto) { //공지사항 수정
		int result = 0;	
		String query = " update A08_SERVLET_TEST_NEWS set title='"+dto.getTitle()+"', contents='"+dto.getContents()+"', file_name_1 = '"+dto.getFile_name_1()+"', reg_date = '"+dto.getReg_date()+"' "+
					   " where news_no = '"+dto.getNews_no()+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("SQLException updateNews():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception updateNews():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("updateNews() close:"+e.getMessage());
			}
		}
		return result;		
	}	
	
	public int insertNews(News_DTO dto) { //공지사항 등록
		int result = 0;	
		String query = " insert into A08_SERVLET_TEST_NEWS(news_no, title, contents, file_name_1, images, reg_date, hit) "+
					   " values('"+dto.getNews_no()+"', '"+dto.getTitle()+"', '"+dto.getContents()+"', '"+dto.getFile_name_1()+"',"+
					   " '"+dto.getImages()+"', '"+dto.getReg_date()+"', "+dto.getHit()+") ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException insertNews():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception insertNews():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("insertNews() close:"+e.getMessage());
			}
		}
		return result;		
	}	
	
//	public int insertNews(String news_no, String title, String contents, String images, String reg_date, int hit) { //공지사항 등록
//		int result = 0;	
//		String query = " insert into A08_SERVLET_TEST_NEWS (news_no, title, contents, images, reg_date, hit) "+ 
//					   " values ('"+news_no+"','"+title+"','"+contents+"','"+images+"','"+reg_date+"','"+hit+"') ";
//		try {
//			con = common.getConnection();
//			ps  = con.prepareStatement(query);
//			result  = ps.executeUpdate();
//		}catch(SQLException se) {
//			System.out.println("SQLException insertNews():"+se.getMessage());
//		}catch(Exception e) {
//			System.out.println("Exception insertNews():"+e.getMessage());
//		} finally {
//			try {
//				common.close(con,ps,rs);
//			}catch(Exception e) {
//				System.out.println("insertNews() close:"+e.getMessage());
//			}
//		}
//		return result;		
//	}	
	
	public String getMaxNo(){  //news_no 최대값 검사
		String query  = " select max(news_no) from A08_SERVLET_TEST_NEWS ";
		String result = null;
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				result = rs.getString(1);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getMaxNo():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getMaxNo():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getMaxNo() close:"+e.getMessage());
			}
		}
		return result;
	}
	
	public String getNewsNo() { //news_no 최대값 검사해서 id 만들기
		String newsNo = getMaxNo();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		String nowYear = Integer.toString(year);
		nowYear = nowYear.substring(2,4); //"19"
		if(newsNo == null) {
			newsNo = nowYear+"_0001";
		} else {
			String dataYear = newsNo.substring(0,2); //"19"
			
			if(nowYear.equals(dataYear)) {
				int y = Integer.parseInt(newsNo.substring(3)); //3
				y++; //4
				String r = CommonUtil.getLPad(Integer.toString(y),4,"0");
				newsNo = dataYear +"_"+r;
			} else {
				newsNo = nowYear+"_"+"0001";
			}		
		}		
		return newsNo;
	}
}