package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDAO;
import model.Student;

@WebServlet("/AttendSubject")
public class AttendSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session=request.getSession();

		//ユーザー情報の取得
		Student student=(Student)session.getAttribute("student");
		int studentId = student.getStudentId();

		//科目を取得
		String subjectId=request.getParameter("subjectid");

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込、変更、削除の処理
		switch(request.getParameter("xxx")){
		case"申込":
			subjectDAO.insertAttendSubject(studentId,subjectId);
			break;
		case"変更":
			subjectDAO.updateAttendSubject(studentId,subjectId);

			break;
		case"削除":
			subjectDAO.deleteAttendSubject(studentId,subjectId);

			break;
		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher("");
				rd.forward(request,response);
	}

}
