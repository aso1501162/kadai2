package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import dao.SubjectDAO;
import dao.TeacherDAO;
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
		System.out.println("Login.javaを通った");
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session=request.getSession();
		String Path = null;

		//学生ログイン
		String password=request.getParameter("password");
		if(request.getParameter("studentid")!=null){

			String studentid = request.getParameter("studentid");

			//DAOのインタンス化
			StudentDAO studentDAO = new StudentDAO();
			SubjectDAO subjectDAO = new SubjectDAO();

			Student student=studentDAO.getStudent(studentid,password);

			//受講科目Listの宣言
			List<Subject> attendSubjectList = new ArrayList<Subject>();
			attendSubjectList = subjectDAO.getAttendSubjectList(student.getStudentId());

			//全科目Listの宣言
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectList = subjectDAO.getSubjectList();

			//生徒名、受講科目List、全科目Listのデータセット
			session.setAttribute("student", student);
			session.setAttribute("attendSubjectList", attendSubjectList);
			request.setAttribute("subjectList", subjectList);




			//遷移先の宣言
			Path="xxxxxxxxxx.jsp";
		}
		//管理者ログイン
		if(request.getParameter("teacherid")!=null){

			String teacherid=request.getParameter("teacherid");

			//DAOのインスタンス化
			TeacherDAO tDAO=new TeacherDAO();
			SubjectDAO subjectDAO = new SubjectDAO();

			Teacher teacher=tDAO.getTeacher(teacherid,password);

			//全科目Listの宣言
			List<Subject> subjectList = new ArrayList<Subject>();
			subjectList = subjectDAO.getSubjectList();

			//管理者名、全科目Listのデータセット
			session.setAttribute("teacher", teacher);
			request.setAttribute("subjectList", subjectList);

			//遷移先の宣言
			Path="xxxxxxxxxx.jsp";
		}
		RequestDispatcher rd=
				request.getRequestDispatcher(Path);
				rd.forward(request,response);

	}

}
