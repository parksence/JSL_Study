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


@WebServlet("/noticeInsert")
public class noticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noticeInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Notice_DAO dao = new Notice_DAO();
		
		String notice_no = dao.getNoticeNo();
		String title = request.getParameter("t_title");
		String content = request.getParameter("t_content");
		String file = request.getParameter("t_file");
		String reg_date = dao.getToday();
		int hit = 0;
		
		Notice_DTO dto = new Notice_DTO(notice_no, title, content, file, reg_date, hit);
		int result = dao.insertSnotice(dto);
		if(result > 0) {
			String msg = "등록되었습니다";
			String url = "/noticeList";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		} else {
			String msg = "님 실패했습니다.";
			String url = "/Index";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		}
		
//		if (result != 0) {
//			System.out.println("등록되었습니다.");
//		} else {
//			System.out.println("실패했습니다.");
//		}
		
		response.sendRedirect("/noticeList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
