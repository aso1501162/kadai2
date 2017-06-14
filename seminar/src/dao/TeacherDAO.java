package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Teacher;

public class TeacherDAO {
	// データソース
	DataSource ds = null;
	// データベース接続情報
	Connection con = null;
	// プリコンパイル用のステートメント
	PreparedStatement stmt = null;
	// SELECTの結果を格納するResultSet
	ResultSet rs = null;

	// データベース接続
	public Connection connection() throws Exception {
		// データソースがなければ、context.xmlから読み込んで設定する
		if (ds == null) {
			ds = (DataSource) (new InitialContext()).lookup("java:comp/env/jdbc/MySQL");
		}
		con = ds.getConnection();
		return con;
	}

	// データベース切断
	public void close() throws Exception {
		// データベース接続されていれば、切断する
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	
	// 管理者情報の取得
	public Teacher getTeacher(String teacherId, String password) {
		Teacher teacher = new Teacher();

		try {
			// DB接続
			connection();
			
			// SQL文設定の準備・SQL文の実行
			String sql = "SELECT * FROM teacher WHERE student_id=? AND password=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(teacherId));
			stmt.setString(2, password);
			rs = stmt.executeQuery(); // sql文を実行

			// 1件目のデータにカーソルを合わせる
			// データない場合はcatchに飛ぶ
			rs.next();

			//	DBから取得したデータをuserオブジェクトに格納
			teacher.setTeacherId(rs.getInt("id"));
			teacher.setTeacherName(rs.getString("name"));
			teacher.setPassword(rs.getString("password"));

		} catch (Exception e) {
			// ログイン失敗
			teacher = null;
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return teacher;
	}
}