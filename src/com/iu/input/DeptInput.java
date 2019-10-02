package com.iu.input;

import java.util.Scanner;

import com.iu.dept.DeptDTO;

public class DeptInput {
	private Scanner sc;

	public DeptInput() {
		sc = new Scanner(System.in);
	}


	public DeptDTO insert() {
		DeptDTO dto = new DeptDTO();
		System.out.print("deptno : ");
		dto.setDeptno(sc.nextInt());
		System.out.print("dname : ");
		dto.setDname(sc.next());
		System.out.print("loc : ");
		dto.setLoc(sc.next());
		return dto;
	}

	public int deptnoInput() {
		System.out.print("검색할 부서번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}
}
