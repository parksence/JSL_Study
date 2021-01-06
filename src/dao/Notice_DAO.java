package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import common.*;
import dto.Notice_DTO;

public class Notice_DAO {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection 			  con = null;
	PreparedStatement 	   ps = null;
	ResultSet 			   rs = null;	

	public int noticeHit(String noti_no){ //조회수 증가
		int result = 0;
		String query = " update A08_SERVLET_TEST_NOTICE set hit = hit+1 where notice_no ='"+noti_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException noticeHit():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception noticeHit():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("noticeHit() close:"+e.getMessage());
			}
		}
		return result;		
	}
	
	public Notice_DTO getNoticeView(String noti_no){ //상세조회
		Notice_DTO dto = null;
		String query = " select notice_no, title, contents, to_char(reg_date, 'yy-MM-dd'), hit "+
					   " from A08_SERVLET_TEST_NOTICE "+
					   " where notice_no = '"+noti_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String notice_no 	= rs.getString(1);
				String title 		= rs.getString(2);
				String contents 	= rs.getString(3);
				String reg_date 	= rs.getString(4);
				int    hit 			= rs.getInt(5);
				dto = new Notice_DTO(notice_no, title, contents, reg_date, hit);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getNoticeView():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getNoticeView():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getNoticeView() close:"+e.getMessage());
			}
		}
		return dto;
	}
	
	//오늘날짜
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	public ArrayList<Notice_DTO> getnoticeList2(String selValue, String txtValue){ //목록조회
		ArrayList<Notice_DTO> dtos = new ArrayList<Notice_DTO>();
		String query = " select notice_no, title, contents, to_char(reg_date, 'yy-MM-dd'), hit "+
					   " from A08_SERVLET_TEST_NOTICE "+
					   " where "+selValue+" like '%"+txtValue+"%' "+
					   " order by notice_no desc";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String notice_no 	= rs.getString(1);
				String title 		= rs.getString(2);
				String contents 	= rs.getString(3);
				String reg_date 	= rs.getString(4);
				int    hit 			= rs.getInt(5);
				Notice_DTO dto = new Notice_DTO(notice_no, title, contents, reg_date, hit);
				dtos.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getNoticeList():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getNoticeList():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getNoticeList() close:"+e.getMessage());
			}
		}
		return dtos;
	}
	
	public ArrayList<Notice_DTO> getNoticeList(){ //목록조회
		ArrayList<Notice_DTO> dtos = new ArrayList<Notice_DTO>();
		String query = " select notice_no, title, contents, to_char(reg_date, 'yy-MM-dd'), hit "+
					   " from A08_SERVLET_TEST_NOTICE "+
					   " order by notice_no desc";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()) {
				String notice_no 	= rs.getString(1);
				String title 		= rs.getString(2);
				String contents 	= rs.getString(3);
				String reg_date 	= rs.getString(4);
				int    hit 			= rs.getInt(5);
				Notice_DTO dto = new Notice_DTO(notice_no, title, contents, reg_date, hit);
				dtos.add(dto);
			}
		}catch(SQLException se) {
			System.out.println("SQLException getNoticeList():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception getNoticeList():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("getNoticeList() close:"+e.getMessage());
			}
		}
		return dtos;
	}
	
	public int deleteNotice(String notice_no) { //공지사항 삭제
		int result = 0;	
		String query = " delete from A08_SERVLET_TEST_NOTICE where notice_no = '"+notice_no+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("SQLException deleteNotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception deleteNotice():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("deleteNotice() close:"+e.getMessage());
			}
		}
		return result;		
	}
	
	public int updateSnotice(Notice_DTO dto) { //공지사항 수정
		int result = 0;	
		String query = " update A08_SERVLET_TEST_NOTICE set title='"+dto.getTitle()+"', contents='"+dto.getContents()+"', reg_date = '"+dto.getReg_date()+"' "+
					   " where notice_no = '"+dto.getNotice_no()+"' ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();
		}catch(SQLException se) {
			System.out.println("SQLException updateSnotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception updateSnotice():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("updateSnotice() close:"+e.getMessage());
			}
		}
		return result;		
	}	
	
	public int insertSnotice(Notice_DTO dto) { //공지사항 등록
		int result = 0;	
		String query = " insert into A08_SERVLET_TEST_NOTICE(notice_no, title, contents, file_name_1, reg_date, hit) "+
					   " values('"+dto.getNotice_no()+"', '"+dto.getTitle()+"', '"+dto.getContents()+"', "+
					   " '"+dto.getFile_name_1()+"', '"+dto.getReg_date()+"', "+dto.getHit()+") ";
		try {
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException insertSnotice():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception insertSnotice():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("insertSnotice() close:"+e.getMessage());
			}
		}
		return result;		
	}	

	public String getMaxNo(){  //notice_no 최대값 검사
		String query  = " select max(notice_no) from A08_SERVLET_TEST_NOTICE ";
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
	
	public String getNoticeNo() { //notice_no 최대값 검사해서 id 만들기
		String noticeNo = getMaxNo();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		String nowYear = Integer.toString(year);
		nowYear = nowYear.substring(2,4); //"19"
		if(noticeNo == null) {
			noticeNo = nowYear+"_0001";
		} else {
			String dataYear = noticeNo.substring(0,2); //"19"
			
			if(nowYear.equals(dataYear)) {
				int y = Integer.parseInt(noticeNo.substring(3)); //3
				y++; //4
				String r = CommonUtil.getLPad(Integer.toString(y),4,"0");
				noticeNo = dataYear +"_"+r;
			} else {
				noticeNo = nowYear+"_"+"0001";
			}		
		}		
		return noticeNo;
	}
}