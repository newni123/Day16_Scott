package com.iu.region;

import java.util.Scanner;


public class RegionInput {

	private Scanner sc;

	public RegionInput() {
		sc = new Scanner(System.in);
	}

	public int idInput() {
		System.out.print ("지역번호를 입력하세요 : ");
		int id = sc.nextInt();
		return id;
	} // enameInput

	public RegionDTO salInsert() {
		RegionDTO regionDTO= new RegionDTO();

		System.out.print("지역 번호 입력 : ");
		regionDTO.setRegion_id(sc.nextInt());
		System.out.print("지역 이름 입력 : ");
		regionDTO.setRegion_name(sc.next());
		

		return regionDTO;
	}// salInput
}
