package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;

/**
 * DBの接続情報インスタンスを作成する
 */
public class DBManager {

	// DBへの接続ユーザ
	private final static String USER = "root";
	// DBへの接続パスワード
	private final static String PASSWORD = "password";
	// 接続先DB名称
	private final static String DB = "sample";

	/**
	 * DBに接続してコネクションインスタンスを返す
	 * @return コネクションインスタンス
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					MessageFormat.format("jdbc:mysql://localhost:3306/{0}?useUnicode=true&characterEncoding=utf8",DB)
					, USER
					, PASSWORD
					);
			return con;
		} catch (ClassNotFoundException e) {
			throw new IllegalMonitorStateException();
		} catch (SQLException e) {
			throw new IllegalMonitorStateException();
		}
	}
}
