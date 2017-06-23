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

		HttpSession session = request.getSession();

		//ユーザー情報の取得
		Student student = (Student)session.getAttribute("student");
		int studentId = student.getStudentId();

		//科目を取得
		String tueSubjectId = request.getParameter("tue");
		String thuSubjectId = request.getParameter("thu");

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込、削除の処理
		switch(request.getParameter("action")){
		case"insert":
			subjectDAO.insertAttendSubject(studentId,tueSubjectId,thuSubjectId);

			break;

		case"delete":
			String deleteAttendSubjectId = request.getParameter("delete_attend_subject_id");
			subjectDAO.deleteAttendSubject(studentId,deleteAttendSubjectId);

			break;

		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher("WEB-INF/jsp/StudentRegister.jsp");
				rd.forward(request,response);
	}
}
