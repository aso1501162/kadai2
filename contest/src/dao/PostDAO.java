package dao;

import java.util.ArrayList;

import model.Post;

public class PostDAO extends CommonDAO {
	
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
					+ "FROM post "
					+ "ORDER BY subject_id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql文を実行
			
			while (rs.next()) {
				Post post = new Post();
				
				System.out.println("投稿：" + rs.getString("title") + " を取得");

				post.setPostId(rs.getInt("post_id"));
				post.setFileName(rs.getString("file_name"));
				post.setTitle(rs.getString("title"));
				post.setCommentList(getCommentList(rs.getInt("post_id")));
				post.setVotes(getVotes(rs.getInt("post_id")));

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
	
}