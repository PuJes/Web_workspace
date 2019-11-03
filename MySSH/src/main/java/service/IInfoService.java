package service;

import java.util.List;

import entity.Information;

public interface IInfoService {
	public void addInfo(Information information);

	public void deleteInfo(Information information);

	public void updateInfo(Information information);

	public Information getInfoByID(String id);

	public List<Information> getAllInfo();
}
