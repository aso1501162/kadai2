package dao;

public class VoteDAO extends CommonDAO {
	
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
			
			System.out.println("投票数：" + rs.getInt("votes") + " を取得");
			
			votes = rs.getInt("votes");
			
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
}