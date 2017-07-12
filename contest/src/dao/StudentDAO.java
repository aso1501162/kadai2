package dao;

public class StudentDAO extends CommonDAO {

	//	学生ID重複チェック
	public boolean checkStudentId(String studentId, String birthday) {
		System.out.println("---------------学籍番号、生月日チェック---------------");

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM student "
					+ "WHERE post_id = ? "
					+ "GROUP BY post_id";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			stmt.setString(2, birthday);
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