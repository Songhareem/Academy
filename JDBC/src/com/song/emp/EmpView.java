package com.song.emp;

import java.util.ArrayList;

import com.song.emp.EmpDTO;

public class EmpView {
    
	public void view(int totalSal) {
		System.out.printf("전체 직원의 월급 및 인센 총합계 : %,d$\n",totalSal);
	}
	
	public void view(EmpDTO empDTO) {
		
		System.out.println("EMPNO\tDNAME\tMGR\tHIREDATE\tSAL\tCOMM\tDEPTNO\tJOB\t\t");
		
		StringBuffer str = new StringBuffer();
		
		str.append(empDTO.getEmpno()+"\t"); 
		str.append(empDTO.getEname()+"\t");
		str.append(empDTO.getMgr()+"\t");
		str.append(empDTO.getHiredate()+"\t"); 
		str.append(empDTO.getSal()+"\t");
		str.append(empDTO.getComm()+"\t"); 
		str.append(empDTO.getDeptno()+"\t");
		str.append(empDTO.getJob()+"\t\t"); 
		 
		System.out.println(str);
	}
	
	public void view(ArrayList<EmpDTO> edtoList) {

		if (edtoList.isEmpty()) {
			System.out.println("조회하는 데이터가 없습니다");
			return;
		}

		System.out.println("EMPNO\tDNAME\tMGR\tHIREDATE\tSAL\tCOMM\tDEPTNO\tJOB\t\t");

		for (EmpDTO empDTO : edtoList) {

			StringBuffer str = new StringBuffer();

			str.append(empDTO.getEmpno()+"\t"); 
			str.append(empDTO.getEname()+"\t");
			str.append(empDTO.getMgr()+"\t");
			str.append(empDTO.getHiredate()+"\t"); 
			str.append(empDTO.getSal()+"\t");
			str.append(empDTO.getComm()+"\t"); 
			str.append(empDTO.getDeptno()+"\t");
			str.append(empDTO.getJob()+"\t\t"); 
			 
			System.out.println(str);
		}
	}
	
	public void view(String msg) {
		
		System.out.println(msg);
	}
}
