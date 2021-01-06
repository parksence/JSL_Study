package News.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommonUtil;

@WebServlet("/noticeWriteForm")
public class noticeWriteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noticeWriteForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String session_level = 
				CommonUtil.checkNull((String)session.getAttribute("session_level"));
		RequestDispatcher dispatcher = null;
		if(session_level == null) {
			String msg = " 로그인 정보가 만료되었습니다.";
			String url = "/Index";
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			dispatcher = request.getRequestDispatcher("/view_msgAlert.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("/news_notice/notice_w.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
