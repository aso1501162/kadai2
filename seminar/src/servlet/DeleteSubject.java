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
import dao.SubjectDAO;
import dao.TeacherDAO;
import model.Category;
import model.Subject;
import model.Teacher;

@WebServlet("/DeleteSubject")
public class DeleteSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//遷移先の宣言
		String path="";
		
		//DAOのインスタンス化
		TeacherDAO teacherDAO = new TeacherDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		SubjectDAO subjectDAO = new SubjectDAO();

		//削除の処理
		System.out.println("削除はじめ");
		try{

			int deleteSubjectId = Integer.parseInt(request.getParameter("id"));
			
			//科目の削除
			subjectDAO.deleteSubject(deleteSubjectId);
			
			request.setAttribute("message","科目を削除しました。" );

		} catch (Exception e) {
			System.out.println(e);
			
			request.setAttribute("message","科目の削除に失敗しました。" );
	    }
		
		//全科目Listの宣言(火曜、木曜)
		ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
		ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
		//教師Listの宣言
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		//分類Listの宣言
		ArrayList<Category> categoryList = new ArrayList<Category>();

		tuesdaySubjectList = subjectDAO.getTuesdaySubjectList();
		thursdaySubjectList = subjectDAO.getThursdaySubjectList();
		teacherList = teacherDAO.getTeacherList();
		categoryList = categoryDAO.getCategoryList();

		//管理者名、全科目Listのデータセット
		request.setAttribute("tuesdaySubjectList", tuesdaySubjectList);
		request.setAttribute("thursdaySubjectList", thursdaySubjectList);
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("categoryList", categoryList);

		path="WEB-INF/jsp/TeacherRegister.jsp";

		System.out.println("削除おわり");
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
