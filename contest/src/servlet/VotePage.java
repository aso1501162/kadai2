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
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//投票画面を表示するためのサーブレット
		String path = "top.jsp";

		//投票画面表示
		ArrayList<Post> postList = new ArrayList<Post>();

		//インスタンス化
		PostDAO postDAO = new PostDAO();
		postList = postDAO.getPostList();

		//投稿作品情報のセット
		request.setAttribute("postList", postList);

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

}
