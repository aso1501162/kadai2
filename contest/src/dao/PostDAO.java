package dao;

import java.util.ArrayList;

import model.Post;

public class PostDAO extends CommonDAO {
	
	//	投稿取得
	public Post getPost(int postId) {
		System.out.println("---------------投稿取得---------------");
		Post post = new Post();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM post "
					+ "WHERE post_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, postId);
			rs = stmt.executeQuery(); // sql文を実行
			
			rs.next();
			
			System.out.println("投稿：" + rs.getString("title") + " を取得");

			post.setPostId(rs.getInt("post_id"));
			post.setFileName(rs.getString("file_name"));
			post.setTitle(rs.getString("title"));
			post.setCommentList(new CommentDAO().getCommentList(rs.getInt("post_id")));
			post.setVotes(new VoteDAO().getVotes(rs.getInt("post_id")));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return post;
	}
	
	//	投稿リスト取得
	public ArrayList<Post> getPostList() {
		System.out.println("---------------投稿リスト取得---------------");
		ArrayList<Post> postList = new ArrayList<Post>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM post";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql文を実行
			
			ArrayList<Integer> postIdList = new ArrayList<Integer>();
			while (rs.next()) {
				postIdList.add(rs.getInt("post_id"));
			}
			
			for (int postId : postIdList) {
				Post post = new Post();
				
				post = getPost(postId);
				
				postList.add(post);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return postList;
	}
	
	//	投票数上位の投稿取得
	public ArrayList<Post> getTopPostList(int num) {
		System.out.println("---------------投票数上位の投稿取得---------------");
		ArrayList<Post> topPostList = new ArrayList<Post>();
		
		try {
			// DB接続
			connection();

			ArrayList<Integer> topPostIdList = new ArrayList<Integer>();
			
			VoteDAO voteDAO = new VoteDAO();
			topPostIdList = voteDAO.getTopPostIdList(num);
			
			for (int postId :topPostIdList) {
				Post post = new Post();
				
				post = getPost(postId);
				
				topPostList.add(post);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return topPostList;
	}
	
}