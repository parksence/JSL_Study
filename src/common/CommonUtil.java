package common;
import java.util.*;
import java.text.*;
import java.io.*;

public class CommonUtil{
	public static String file_dir_notice = "C:/Users/admin/Desktop/박희준_eclipse_source/phj_servlet_homepage/WebContent/file_room/notice/";
	public static String file_dir_news   = "C:/Users/admin/Desktop/박희준_eclipse_source/phj_servlet_homepage/WebContent/file_room/news/";
//	public static String image_dir       = "C:/Users/admin/Desktop/이경재_eclipse_source/lkj_jsp/WebContent/file_room/news_images/";
	public static String image_dir       = "C:/Users/admin/Desktop/박희준_eclipse_source/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/phj_servlet_homepage/file_room/news_images/";
//	public static String image_dir       = "C:/Users/admin/Desktop/이경재_eclipse_source/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/lkj_jsp/file_room/news_images/";

	//파일이동
	public static void moveFile(String filename, String newFilename) {
	    File file = new File(filename);
	    File fileNew = new File(newFilename);
	    if(file.exists()) file.renameTo(fileNew);
	}
	
	//파일복사
	public static void copyFile(String oriFilePath, String copyFilePath){
		 //파일객체생성
		 File oriFile = new File(oriFilePath);
		 //복사파일객체생성
		 File copyFile = new File(copyFilePath);
		 try {
		     FileInputStream fis = new FileInputStream(oriFile); //읽을파일
		     FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일
		     int fileByte = 0; 
		     // fis.read()가 -1 이면 파일을 다 읽은것
		     while((fileByte = fis.read()) != -1) {
		         fos.write(fileByte);
		     }
		     //자원사용종료
		     fis.close();
		     fos.close();
		 } catch (FileNotFoundException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		 } catch (IOException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		 }
	}


	
	
	//날짜비교
	public static int dateCompare(String a){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String td = sdf.format(today);
		
		int result = 0;
		if(Integer.parseInt(td)>Integer.parseInt(a)) {
			result = 1;
		}
		
		return result;
	}
	
	//날짜비교
	public static int eventCompare(String a){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date today = new Date();
		String td = sdf.format(today);
		String ed = a.replaceAll("-", "");
		
		int result = 0;
		if(Integer.parseInt(ed)>Integer.parseInt(td)) {
			result = 2;
		} else if(Integer.parseInt(ed)==Integer.parseInt(td)){
			result = 1;
		} else if(Integer.parseInt(ed)<Integer.parseInt(td)) {
			result = 0;
		}
		return result;
	}
	
	//반납날짜비교
	public static int dateCompare(String a, String b){
			String y = a.substring(0,4);
			String m = a.substring(5,7);
			String d = a.substring(8,10);
			a = y+m+d;
			int result = 0;
			if((Integer.parseInt(a)>Integer.parseInt(b))||(Integer.parseInt(a)!=Integer.parseInt(b))) {
				result = 1;
			}
			
			return result;
		}


	
	//숫자문자판단1
	public static boolean isStringDouble(String s) {
	  try {
	      Double.parseDouble(s);
	      return true;
	  } catch (NumberFormatException e) {
	      return false;
	  }
	}
	
	//오늘날짜
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	
	//오늘날짜
	public static String getTodayTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	
	//오늘날짜
	public static String getToday2(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date date = new Date();
		String today = sdf.format(date);
		return today;
	}
	
	
	// 날짜형식 검사
	public static boolean checkDate(String checkDate){
		SimpleDateFormat dateFormat = 
			new SimpleDateFormat("yyyyMMdd");
		boolean checkD = true;
		dateFormat.setLenient(false);
		try{
			dateFormat.parse(checkDate);
		}catch(ParseException e){
			checkD = false;
		}
		return checkD;
	}
	
	// 연식 검사
	public static boolean checkYM(String checkDate){
		SimpleDateFormat dateFormat = 
			new SimpleDateFormat("yyyyMM");
		boolean checkD = true;
		dateFormat.setLenient(false);
		try{
			dateFormat.parse(checkDate);
		}catch(ParseException e){
			checkD = false;
		}
		return checkD;
	}	
	
	// 부족한 자리수 만큼 채우기 왼쪽채우기
	public static String getLPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str = strFillText + str;
        }
        return str;
    }
	// 부족한 자리수 만큼 채우기 양쪽채우기
	public static String getCPad(String str, int size, String strFillText) {
        int intPadPos = 0;
        for(int i = (str.getBytes()).length; i < size; i++) {
            if(intPadPos == 0) {
                str += strFillText;
                intPadPos = 1;
            } else {
                str = strFillText + str;
                intPadPos = 0;
            }
        }
        return str;
    }
	// 부족한 자리수 만큼 채우기 오른쪽채우기
	public static String getRPad(String str, int size, String strFillText) {
        for(int i = (str.getBytes()).length; i < size; i++) {
            str += strFillText;
        }
        return str;
        
    }
	// null 검사
	public static String checkNull(String sValue){
		String result="";
		if(sValue != null) result = sValue;
		return result;
	}
	// 페이지
	public static String pageList(int current_page,int totalpage, String list_url){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트
		
		pagenumber = 5;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><i class='fa fa-angle-double-left'></i></a>";
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a href='' class='active'>["+current_page+"]</a>";
			} else {
				strList = strList +"<a href='"+list_url+"&r_page="+curpage+"'><font color=#666699>["+curpage+"]</font></a>";
			}
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href='"+list_url+"&r_page="+curpage+"'><i class='fa fa-angle-double-right'></i></a>";
		}
		
		return strList;
	}
	
	// 페이지
	public static String pageList22(int current_page,int totalpage){
		int pagenumber;    //화면에 보여질 페이지 인덱스수
		int startpage;     //화면에 보여질 시작 페이지 번호
		int endpage;       //화면에 보여질 마지막 페이지 번호
		int curpage;       //이동하고자 하는 페이지 번호
		
		String strList=""; //리턴될 페이지 인덱스 리스트
		
		pagenumber = 5;   //한 화면의 페이지 인덱스수
		
		//시작 페이지 번호 구하기
		startpage = ((current_page - 1)/ pagenumber) * pagenumber + 1;
		//마지막 페이지 번호 구하기
		endpage = (((startpage -1) + pagenumber) / pagenumber)*pagenumber;
		//총페이지수가 계산된 마지막 페이지 번호보다 작을 경우
		//총페이지수가 마지막 페이지 번호가 됨
		
		if(totalpage <= endpage)  endpage = totalpage;
					
		//첫번째 페이지 인덱스 화면이 아닌경우
		if(current_page > pagenumber){
			curpage = startpage -1;  //시작페이지 번호보다 1적은 페이지로 이동
			strList = strList +"<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-left'></i></a>"; //첫화살표
		}
						
		//시작페이지 번호부터 마지막 페이지 번호까지 화면에 표시
		curpage = startpage;
		while(curpage <= endpage){
			if(curpage == current_page){
				strList = strList +"<a href='' class='active'>["+current_page+"]</a>"; //현재페이지
			} else {
				strList = strList +"<a href=javascript:goPage("+curpage+")><font color=#666699>["+curpage+"]</font></a>"; //바뀔페이지
			}						//'"+list_url+"&r_page="+curpage+"'
			curpage++;
		}
		//뒤에 페이지가 더 있는 경우
		if(totalpage > endpage){
			curpage = endpage+1;
			strList = strList + "<a href=javascript:goPage("+curpage+")><i class='fa fa-angle-double-right'></i></a>"; //마지막화살표
		}
		
		return strList;
	}
	

	
}

