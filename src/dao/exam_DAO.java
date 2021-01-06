package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;

public class exam_DAO {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection 			  con = null;
	PreparedStatement 	   ps = null;
	ResultSet 			   rs = null;	
	
	public String checkLogin(String id, String pw){ //xxx님 환영합니다. (조회) -----------완료
		String query = " select name from A08_SERVLET_TEST_MEMBER "+
				       " where id = '"+id+"' "+
				       " and pw = '"+pw+"' ";
		String result = null;
		try{
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
		}catch(SQLException se){
			System.out.println("SQLException checkLogin():"+se.getMessage());
		}catch(Exception s){
			System.out.println("Exception checkLogin():"+s.getMessage());
		}finally{
			try{
				common.close(con,ps,rs);
			}catch(Exception e){
				System.out.println("close() 오류~:"+e.getMessage());
			}
		}
		return result;
	}
	
	public int insertMember(String id, String pw, String name, String bd, String sex, String phone){ //회원가입 등록--완료
		int result = 0;
		String query = " insert into A08_SERVLET_TEST_MEMBER(id,pw,name,bd,sex,phone) "+
					   " values('"+id+"','"+pw+"','"+name+"','"+bd+"','"+sex+"','"+phone+"') ";
		try {
			con 	= common.getConnection();
			ps  	= con.prepareStatement(query);
			result  = ps.executeUpdate();			
		}catch(SQLException se) {
			System.out.println("SQLException insertMember():"+se.getMessage());
		}catch(Exception e) {
			System.out.println("Exception insertMember():"+e.getMessage());
		} finally {
			try {
				common.close(con,ps,rs);
			}catch(Exception e) {
				System.out.println("close() 오류~:"+e.getMessage());
			}
		}
		return result;		
	}
	
	public String getCheckCount(String id){ //회원가입 id 중복 검사 -------- 완료
		String query = " select count(*) from A08_SERVLET_TEST_MEMBER "+
					   " where id='"+id+"' ";
		String result = "";
		try{
			con = common.getConnection();
			ps  = con.prepareStatement(query);
			rs  = ps.executeQuery();
			while(rs.next()){
				result = rs.getString(1);
			}
		}catch(SQLException se){
			System.out.println("SQLException getCheckCount():"+se.getMessage());
		}catch(Exception s){
			System.out.println("Exception getCheckCount():"+s.getMessage());
		}finally{
			try{
				common.close(con,ps,rs);
			}catch(Exception e){
				System.out.println("close() 오류~:"+e.getMessage());
			}
		}
		return result;
	}
}
