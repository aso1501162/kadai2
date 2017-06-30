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

@WebServlet("/RegistSubject")
public class RegistSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//遷移先の宣言
		String path="";

		//DAOのインスタンス化
		TeacherDAO teacherDAO = new TeacherDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
		SubjectDAO subjectDAO = new SubjectDAO();

		//登録の処理
		try {

			//科目を取得
			int subjectId = Integer.parseInt(request.getParameter("subject_id"));
			String subjectName = request.getParameter("subject_name");
			int categoryId = Integer.parseInt(request.getParameter("category_id"));
			String day = request.getParameter("day");
			int teacherId = Integer.parseInt(request.getParameter("teacher_id"));

			//未入力欄の確認
			if(subjectName.equals("")||
			   day.equals("")){
				throw new Exception();
			}

			//科目登録
			subjectDAO.insertSubject(subjectId, subjectName, categoryId, day, teacherId);

			request.setAttribute("message","科目を登録しました。" );

		} catch (Exception e) {
			System.out.println(e);

			request.setAttribute("message","入力内容に誤りがあります。" );
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

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}
}
