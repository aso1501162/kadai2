package dao;

import java.util.ArrayList;

public class CommentDAO extends CommonDAO {
	
	//	コメント追加
	public void addComment(int postId, String comment) {
		System.out.println("---------------コメント追加---------------");
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"INSERT INTO comment "
					+ "(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, postId);
			stmt.setString(2, comment);
			stmt.executeUpdate(); // sql文を実行
			
			System.out.println(postId + " に " +  comment + " をコメント");
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}
	
	//	コメントリスト取得
	public ArrayList<String> getCommentList(int postId) {
		System.out.println("---------------コメントリスト取得---------------");
		ArrayList<String> commentList = new ArrayList<String>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM comment "
					+ "WHERE post_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, postId);
			rs = stmt.executeQuery(); // sql文を実行
			
			while (rs.next()) {
				System.out.println("投稿：" + rs.getString("comment") + " を取得");

				commentList.add(rs.getString("comment"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return commentList;
	}
	
}