package com.iu.control;

import java.util.Scanner;

public class FrontController {
	private Scanner sc;
	private EmpController ec;
	private DeptController dc;

	public FrontController() {
		sc = new Scanner(System.in);
		ec = new EmpController();
		dc = new DeptController();
	}

	public void start() {
		boolean check = true;
		int select = 0;
		while (check) {
			System.out.println("1. 사원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("작업을 선택하세요 : ");
			select = sc.nextInt();
		
			switch (select) {
			case 1:
				ec.start();
				break;
			case 2:
				dc.start();
				break;
			default:
				System.out.println("프로그램 종료");
				check = !check;

			}
		}
	}
}
