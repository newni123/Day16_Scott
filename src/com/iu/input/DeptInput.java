package com.iu.input;

import java.util.Scanner;

public class DeptInput {
	private Scanner sc;

	public DeptInput() {
		sc = new Scanner(System.in);
	}

	public int select() {
		System.out.println();
		System.out.println("1. 전체 정보 출력");
		System.out.println("2. 부서 번호로 검색");
		System.out.println("3. 프로그램 종료");
		System.out.print("번호를 입력하세요 : ");
		int select = sc.nextInt();
		System.out.println();
		return select;
	}

	public int deptnoInput() {
		System.out.print("검색할 부서번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}
}
