package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDatabaseDAO {
	Connection conn=null;
	public Connection getConnection()throws SQLException, ClassNotFoundException;
	public int update(String sql,Object[] data)throws SQLException, ClassNotFoundException;
	public ResultSet query(String sql,Object[] data)throws SQLException, ClassNotFoundException;
	public void releaseConnection()throws SQLException, ClassNotFoundException;
}
