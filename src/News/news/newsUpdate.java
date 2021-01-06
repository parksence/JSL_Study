package News.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.News_DAO;
import dto.News_DTO;

@WebServlet("/newsUpdate")
public class newsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public newsUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		News_DAO dao = new News_DAO();
		
		String news_no  = request.getParameter("t_news_no");
		String title    = request.getParameter("t_title");
		String content  = request.getParameter("t_content");
		String file_name_1 = request.getParameter("t_file_name_1");
		String reg_date = dao.getToday();
		
		News_DTO dto = new News_DTO(news_no, title, content, file_name_1, reg_date);
		int result = dao.updateNews(dto);
		if (result != 0) {
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("실패했습니다.");
		}
		
		response.sendRedirect("/newsList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
