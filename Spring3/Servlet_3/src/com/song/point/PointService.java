package com.song.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO;
	
	public PointService() {
		
		pointDAO = new PointDAO();
	}
	
	// pointList
	public ArrayList<PointDTO> pointList() throws Exception {
		
		return pointDAO.pointList();
	}
	
	// pointSelect
	public PointDTO pointSelect(PointDTO pointDTO) throws Exception {
		
		return pointDAO.pointSelect(pointDTO);
	}
	
	// pointAdd
	public int pointAdd(PointDTO pointDTO) throws Exception {
		
		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);
		return pointDAO.pointAdd(pointDTO);
	}
	
	// pointMod
	public int pointMod(PointDTO pointDTO) throws Exception {

		pointDTO.setTotal(pointDTO.getKor() + pointDTO.getEng() + pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal() / 3.0);
		return pointDAO.pointMod(pointDTO);
	}
	
	// pointDel
	public int pointDel(PointDTO pointDTO) throws Exception {
		
		return pointDAO.pointDel(pointDTO);
	}
}
