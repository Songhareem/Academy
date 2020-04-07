package com.song.point;

public class PointService {

	private PointDAO pointDAO = null;
	
	PointService() {
		pointDAO = new PointDAO();
	}

	public int pointAdd(PointDTO pointDTO) throws Exception {	
		
		pointDTO.setTotal();
		pointDTO.setAvg();
		
		int result = pointDAO.pointAdd(pointDTO);
		
		return result;
	}
}
