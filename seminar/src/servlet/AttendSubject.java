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

import dao.SubjectDAO;
import model.Student;
import model.Subject;

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

		//＊学生側操作＊
		String path="";

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("loginStudent");
		int studentId = student.getStudentId();

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込、削除の処理
		switch(request.getParameter("action")){
		case"insert":
			try{

				if (request.getParameter("tue") != null) {
					int tueSubjectId = Integer.parseInt(request.getParameter("tue"));
					System.out.println(tueSubjectId);
					//科目登録
					subjectDAO.insertAttendSubject(studentId,tueSubjectId);
				}
				
				if (request.getParameter("thu") != null) {
					int thuSubjectId = Integer.parseInt(request.getParameter("thu"));
					System.out.println(thuSubjectId);
					//科目登録
					subjectDAO.insertAttendSubject(studentId,thuSubjectId);
				}
				
				

			} catch (Exception e) {
				request.setAttribute("insertAttendErrorMessage","科目の申込に失敗しました。" );
		    }
				break;

		case"delete":
			try{

				System.out.println("削除： "+request.getParameter("delete_attend_subject_id"));
				
				//科目の取得
				int deleteAttendSubjectId = Integer.parseInt(request.getParameter("delete_attend_subject_id"));

				//科目の削除
				subjectDAO.deleteAttendSubject(studentId,deleteAttendSubjectId);

			} catch (Exception e) {
				request.setAttribute("deleteAttendErrorMessage","申込科目の削除に失敗しました。" );
			}
				break;

				default:
			}

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
		path = "WEB-INF/jsp/StudentRegister.jsp";

		RequestDispatcher rd=
				request.getRequestDispatcher(path);
				rd.forward(request,response);
	}
}
