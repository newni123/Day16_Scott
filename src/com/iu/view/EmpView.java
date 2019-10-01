package com.iu.view;

import java.util.ArrayList;

import com.iu.emp.EmpDTO;

public class EmpView {
	// 출력
	public void view(String str) {
		System.out.println(str);

	}

	public void view(EmpDTO dto) {
		System.out.println();
		System.out.println("empno : " + dto.getEmpno());
		System.out.println("ename : " + dto.getEname());
		System.out.println("job : " + dto.getJob());
		System.out.println("mgr : " + dto.getMgr());
		System.out.println("hiredate : " + dto.getHireDate());
		System.out.println("sal : " + dto.getSal());
		System.out.println("comm : " + dto.getComm());
		System.out.println("deptno : " + dto.getDeptno());
	}

	public void view(ArrayList<EmpDTO> dtos) {
		for (EmpDTO dto : dtos)
			this.view(dto);
		/*
		 * for (int i = 0; i < dtos.size(); i++) { System.out.println();
		 * System.out.println("empno : " + dtos.get(i).getEmpno());
		 * System.out.println("ename : " + dtos.get(i).getEname());
		 * System.out.println("job : " + dtos.get(i).getJob());
		 * System.out.println("mgr : " + dtos.get(i).getMgr());
		 * System.out.println("hiredate : " + dtos.get(i).getHireDate());
		 * System.out.println("sal : " + dtos.get(i).getSal());
		 * System.out.println("comm : " + dtos.get(i).getComm());
		 * System.out.println("deptno : " + dtos.get(i).getDeptno());
		 * 
		 * }
		 */
	}
}
