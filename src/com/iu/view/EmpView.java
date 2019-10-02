package com.iu.view;

import java.util.List;

import com.iu.emp.EmpDTO;

public class EmpView {
	// 출력
	public void view(String string) {
		System.out.println();
		System.out.println(string);

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

	public void view(List<EmpDTO> dtos) {
		for (EmpDTO dto : dtos)
			this.view(dto);
	
	}
}
