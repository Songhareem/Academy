package com.song.dept;

import java.util.ArrayList;

public class DeptView {

	public void view(DeptDTO deptDTO) {
		
		System.out.println("DEPTNO\tDNAME\t\tLOC");
		System.out.printf("%d\t%s\t%s",
				deptDTO.getDeptno(), deptDTO.getDname(), deptDTO.getLoc());
		System.out.println();
	
	}
	
	public void view(ArrayList<DeptDTO> ddtoList) {
		
		if(ddtoList.isEmpty()) {
			System.out.println("조회하는 데이터가 없습니다");
			return;
		}
		
		System.out.println("DEPTNO\tDNAME\t\tLOC");
		for (DeptDTO deptDTO : ddtoList) {
			
			System.out.printf("%d\t%s\t%s",
					deptDTO.getDeptno(), deptDTO.getDname(), deptDTO.getLoc());
			System.out.println();
		}
	}
	
	public void view(String message) {
		
		System.out.println(message);
	}
}
