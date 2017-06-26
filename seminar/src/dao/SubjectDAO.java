package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Subject;

public class SubjectDAO {
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

	//	データベース切断
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
	
	//	火曜日の科目リスト取得
	public ArrayList<Subject> getTuesdaySubjectList() {
		
		ArrayList<Subject> tuesdaySubjectList = new ArrayList<Subject>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM subject "
					+ "INNER JOIN category "
					+ "ON subject.category_id = category.category_id "
					+ "INNER JOIN teacher "
					+ "ON subject.teacher_id = teacher.teacher_id "
					+ "WHERE day = '火' "
					+ "ORDER BY subject_id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql文を実行
			
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				Subject subject = new Subject();
				
				System.out.println("火曜日の科目："+rs.getString("subject_name") + "を取得");

				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setCategoryId(rs.getInt("category_id"));
				subject.setDay(rs.getString("day"));
				subject.setCategoryName(rs.getString("category_name"));
				subject.setTeacherId(rs.getInt("teacher_id"));
				subject.setTeacherName(rs.getString("teacher_name"));

				tuesdaySubjectList.add(subject);
			}
		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return tuesdaySubjectList;
	}
	
//	木曜日の科目リスト取得
	public ArrayList<Subject> getThursdaySubjectList() {
		
		ArrayList<Subject> thursdaySubjectList = new ArrayList<Subject>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM subject "
					+ "INNER JOIN category "
					+ "ON subject.category_id = category.category_id "
					+ "INNER JOIN teacher "
					+ "ON subject.teacher_id = teacher.teacher_id "
					+ "WHERE day = '木' "
					+ "ORDER BY subject_id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql文を実行
			
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				Subject subject = new Subject();
				
				System.out.println("木曜日の科目："+rs.getString("subject_name") + "を取得");

				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setCategoryId(rs.getInt("category_id"));
				subject.setDay(rs.getString("day"));
				subject.setCategoryName(rs.getString("category_name"));
				subject.setTeacherId(rs.getInt("teacher_id"));
				subject.setTeacherName(rs.getString("teacher_name"));

				thursdaySubjectList.add(subject);
			}
		} catch (Exception e) {
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return thursdaySubjectList;
	}
	
	//	科目登録
	public void insertSubject(int subjectId, String subjectName, int categoryId, String day, int teacherId) throws Exception {
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "INSERT INTO subject "
					+ "VALUES (?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subjectId);
			stmt.setString(2, subjectName);
			stmt.setInt(3, categoryId);
			stmt.setString(4, day);
			stmt.setInt(4, teacherId);
			stmt.executeUpdate();
			
			System.out.println("---------------------------------");
			System.out.println("科目："+ subjectName + "を登録");
			
		} catch (Exception e) {

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}	
	}
	
	//	科目削除
	public void deleteSubject(int subjectId) throws Exception {
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "DELETE FROM subject "
					+ "WHERE subject_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, subjectId);
			
			System.out.println("delete");
			
			stmt.executeUpdate();
			
			System.out.println("---------------------------------");
			System.out.println("科目："+ subjectId + "を削除");
			
		} catch (Exception e) {

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}
	
	//	申込科目リスト取得
	public ArrayList<Subject> getAttendSubjectList(int studentId) {
		
		ArrayList<Subject> attendSubjectList = new ArrayList<Subject>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM subject "
					+ "INNER JOIN category "
					+ "ON subject.category_id = category.category_id "
					+ "INNER JOIN attendance "
					+ "ON subject.subject_id = attendance.subject_id "
					+ "INNER JOIN teacher "
					+ "ON subject.teacher_id = teacher.teacher_id "
					+ "WHERE student_id = ? "
					+ "ORDER BY subject.subject_id";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			rs = stmt.executeQuery(); // sql文を実行
			
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				Subject subject = new Subject();
				
				System.out.println("学生の申込科目："+rs.getString("subject_name") + "を取得");

				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setCategoryId(rs.getInt("category_id"));
				subject.setDay(rs.getString("day"));
				subject.setCategoryName(rs.getString("category_name"));
				subject.setTeacherId(rs.getInt("teacher_id"));
				subject.setTeacherName(rs.getString("teacher_name"));

				attendSubjectList.add(subject);
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

	// 申込科目登録
	public void insertAttendSubject(int studentId, int subjectId) throws Exception {
		try {
			// DB接続
			connection();
			
			// SQL文設定の準備・SQL文の実行
			//	同じ学生が既に登録している同じ曜日の申込科目を取得する
			String selectMatchDaySQL = "SELECT attendance.subject_id subjectid "
					+ "FROM attendance "
					+ "INNER JOIN subject "
					+ "ON attendance.subject_id = subject.subject_id "
					+ "WHERE student_id = ? "
					+ "AND day = "
					+ "(SELECT day "
					+ "FROM subject "
					+ "WHERE subject_id = ?)";
			stmt = con.prepareStatement(selectMatchDaySQL);
			stmt.setInt(1, studentId);
			stmt.setInt(2, subjectId);
			
			System.out.println("insert");
			
			stmt.executeUpdate();
			
			
			
			System.out.println("---------------------------------");
			
			if (rs.next()) {
				//	同じ曜日の申込科目が存在する
				
				int previousSubjectId = rs.getInt("subject_id");
				
				//	申込科目を置き換える
				String updateSQL =  "UPDATE attendance "
						+ "SET subject_id = ?"
						+ "WHERE student_id = ? "
						+ "AND subject_id = ?";
				stmt = con.prepareStatement(updateSQL);
				stmt.setInt(1, subjectId);
				stmt.setInt(2, studentId);
				stmt.setInt(3, previousSubjectId);
				stmt.executeUpdate();
				
				System.out.println("学生の申込科目："+ subjectId + "を登録");
				
			} else {
				//	同じ曜日の申込科目が存在しない
				//	申込科目を追加する
				String insertSQL =  "INSERT INTO attendance "
						+ "VALUES (?,?)";
				stmt = con.prepareStatement(insertSQL);
				stmt.setInt(1, studentId);
				stmt.setInt(2, subjectId);
				stmt.executeUpdate();
				
				System.out.println("学生の申込科目："+ subjectId + "を登録");
				
			}
		} catch (Exception e) {

			System.out.println(e);

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}
	
	//	申込科目削除
	public void deleteAttendSubject(int studentId,int subjectId) throws Exception {
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "DELETE FROM attendance "
					+ "WHERE student_id = ? "
					+ "AND subject_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			stmt.setInt(2, subjectId);
			
			System.out.println("delete");
			
			stmt.executeUpdate();
			
			System.out.println("---------------------------------");
			System.out.println("学生の申込科目："+ subjectId + "を削除");
			
		} catch (Exception e) {
			
			System.out.println(e);

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}
}