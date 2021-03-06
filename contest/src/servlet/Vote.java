package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.StudentDAO;
import dao.VoteDAO;


@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//投票のためのサーブレット
		System.out.println("Vote");
		String path = "";

		//jspから値の受け取り
		String studentId = request.getParameter("number");
		String birthday = request.getParameter("birthday");
		int postId = Integer.parseInt(request.getParameter("postid"));
		Boolean checkStudentFlug;

		//インスタンス化
		StudentDAO studentDAO = new StudentDAO();
		checkStudentFlug = studentDAO.checkStudentId(studentId,birthday);

		//初回の投票時のみ実行
		if(checkStudentFlug){
			Boolean checkVoteFlug;

			VoteDAO voteDAO = new VoteDAO();
			checkVoteFlug = voteDAO.checkStudentId(studentId);

			if(checkVoteFlug){
				String comment = request.getParameter("comment");

				CommentDAO commentDAO = new CommentDAO();
				commentDAO.addComment(postId,comment);
			}
		}else{
			request.setAttribute("message","1度投票されているアカウントです。");
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

}
