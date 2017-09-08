package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.SearchConditionBeans;
import beans.UserBean;
public class UserDao extends DaoUtil{

	/**
	 * Userテーブルに登録された全てのデータを取得する(登録順)
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserBean> findAll() throws SQLException {
		Connection con = DBManager.getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM user order by id DESC");
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

			userList.add(user);
		}

		return userList;
	}

	/**
	 * ユーザを検索する(引数に渡された値が空でないもののみ検索する)
	 * @param loginId
	 * @param userName
	 * @param birthdayFrom
	 * @param birthdayTo
	 * @return
	 * @throws SQLException
	 */
	public List<UserBean> searchUser(String loginId, String userName, String birthdayFrom, String birthdayTo) throws SQLException {
		Connection con = DBManager.getConnection();

		String sql = "SELECT * FROM user";

		// 各種検索要件を設定してSQLを生成
		List<SearchConditionBeans> conditions = new ArrayList<SearchConditionBeans>();
		conditions.add(new SearchConditionBeans("login_id", loginId, WHERE_TYPE_EQUAL));
		conditions.add(new SearchConditionBeans("name", userName, WHERE_TYPE_LIKE_PARTIAL_MATCH));
		conditions.add(new SearchConditionBeans("birth_date", birthdayFrom, WHERE_TYPE_GENDER_OR_EQUAL));
		conditions.add(new SearchConditionBeans("birth_date", birthdayTo, WHERE_TYPE_LESS_OR_EQUAL));
		sql = addWhereCondition(sql, conditions);

		// IDの降順に表示
		sql += " order by id desc";

		// TODO デバッグ用(納品時に消す)
		System.out.println(sql);

		PreparedStatement st = con.prepareStatement(sql);
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
			userList.add(user);
		}

		return userList;

	}


}
