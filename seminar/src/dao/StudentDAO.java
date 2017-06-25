package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Student;

public class StudentDAO {
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

	// 学生の取得
	public Student getStudent(String studentId, String password) {
		Student student = new Student();

		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM student "
					+ "INNER JOIN class "
					+ "ON student.class_id = class.class_id "
					+ "WHERE student_id=? "
					+ "AND password=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(studentId));
			stmt.setString(2, password);
			rs = stmt.executeQuery(); // sql文を実行

			// 1件目のデータにカーソルを合わせる
			// データない場合はcatchに飛ぶ
			rs.next();

			//	DBから取得したデータをuserオブジェクトに格納
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setPassword(rs.getString("password"));
			student.setClassId(rs.getInt("class_id"));
			student.setClassName(rs.getString("class_name"));

		} catch (Exception e) {
			// ログイン失敗
			student = null;
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return student;
	}
	
	//	申込学生リスト取得
	public ArrayList<Student> getAttendStudentList(int subjectId) {
		
		ArrayList<Student> attendSubjectList = new ArrayList<Student>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM student "
					+ "INNER JOIN class "
					+ "ON student.class_id = class.class_id "
					+ "INNER JOIN attend "
					+ "ON student.studentid = attend.student_id "
					+ "WHERE subject_id = ? "
					+ "ORDER BY student.student_id";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subjectId);
			rs = stmt.executeQuery(); // sql文を実行
			
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				Student student = new Student();
				
				System.out.println("申込学生："+rs.getString("student_name") + "を取得");

				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setPassword(rs.getString("password"));
				student.setClassId(rs.getInt("class_id"));
				student.setClassName(rs.getString("class_name"));

				attendSubjectList.add(student);
				
			}
		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return attendSubjectList;
	}

}