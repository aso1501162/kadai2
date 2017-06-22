package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDAO;

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

		//科目を取得
		String subjectId = request.getParameter("subject_id");
		String categoryId = request.getParameter("category_id");
		String subjectName = request.getParameter("subject_name");
		String teacherId = request.getParameter("teacher_id");
		String day = request.getParameter("day");

		//インスタンス化
		SubjectDAO subjectDAO = new SubjectDAO();

		//申込、削除の処理
		switch(request.getParameter("action")){

		case"insert":
			//未入力欄の確認
			try {
				Integer.parseInt(subjectId);
				if(subjectId.equals("")||
				   teacherId.equals("")||
				   day.equals("")){
					throw new Exception();
				}
			} catch (Exception e) {
				request.setAttribute("registErrorMessage","入力内容に誤りがあります。" );
				break;
		    }
			subjectDAO.insertSubject(subjectId, subjectName, categoryId, day, teacherId);
			break;

		case"delete":
			subjectDAO.deleteSubject(subjectId);
			break;
		default:
		}

		RequestDispatcher rd=
				request.getRequestDispatcher("WEB-INF/jsp/TeacherRegister.jsp");
				rd.forward(request,response);
	}

}
