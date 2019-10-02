package com.iu.salgrade;

import java.util.ArrayList;
import java.util.List;


public class SalTest {

	public static void main(String[] args) {
		SalDAO dao = new SalDAO();
		SalDTO dto = new SalDTO();
		List<SalDTO> ar = new ArrayList<SalDTO>();
		dto = dao.getSelectOne(4);
		System.out.println(dto.getGrade());
		System.out.println(dto.getLosal());
		System.out.println(dto.getHisal());

		ar = dao.getSelectList();
		for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i).getGrade());
			System.out.println(ar.get(i).getLosal());
			System.out.println(ar.get(i).getHisal());
		}

	}

}
