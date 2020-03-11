package com.song.main;

import com.song.dept.DeptController;
import com.song.dept.DeptInput;

import com.song.emp.EmpController;

public class ScottMain {

	public static void main(String[] args) {

		// DeptController dc = new DeptController();
		// dc.start();
		
		EmpController ec = new EmpController();
		ec.start();
		
		//SalgradeInput si = new SalgradeInput();
		//si.insert();
		//si.delete();
	}
}
