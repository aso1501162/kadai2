package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import model.Category;
import model.Student;
import model.Subject;
import model.Teacher;

@WebServlet("/ListAttendance")
public class ListAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//遷移先の宣言
		String path="";

		//リストの処理
		System.out.println("リストはじめ");
		try{
			int listSubjectId = Integer.parseInt(request.getParameter("id"));
			
			ArrayList<Student> attendStudentList = new ArrayList<Student>();

			SubjectDAO subjectDAO = new SubjectDAO();
			StudentDAO studentDAO = new StudentDAO();
			
			//	科目の取得
			Subject listSubject = subjectDAO.getSubject(listSubjectId);
			//	受講者リストの取得
			attendStudentList=studentDAO.getAttendStudentList(listSubjectId);
			
			request.setAttribute("listSubject", listSubject);
			request.setAttribute("attendStudentList", attendStudentList);
			
			path = "WEB-INF/jsp/AttendStudent.jsp";

		} catch (Exception e) {
			System.out.println(e);
			
			//全科目Listの宣言(火曜、木曜)
			ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
			ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
			//教師Listの宣言
			ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
			//分類Listの宣言
			ArrayList<Category> categoryList = new ArrayList<Category>();
			
			//DAOのインスタンス化
			TeacherDAO teacherDAO = new TeacherDAO();
			CategoryDAO categoryDAO = new CategoryDAO();
			SubjectDAO subjectDAO = new SubjectDAO();
			
			tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
			thursdaySubjectList = subjectDAO.getThursdaySubjectList();
			teacherList = teacherDAO.getTeacherList();
			categoryList = categoryDAO.getCategoryList();
			
			//管理者名、全科目Listのデータセット
			request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
			request.setAttribute("thursdaySubjectList", thursdaySubjectList);
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("categoryList", categoryList);
			
			request.setAttribute("message","受講者リストの取得に失敗しました。" );

			//遷移先の宣言
			path = "WEB-INF/jsp/TeacherRegister.jsp";
	    }
		System.out.println("リストおわり");
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
