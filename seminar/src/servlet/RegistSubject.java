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

		//＊教師川操作＊
		String path="";
		
		//DAOのインスタンス化
		TeacherDAO teacherDAO = new TeacherDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		SubjectDAO subjectDAO = new SubjectDAO();

		//全科目Listの宣言(火曜、木曜)
		ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
		ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<Category> categoryList = new ArrayList<Category>();

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
				subjectDAO.insertSubject(subjectId, subjectName, categoryId, day, teacherId);
			} catch (Exception e) {
				request.setAttribute("insertRegistErrorMessage","入力内容に誤りがあります。" );
		    }
			
			tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
			thursdaySubjectList = subjectDAO.getThursdaySubjectList();
			teacherList = teacherDAO.getTeacherList();
			categoryList = categoryDAO.getCategoryList();

			//管理者名、全科目Listのデータセット
			request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
			request.setAttribute("thursdaySubjectList", thursdaySubjectList);
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("categoryList", categoryList);
			
			//遷移先の宣言
			path="WEB-INF/jsp/TeacherRegister.jsp";
		break;

		case"delete":

			try{

				int deleteSubjectId = Integer.parseInt(request.getParameter("delete_subject_id"));

				//科目の削除
				subjectDAO.deleteSubject(deleteSubjectId);

			} catch (Exception e) {
				request.setAttribute("deleteRegistErrorMessage","科目の削除に失敗しました。" );
		    }
			
			tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
			thursdaySubjectList = subjectDAO.getThursdaySubjectList();
			teacherList = teacherDAO.getTeacherList();
			categoryList = categoryDAO.getCategoryList();

			//管理者名、全科目Listのデータセット
			request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
			request.setAttribute("thursdaySubjectList", thursdaySubjectList);
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("categoryList", categoryList);
			
			//遷移先の宣言
			path="WEB-INF/jsp/TeacherRegister.jsp";
		break;

		case"list":
			try{

				ArrayList<Student> attendStudentList = new ArrayList<Student>();
				int listSubjectId = Integer.parseInt(request.getParameter("list_subject_id"));
				StudentDAO studentDAO = new StudentDAO();

				//受講者リストの取得
				attendStudentList=studentDAO.getAttendStudentList(listSubjectId);
				request.setAttribute("attendStudentList", attendStudentList);
				path="WEB-INF/jsp/AttendStudent.jsp";

			} catch (Exception e) {
				tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
				thursdaySubjectList = subjectDAO.getThursdaySubjectList();
				teacherList = teacherDAO.getTeacherList();
				categoryList = categoryDAO.getCategoryList();
				
				request.setAttribute("listRegistErrorMessage","受講者リストの取得に失敗しました。" );

				//管理者名、全科目Listのデータセット
				request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
				request.setAttribute("thursdaySubjectList", thursdaySubjectList);
				request.setAttribute("teacherList", teacherList);
				request.setAttribute("categoryList", categoryList);

				//遷移先の宣言
				path = "WEB-INF/jsp/TeacherRegister.jsp";
		    }
		break;

		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher(path);
				rd.forward(request,response);
	}
}
