package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
import model.Category;
import model.Student;
import model.Subject;
import model.Teacher;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "";

		HttpSession session=request.getSession();
		if (session != null) {
			session.invalidate();
			session = request.getSession();
		}

		//学生ログイン
		String password=request.getParameter("password");
		if(request.getParameter("studentid") != null){

			String studentid = request.getParameter("studentid");

			//DAOのインスタンス化
			StudentDAO studentDAO = new StudentDAO();

			Student student=studentDAO.getStudent(studentid,password);

			if (student != null) {
				System.out.println("学生ログイン成功： " + student.getStudentName());

				SubjectDAO subjectDAO = new SubjectDAO();

				//受講科目Listの宣言
				ArrayList<Subject> attendSubjectList = new ArrayList<Subject>();
				attendSubjectList = subjectDAO.getAttendSubjectList(student.getStudentId());

				//全科目Listの宣言(火曜、木曜)
				ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
				ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
				
				tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
				thursdaySubjectList = subjectDAO.getThursdaySubjectList();

				if(attendSubjectList.size()<2){
					request.setAttribute("attendErrorMessage", "火曜日と木曜日からそれぞれ１科目申し込んでください。");
				}

			//生徒名、受講科目List、全科目Listのデータセット
			session.setAttribute("loginStudent", student);
			request.setAttribute("attendSubjectList", attendSubjectList);
			request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
			request.setAttribute("thursdaySubjectList", thursdaySubjectList);

			//遷移先の宣言
			path = "WEB-INF/jsp/StudentRegister.jsp";
			
			} else {
				System.out.println("ログイン失敗");
				request.setAttribute("loginErrorMessage", "ユーザIDまたはパスワードが違います。");
				//遷移先の宣言
				path = "jsp/StudentLogin.jsp";
				
			}
		}
		


		//管理者ログイン
		if(request.getParameter("teacherid")!=null){

		String teacherid=request.getParameter("teacherid");

		//DAOのインスタンス化
		TeacherDAO teacherDAO = new TeacherDAO();
		CategoryDAO categoryDAO = new CategoryDAO();

		Teacher teacher = teacherDAO.getTeacher(teacherid,password);
			if (teacher != null) {
				System.out.println("管理者ログイン成功： " + teacher.getTeacherName());

				SubjectDAO subjectDAO = new SubjectDAO();

				//全科目Listの宣言(火曜、木曜)
				ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
				ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
				ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
				ArrayList<Category> categoryList = new ArrayList<Category>();
				tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
				thursdaySubjectList = subjectDAO.getThursdaySubjectList();
				teacherList = teacherDAO.getTeacherList();
				categoryList = categoryDAO.getCategoryList();

				//管理者名、全科目Listのデータセット
				session.setAttribute("loginTeacher", teacher);
				request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
				request.setAttribute("thursdaySubjectList", thursdaySubjectList);
				request.setAttribute("teacherList", teacherList);
				request.setAttribute("categoryList", categoryList);

				//遷移先の宣言
				path = "WEB-INF/jsp/TeacherRegister.jsp";
				
			} else {
				System.out.println("ログイン失敗");
			request.setAttribute("loginErrorMessage", "ユーザIDまたはパスワードが違います。");
			//遷移先の宣言
			path = "jsp/TeacherLogin.jsp";
			
			}
			
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);

	}

}
