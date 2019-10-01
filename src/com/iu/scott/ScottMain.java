package com.iu.scott;

import com.iu.control.DeptController;
import com.iu.control.EmpController;

public class ScottMain {

	public static void main(String[] args) {

		EmpController ec = new EmpController();
		//ec.start();
		DeptController dc = new DeptController();
		dc.start();
	}

}
