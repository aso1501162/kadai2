package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;

@WebServlet("/RegistSubject")
public class RegistSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//科目を取得
		String subject=request.getParameter("xxx");

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込、変更、削除の処理
		switch(request.getParameter("xxx")){
		case"登録":
			subjectDAO.registSubject(subject);

			break;
		case"変更":
			subjectDAO.updateSubject(subject);

			break;
		case"削除":
			subjectDAO.deleteSubject(subject);

			break;
		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher("");
				rd.forward(request,response);
	}

}
