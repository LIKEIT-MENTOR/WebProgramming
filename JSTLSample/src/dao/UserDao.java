package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.UserBean;
public class UserDao {

	/**
	 * Userテーブルに登録された全てのデータを取得する(登録順)
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserBean> findAll() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM user ORDER BY id DESC");
			ResultSet rs = st.executeQuery();

			ArrayList<UserBean> userList = new ArrayList<UserBean>();

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setLoginId(rs.getString("login_id"));
				user.setName(rs.getString("name"));
				user.setBirthDate(rs.getDate("birth_date"));
				user.setPassword(rs.getString("password"));
				user.setCreateDate(rs.getTimestamp("create_date"));
				user.setCreateDate(rs.getTimestamp("update_date"));
			}

			return userList;

		} catch (SQLException e) {
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
