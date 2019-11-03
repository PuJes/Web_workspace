package service.imp;

import java.util.List;

import dao.IInfoDAO;
import entity.Information;
import service.IInfoService;

public class InfoService implements IInfoService{

	private IInfoDAO infoDAO;
	
	public InfoService() {
	}
	
	public void setInfoDAO(IInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	
	public InfoService(IInfoDAO infoDAO) {
		this.infoDAO = infoDAO;
	}
	
	@Override
	public void addInfo(Information information) {
		if(information==null) {
			return;
		}
		if(information.getId()!=null) {
			return;
		}
		infoDAO.addInformation(information);
	}

	@Override
	public void deleteInfo(Information information) {
		if(information==null) {
			return;
		}
		if(information.getId()==null) {
			return;
		}
		infoDAO.deleteInformation(information);
	}

	@Override
	public void updateInfo(Information information) {
		if(information==null) {
			return;
		}
		if(information.getId()!=null) {
			return;
		}
		infoDAO.updateInformation(information);

	}

	@Override
	public Information getInfoByID(String id) {
		if(id==null) {
			return null;
		}
		return infoDAO.getInformationById(id);
	}

	@Override
	public List<Information> getAllInfo() {
		return infoDAO.getAllInformation();
	}

}
