package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IInfoDAO;
import domain.Info;

public class InfoDAO implements IInfoDAO {
	public static void main(String[] args) {
		Info info = new Info();
		InfoDAO t = new InfoDAO();
//		info.setContent("I love you");
//		info.setPublishingTime("20000807");
		try {
			System.out.println(t.change(11,info));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("wrong!!!!");
			e.printStackTrace();
		}
	}

	@Override
	public boolean addInfo(Info info) throws ClassNotFoundException, SQLException {
		String sql = "Insert into `information` VALUES(?,?,?,?,?,?)";
		Object[] data = { info.getId(), info.getTitle(), info.getContent(), info.getPublishingTime(),
				info.getPublishingUser(), info.getType() };
		DatabaseDAO mydb = new DatabaseDAO();
		int state = mydb.update(sql, data);
		mydb.releaseConnection();
		if (state == 1)
			return true;
		return false;
	}

	@Override
	public boolean removeInfo(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM information WHERE Id = ? ";
		Object[] data = { id };
		DatabaseDAO mydb = new DatabaseDAO();
		int state = mydb.update(sql, data);
		mydb.releaseConnection();
		if (state == 1)
			return true;
		return false;
	}

	@Override
	public List<Info> getInfo(int id) throws ClassNotFoundException, SQLException {
		List<Info> infoList = new ArrayList<>();
		String sql = "select * from information where id=?;";
		Object[] data = { id };
		DatabaseDAO mydb = new DatabaseDAO();
		ResultSet res = mydb.query(sql, data);
		while (res.next()) {
			Info info = new Info();
			info.setTitle(res.getString("Title"));
			info.setContent(res.getString("Content"));
			info.setPublishingTime(res.getTimestamp("PublishingTime"));
			info.setId(res.getInt("Id"));
			info.setPublishingUser(res.getString("PublishingUser"));
			info.setType(res.getString("Type"));
			infoList.add(info);
		}
		mydb.releaseConnection();
		return infoList;
	}

	@Override
	public boolean change(int id, Info info) throws ClassNotFoundException, SQLException {
		String sql = "Update information set Title=?,Content=?,PublishingTime=?,PublishingUser=?,Type=? WHERE Id = ?;";
		Object[] data = { info.getTitle(),info.getContent(),info.getPublishingTime(),info.getPublishingUser(),info.getType(),id };
		DatabaseDAO mydb = new DatabaseDAO();
		int state = mydb.update(sql, data);
		mydb.releaseConnection();
		if (state == 1)
			return true;
		return false;
	}

	@Override
	public List<Info> getAllInfo() throws ClassNotFoundException, SQLException {
		List<Info> infoList = new ArrayList<>();
		String sql = "select * from information;";
		DatabaseDAO mydb = new DatabaseDAO();
		Object[] data = {};
		ResultSet res = mydb.query(sql, data);
		while (res.next()) {
			Info info = new Info();
			info.setTitle(res.getString("Title"));
			info.setContent(res.getString("Content"));
			info.setPublishingTime(res.getTimestamp("PublishingTime"));
			info.setId(res.getInt("Id"));
			info.setPublishingUser(res.getString("PublishingUser"));
			info.setType(res.getString("Type"));
			infoList.add(info);
		}
		mydb.releaseConnection();
		return infoList;
	}

}
