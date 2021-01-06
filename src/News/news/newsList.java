package News.news;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonUtil;
import dao.News_DAO;
import dto.News_DTO;

@WebServlet("/newsList")
public class newsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public newsList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		News_DAO dao = new News_DAO();
		String selValue = request.getParameter("t_sel");
		String txtValue = request.getParameter("t_search");
		if(selValue == null) {
			selValue ="title";
			txtValue ="";
		}	
		ArrayList<News_DTO> dtos = dao.getNewsList(selValue,txtValue);	
		request.setAttribute("news_dtos", dtos);
		request.setAttribute("selValue", selValue);
		request.setAttribute("txtValue", txtValue);
		
        // 방법 2
        RequestDispatcher dispatcher = request.getRequestDispatcher("/news_news/news_r.jsp");
       
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
//            out.println(e);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
