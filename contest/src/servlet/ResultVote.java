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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//結果画面表示のサーブレット

		ArrayList<Integer> getPostId = new ArrayList<Integer>();
		ArrayList<Post> arrayPost = new ArrayList<Post>();

		//インスタンス化
		PostDAO postDAO = new PostDAO();
		Post post = new Post();

		//DAOから上位3位のpostIdを取得
		getPostId = xxDAO.xxxxxx();

		//DAOから上位3作品の情報を取得
		for(int postId : getPostId){
		post = postDAO.getPost(postId);
		arrayPost.add(post);
		}

		request.setAttribute("arrayPost", arrayPost);

		RequestDispatcher rd = request.getRequestDispatcher(xxxxx);
		rd.forward(request,response);
	}

}
