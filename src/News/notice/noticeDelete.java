package News.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Notice_DAO;


@WebServlet("/noticeDelete")
public class noticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noticeDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Notice_DAO dao = new Notice_DAO();
		String notice_no = request.getParameter("t_notice_no");
		
		int result = dao.deleteNotice(notice_no);
		if(result != 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("실패!");
		}
		response.sendRedirect("/noticeList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
