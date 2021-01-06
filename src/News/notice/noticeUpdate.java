package News.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Notice_DAO;
import dto.Notice_DTO;


@WebServlet("/noticeUpdate")
public class noticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noticeUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Notice_DAO dao = new Notice_DAO();
		
		String notice_no = request.getParameter("t_notice_no");
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String reg_date = dao.getToday();
		
		Notice_DTO dto = new Notice_DTO(notice_no, title, content, reg_date);
		int result = dao.updateSnotice(dto);
		if (result != 0) {
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("실패했습니다.");
		}
		
		response.sendRedirect("/noticeList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
