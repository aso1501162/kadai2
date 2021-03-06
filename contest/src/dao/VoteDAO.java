package dao;

import java.util.ArrayList;

public class VoteDAO extends CommonDAO {

	//	投票追加
	public void addVote(String studentId, int postId) {
		System.out.println("---------------投票追加---------------");

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"INSERT INTO vote "
					+ "(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			stmt.setInt(2, postId);
			stmt.executeUpdate(); // sql文を実行

			System.out.println(studentId + " が " +  postId + " に投票");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}

	//	投票数取得
	public int getVotes(int postId) {
		System.out.println("---------------投票数取得---------------");
		int votes = 0;

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT COUNT(*) votes "
					+ "FROM vote "
					+ "WHERE post_id = ? "
					+ "GROUP BY post_id";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, postId);
			rs = stmt.executeQuery(); // sql文を実行

			if (rs.next()) {
				System.out.println("投票数：" + rs.getInt("votes") + " を取得");

				votes = rs.getInt("votes");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return votes;
	}

	//	投票学生の重複チェック
	public boolean checkStudentId(String studentId) {
		System.out.println("---------------投票学生の重複チェック---------------");

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM vote"
					+ "WHERE student_id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			rs = stmt.executeQuery(); // sql文を実行

			return rs.next();

		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}

	//	投票数上位の投稿取得
	public ArrayList<Integer> getTopPostIdList(int num) {
		System.out.println("---------------投票数上位の投稿ID取得---------------");
		ArrayList<Integer> topPostIdList = new ArrayList<Integer>();

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT post_id, COUNT(*) "
					+ "FROM vote "
					+ "GROUP BY post_id "
					+ "ORDER BY COUNT(*) DESC "
					+ "LIMIT ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, num);
			rs = stmt.executeQuery(); // sql文を実行

			while (rs.next()) {
				System.out.println(rs.getInt("post_id"));
				topPostIdList.add(rs.getInt("post_id"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return topPostIdList;
	}
}