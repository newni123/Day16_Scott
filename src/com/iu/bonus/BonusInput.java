package com.iu.bonus;

import java.util.Scanner;

public class BonusInput {
	private Scanner sc;
	
	public BonusInput() {
		sc = new Scanner(System.in);
	}
	public String enameInput() {
		System.out.print("검색할 정보의 ename 입력 : ");
		String ename = sc.next();
		return ename;
	}
	public BonusDTO salInsert() {
		BonusDTO bonusDTO = new BonusDTO();
		System.out.print("ENAME : ");
		bonusDTO.setEname(sc.next());
		System.out.print("JOB : ");
		bonusDTO.setJob(sc.next());
		System.out.print("SAL : ");
		bonusDTO.setSal(sc.nextInt());
		System.out.print("COMM : ");
		bonusDTO.setComm(sc.nextInt());
		return bonusDTO;
	}
}
