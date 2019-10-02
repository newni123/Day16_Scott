package com.iu.input;

import java.util.Scanner;

import com.iu.emp.EmpDTO;

public class EmpInput {

	private Scanner sc;

	public EmpInput() {
		sc = new Scanner(System.in);

	}
	
	public int empnoDelete() {
		System.out.print("삭제할 직원번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}

	public EmpDTO EmpInsert() {
		EmpDTO dto = new EmpDTO();
		System.out.print("empno : ");
		dto.setEmpno(sc.nextInt());
		System.out.print("ename : ");
		dto.setEname(sc.next());
		System.out.print("job : ");
		dto.setJob(sc.next());
		System.out.print("mgr : ");
		dto.setMgr(sc.nextInt());
		System.out.print("sal : ");
		dto.setSal(sc.nextInt());
		System.out.print("comm : ");
		dto.setComm(sc.nextInt());
		System.out.print("deptno : ");
		dto.setDeptno(sc.nextInt());
		return dto;

	}

	public int empnoInput() {
		System.out.print("검색할 직원번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}
}
