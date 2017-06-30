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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//遷移先の宣言
		String path="";

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("loginStudent");
		int studentId = student.getStudentId();

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込の処理
		try{
			
			if (request.getParameter("tue") != null) {
				int tueSubjectId = Integer.parseInt(request.getParameter("tue"));
				//科目登録
				subjectDAO.insertAttendSubject(studentId,tueSubjectId);
			}
			
			if (request.getParameter("thu") != null) {
				int thuSubjectId = Integer.parseInt(request.getParameter("thu"));
				//科目登録
				subjectDAO.insertAttendSubject(studentId,thuSubjectId);
			}
			
			request.setAttribute("message","科目を申し込みました。" );
		} catch (Exception e) {
			request.setAttribute("message","科目の申込に失敗しました。" );
		}
		
		//受講科目Listの宣言
		ArrayList<Subject> attendSubjectList = new ArrayList<Subject>();
		//全科目Listの宣言(火曜、木曜)
		ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
		ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();

		attendSubjectList = subjectDAO.getAttendSubjectList(student.getStudentId());
		tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
		thursdaySubjectList = subjectDAO.getThursdaySubjectList();

		if(attendSubjectList.size()<2){
			request.setAttribute("errorMessage", "火曜日と木曜日からそれぞれ１科目申し込んでください。");
		}

		//受講科目List、全科目Listのデータセット
		request.setAttribute("attendSubjectList", attendSubjectList);
		request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
		request.setAttribute("thursdaySubjectList", thursdaySubjectList);

		path = "WEB-INF/jsp/StudentRegister.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}
}
