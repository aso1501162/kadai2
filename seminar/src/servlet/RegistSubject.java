package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dao.SubjectDAO;
import model.Student;

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

		//申込、削除の処理
		switch(request.getParameter("action")){

		case"insert":

			//未入力欄の確認
			try {

				//科目を取得
				int subjectId = Integer.parseInt(request.getParameter("subject_id"));
				String subjectName = request.getParameter("subject_name");
				int categoryId = Integer.parseInt(request.getParameter("category_id"));
				String day = request.getParameter("day");
				int teacherId = Integer.parseInt(request.getParameter("teacher_id"));

				if(subjectName.equals("")||
				   day.equals("")){
					throw new Exception();
				}

				//科目登録
				SubjectDAO subjectDAO = new SubjectDAO();
				subjectDAO.insertSubject(subjectId, subjectName, categoryId, day, teacherId);
			} catch (Exception e) {
				request.setAttribute("registErrorMessage","入力内容に誤りがあります。" );
		    }

			break;

		case"delete":

			int deleteSubjectId = Integer.parseInt(request.getParameter("delete_subject_id"));
			SubjectDAO subjectDAO = new SubjectDAO();

			//科目の削除
			subjectDAO.deleteSubject(deleteSubjectId);

			break;

		case"list":

			ArrayList<Student> attendStudentList = new ArrayList<Student>();
			int listSubjectId = Integer.parseInt(request.getParameter("list_subject_id"));
			StudentDAO studentDAO = new StudentDAO();

			//受講者リストの取得
			attendStudentList=studentDAO.getAttendStudentList(listSubjectId);

			break;

		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher("WEB-INF/jsp/TeacherRegister.jsp");
				rd.forward(request,response);
	}
}
