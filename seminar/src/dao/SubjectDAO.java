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
					+ "WHERE day = '火'";
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
					+ "WHERE day = '木'";
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
	public void insertSubject(String subjectId, String subjectName, String categoryId, String day, String teacherId){
		
	}
	
	//	科目更新
	public void updateSubject(String subjectId, String subjectName, String categoryId, String day, String teacherId){
		
	}
	
	//	科目削除
	public void deleteSubject(String subjectId){
		
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
					+ "FROM (subject "
					+ "INNER JOIN category "
					+ "ON subject.category_id = category.category_id) "
					+ "INNER JOIN attendance "
					+ "ON subject.subject_id = attendance.subject_id "
					+ "INNER JOIN teacher "
					+ "ON subject.teacher_id = teacher.teacher_id "
					+ "WHERE student_id = ?";
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
	public void insertAttendSubject(int studentId, int subjectId) {
		try {
			// DB接続
			connection();
			// SQL文設定の準備・SQL文の実行
			String sql = "INSERT INTO attendance VALUES(?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, studentId);
			stmt.setInt(2, subjectId);
			stmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
	}
	
	//	申込科目削除
	public void deleteAttendSubject(int studentId,int subjectId){
		
	}
}