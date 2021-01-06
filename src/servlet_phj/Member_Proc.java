package servlet_phj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.exam_DAO;


@WebServlet("/Member_Proc")
public class Member_Proc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member_Proc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		exam_DAO dao = new exam_DAO();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw_1");
		String name = request.getParameter("name");
		String bd = request.getParameter("bd_1")+"-"+request.getParameter("bd_2")+"-"+request.getParameter("bd_3");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone_1")+"-"+request.getParameter("phone_2")+"-"+request.getParameter("phone_3");
		
		int result = dao.insertMember(id, pw, name, bd, sex, phone);
		if(result > 0) {
			String msg = "등록되었습니다";
			String url = "/Index";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		} else {
			String msg = "실패했습니다.";
			String url = "/Index";
			request.setAttribute("msg",msg);
			request.setAttribute("url",url);
			RequestDispatcher rdp = request.getRequestDispatcher("/view_msgAlert.jsp");
			rdp.forward(request, response);
		}
		response.sendRedirect("/Index");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
