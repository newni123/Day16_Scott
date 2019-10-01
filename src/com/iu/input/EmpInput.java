package com.iu.input;

import java.util.Scanner;

public class EmpInput {

	private Scanner sc;

	public EmpInput() {
		sc = new Scanner(System.in);
	}

	public int select() {
		System.out.println();
		System.out.println("1. 전체 정보 출력");
		System.out.println("2. 직원 번호로 검색");
		System.out.println("3. 프로그램 종료");
		System.out.print("번호를 입력하세요 : ");
		int select = sc.nextInt();
		System.out.println();
		return select;
	}

	public int empnoInput() {
		System.out.print("검색할 직원번호를 입력하세요 : ");
		int select = sc.nextInt();
		return select;
	}
}
