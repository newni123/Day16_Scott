package com.iu.view;

import java.util.List;

import com.iu.dept.DeptDTO;

public class DeptView {
	public void view(String string) {
		System.out.println(string);

	}

	public void view(DeptDTO dto) {
		System.out.println();
		System.out.println("deptno : " + dto.getDeptno());
		System.out.println("dname : " + dto.getDname());
		System.out.println("loc : " + dto.getLoc());

	}

	public void view(List<DeptDTO> dtos) {
		for (DeptDTO dto : dtos)
			this.view(dto);

	}
}
