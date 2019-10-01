package com.iu.view;

import java.util.ArrayList;

import com.iu.dept.DeptDTO;

public class DeptView {
	public void view(String str) {
		System.out.println(str);

	}

	public void view(DeptDTO dto) {
		System.out.println();
		System.out.println("deptno : " + dto.getDeptno());
		System.out.println("dname : " + dto.getDname());
		System.out.println("loc : " + dto.getLoc());

	}

	public void view(ArrayList<DeptDTO> dtos) {
		for (DeptDTO dto : dtos)
			this.view(dto);

	}
}
