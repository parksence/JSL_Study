package News.news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News_DAO;
import dto.News_DTO;

@WebServlet("/newsUpdateForm")
public class newsUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public newsUpdateForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		News_DAO dao = new News_DAO();
		String news_no = request.getParameter("t_news_no");
		News_DTO dto = dao.getNewsView(news_no);
		request.setAttribute("t_dto", dto);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/news_news/news_u.jsp");
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
