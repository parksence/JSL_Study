package News.news;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import common.CommonUtil;
import dao.News_DAO;
import dto.News_DTO;

@WebServlet("/newsInsert")
public class newsInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public newsInsert() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      News_DAO dao = new News_DAO();
      String news_no = dao.getNewsNo();
      int sizeLimit = 1024 * 1024 * 1; 
      String file_dir = "C:/Users/admin/Desktop/박희준_eclipse_source/phj_servlet_homepage/WebContent/file_room/news";
      MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"UTF-8");

      String fileName = mpr.getFilesystemName("fileName_a");
      String saveFileName = "";
      
      if(fileName!=null){
         File oldFile = new File(file_dir,fileName);
         File newFile = new File(file_dir,news_no+"-"+fileName);
         oldFile.renameTo(newFile);
         saveFileName = newFile.getName();
      } 
      
      String title = mpr.getParameter("t_title").replaceAll("\'","\''");
      String content = mpr.getParameter("t_content").replaceAll("\'","\''");
      if(content!=null) {
         content = content.replace("\n","<br>");
      }
      String reg_date = CommonUtil.getToday();
      int hit = 0;
      
      News_DTO dto = new News_DTO(news_no, title, content, saveFileName, reg_date, hit);
      int result = dao.insertNews(dto);
      if(result==1) {
         String msg = "news 등록 완료 ";
         String url = "/newsList";
         request.setAttribute("msg", msg);
         request.setAttribute("url", url);
         RequestDispatcher rdp = request.getRequestDispatcher("/view_messageAlert.jsp");
         rdp.forward(request, response);
      } else {
         String msg = "news 등록 실패 ";
         String url = "/newsList";
         request.setAttribute("msg", msg);
         request.setAttribute("url", url);
         RequestDispatcher rdp = request.getRequestDispatcher("/view_messageAlert.jsp");
         rdp.forward(request, response);
      }
//      RequestDispatcher dispatcher = request.getRequestDispatcher("/news_news/news_w.jsp");
//      response.sendRedirect("/newsList");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}