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

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		int studentId = student.getStudentId();

		//申込、削除の処理
		switch(request.getParameter("action")){
		case"insert":

			//科目を取得
			int tueSubjectId = Integer.parseInt(request.getParameter("tue"));
			int thuSubjectId = Integer.parseInt(request.getParameter("thu"));

			//インスタンス化
			SubjectDAO subjectDAO = new SubjectDAO();

			//科目登録
			subjectDAO.insertAttendSubject(studentId,tueSubjectId,thuSubjectId);

			break;
		case"delete":

			//科目の取得
			int deleteAttendSubjectId = Integer.parseInt(request.getParameter("delete_attend_subject_id"));

			//科目の削除
			subjectDAO.deleteAttendSubject(studentId,deleteAttendSubjectId);

			break;
		default:
		}


		RequestDispatcher rd=
				request.getRequestDispatcher("WEB-INF/jsp/StudentRegister.jsp");
				rd.forward(request,response);
	}
}
