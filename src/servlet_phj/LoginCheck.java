package servlet_phj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.exam_DAO;


@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		exam_DAO dao = new exam_DAO();
		String id = request.getParameter("t_id");
		String pw = request.getParameter("t_pw");
		String name = dao.checkLogin(id,pw);
		
		if(name == null) {
			String msg = "ID 또는 PASSWORD 오 류";
			String url = "/Login";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("session_name",name);
			session.setAttribute("session_id",id);
			if(id.equals("manager")){
				session.setAttribute("session_level","manager");
			}
//			session.setMaxInactiveInterval(60*60*1);
			session.setMaxInactiveInterval(10);
			
			String msg = name+"님 환영합니다.";
			String url = "/Index";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
