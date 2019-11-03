package service.imp;

import java.sql.SQLException;
import java.util.List;

import com.MyException;

import dao.imp.InfoDAO;
import domain.Info;
import service.IInfoService;

public class InfoService implements IInfoService {
	public static void main(String[] args) {
		Info info = new Info();
		info.setTitle("test1");
		InfoService infoService = new InfoService();
		try {
			System.out.println(infoService.newInfo(info));
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean newInfo(Info info) throws MyException {
		if (info == null) {
			throw new MyException("info is null");
		}
		InfoDAO infoDAO = new InfoDAO();
		boolean state;
		try {
			state = infoDAO.addInfo(info);
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("cannot do the add operater");
		}
		return state;
	}

	@Override
	public boolean deleteInfo(int id) throws MyException {
		if (id < 0) {
			throw new MyException("id is wrong");
		}
		InfoDAO infoDAO = new InfoDAO();
		boolean state;
		try {
			state = infoDAO.removeInfo(id);
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("cannot do the delete operater");
		}
		return state;
	}

	@Override
	public Info getInfo(int id) throws MyException {
		if (id < 0) {
			throw new MyException("id is wrong");
		}
		InfoDAO infoDAO = new InfoDAO();
		List<Info> infos;
		try {
			infos = infoDAO.getInfo(id);
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("cannot do the get operater");
		}
		Info info = infos.size() == 0 ? null : infos.get(0);
		return info;
	}

	@Override
	public List<Info> getAllInfo() throws MyException {
		InfoDAO infoDAO = new InfoDAO();
		List<Info> infos;
		try {
			infos = infoDAO.getAllInfo();
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("cannot do the getAll operater");
		}
		return infos;
	}

	@Override
	public boolean changeInfo(int id,Info info) throws MyException {
		if (id < 0) {
			throw new MyException("id is wrong");
		}
		if (info == null) {
			throw new MyException("info is null");
		}
		InfoDAO infoDAO = new InfoDAO();
		boolean state;
		try {
			state = infoDAO.change(id, info);
		} catch (ClassNotFoundException | SQLException e) {
			throw new MyException("cannot do the update operater");
		}
		return state;
	}

}
