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

@WebServlet("/DeleteAttendance")
public class DeleteAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//遷移先の宣言
		String path="";

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("loginStudent");
		int studentId = student.getStudentId();

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//削除の処理
		try{
			//科目の取得
			int deleteAttendSubjectId = Integer.parseInt(request.getParameter("id"));

			//科目の削除
			subjectDAO.deleteAttendSubject(studentId,deleteAttendSubjectId);
			
			request.setAttribute("message","申込科目を削除しました。" );
		} catch (Exception e) {
			request.setAttribute("message","申込科目の削除に失敗しました。" );
		}
		
		//受講科目Listの宣言
		ArrayList<Subject> attendSubjectList = new ArrayList<Subject>();
		//全科目Listの宣言(火曜、木曜)
		ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
		ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();

		attendSubjectList = subjectDAO.getAttendSubjectList(studentId);
		tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
		thursdaySubjectList = subjectDAO.getThursdaySubjectList();
	
		if(attendSubjectList.size()<2){
			request.setAttribute("attendErrorMessage", "火曜日と木曜日からそれぞれ１科目申し込んでください。");
		}
	
		//受講科目List、全科目Listのデータセット
		request.setAttribute("attendSubjectList", attendSubjectList);
		request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
		request.setAttribute("thursdaySubjectList", thursdaySubjectList);

		//遷移先の宣言
		path = "WEB-INF/jsp/StudentRegister.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
