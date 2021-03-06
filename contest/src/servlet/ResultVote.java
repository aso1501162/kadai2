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

@WebServlet("/ResultVote")
public class ResultVote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//結果画面表示のサーブレット

		String path = "result.jsp";
		int num = 3;

		//投票画面表示
		ArrayList<Post> rankPostList = new ArrayList<Post>();

		//インスタンス化
		PostDAO postDAO = new PostDAO();
		rankPostList = postDAO.getTopPostList(num);

		//投稿作品情報のセット
		request.setAttribute("rankPostList", rankPostList);

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
