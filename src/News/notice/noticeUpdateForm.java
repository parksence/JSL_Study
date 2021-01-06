package News.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Notice_DAO;
import dto.Notice_DTO;


@WebServlet("/noticeUpdateForm")
public class noticeUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noticeUpdateForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice_DAO dao = new Notice_DAO();
		String notice_no = request.getParameter("t_notice_no");
		Notice_DTO dto = dao.getNoticeView(notice_no);
		request.setAttribute("t_dto", dto);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/news_notice/notice_u.jsp");
		rdp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
