package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Category;

public class CategoryDAO {
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
	
	// 科目分類リストの取得
public ArrayList<Category> getCategoryList() {
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		try {
			// DB接続
			connection();

			// SQL文設定の準備・SQL文の実行
			String sql =
					"SELECT * "
					+ "FROM category "
					+ "ORDER BY category_id";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(); // sql文を実行
			
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				Category category = new Category();
				
				System.out.println("科目分類："+rs.getString("category_name") + "を取得");

				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));

				categoryList.add(category);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				close();
			} catch (Exception e) {

			}
		}
		return categoryList;
	}
}