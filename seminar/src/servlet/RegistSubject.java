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

import dao.StudentDAO;
import dao.SubjectDAO;
import model.Student;
import model.Subject;

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
				request.setAttribute("insertRegistErrorMessage","入力内容に誤りがあります。" );
		    }
			//遷移先の宣言
			path="WEB-INF/jsp/TeacherRegister.jsp";
		break;

		case"delete":

			try{

				int deleteSubjectId = Integer.parseInt(request.getParameter("delete_subject_id"));
				SubjectDAO subjectDAO = new SubjectDAO();

				//科目の削除
				subjectDAO.deleteSubject(deleteSubjectId);

			} catch (Exception e) {
				request.setAttribute("deleteRegistErrorMessage","科目の削除に失敗しました。" );
		    }
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
				request.setAttribute("listRegistErrorMessage","受講者リストの取得に失敗しました。" );

				SubjectDAO subjectDAO = new SubjectDAO();
				HttpSession session = request.getSession();
				Student student = (Student)session.getAttribute("student");

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
				session.setAttribute("attendSubjectList", attendSubjectList);
				request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
				request.setAttribute("thursdaySubjectList", thursdaySubjectList);

				//遷移先の宣言
				path="WEB-INF/jsp/TeacherRegister.jsp";
		    }
		break;

		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher(path);
				rd.forward(request,response);
	}
}
