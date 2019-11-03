package service;

import java.util.List;

import com.MyException;

import domain.Info;

public interface IInfoService {
	public boolean newInfo(Info info) throws MyException;

	public boolean deleteInfo(int id) throws MyException;

	public Info getInfo(int id) throws MyException;

	public List<Info> getAllInfo() throws MyException;

	public boolean changeInfo(int id, Info info) throws MyException;

}
