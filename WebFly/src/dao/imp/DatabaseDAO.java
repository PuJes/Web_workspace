package dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IDatabaseDAO;

public class DatabaseDAO implements IDatabaseDAO {
	Connection conn = null;

	public static void main(String[] args) {
		DatabaseDAO example1 = new DatabaseDAO();
		String sql = "select * from users where id>=?;";
		Object[] data = { "1:" };
		try {
//			int res = example1.update(sql);
			ResultSet res = example1.query(sql, data);// 这里虽然把结果对象付给了res，但是对象依然是那个对象，只是引用者不同了而已，因此无法释放连接，因为那个对象必须依赖连接
			while (res.next()) {
				int id = res.getInt("id");
				String username = res.getString("username");
				String password = res.getString("password");
				int age = res.getInt("age");
				System.out.println(id + " " + username + " " + password + " " + age);
			}
			example1.releaseConnection();

		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not find");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql wrong");
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName);
		String DB_URL = "jdbc:mysql://localhost:3306/community?user=root&password=123456zxcvbn&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
		this.conn = DriverManager.getConnection(DB_URL);
		return conn;
	}
	
	/**
	 * query method: PreparedStatement ? only use on parameters, can not use on property and table 
	 */
	public int update(String sql, Object[] data) throws SQLException, ClassNotFoundException {
		conn = getConnection();
		PreparedStatement stnt = conn.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			stnt.setObject(i + 1, data[i]);
		}
		System.out.println(stnt.toString());
		int res = stnt.executeUpdate();
		return res;
	}

	/**
	 * query method: PreparedStatement ? only use on parameters, can not use on property and table 
	 */
	public ResultSet query(String sql, Object[] data) throws SQLException, ClassNotFoundException {
		conn = getConnection();
		PreparedStatement stnt = conn.prepareStatement(sql);
		for (int i = 0; i < data.length; i++) {
			stnt.setObject(i + 1, data[i]);
		}
		System.out.println(stnt.toString());
		ResultSet res = stnt.executeQuery();
		return res;
	}

	public void releaseConnection() throws SQLException {
		if(this.conn!=null) {
			this.conn.close();
		}
		this.conn = null;
		System.out.println(this.toString()+" conn has been released");
	}

}
