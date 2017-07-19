package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAO;
import model.Post;

@WebServlet("/VotePage")
public class VotePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//投票画面表示
		ArrayList<Post> getPostList = new ArrayList<Post>();

		//インスタンス化
		PostDAO postDAO = new PostDAO();
		getPostList = postDAO.getPostList();

		//投稿作品情報のセット
		request.setAttribute("getPostList", getPostList);

		RequestDispatcher rd = request.getRequestDispatcher(xxxx);
		rd.forward(request,response);


	}

}
