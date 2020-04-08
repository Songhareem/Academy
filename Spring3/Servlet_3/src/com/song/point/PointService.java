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
	
	// pointDel
	public int pointDel(PointDTO pointDTO) throws Exception {
		
		return pointDAO.pointDel(pointDTO);
	}
}
