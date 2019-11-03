package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Info;

public interface IInfoDAO {
	public boolean addInfo(Info info)throws ClassNotFoundException, SQLException;
	public boolean removeInfo(int id)throws ClassNotFoundException, SQLException;
	public List<Info> getInfo(int id)throws ClassNotFoundException, SQLException;
	public boolean change(int id,Info info)throws ClassNotFoundException, SQLException;
	public List<Info> getAllInfo()throws ClassNotFoundException, SQLException;
}
