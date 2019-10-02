package com.iu.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.dept.DeptDAO;
import com.iu.dept.DeptDTO;
import com.iu.input.DeptInput;
import com.iu.view.DeptView;

public class DeptController {
	private Scanner sc;
	private DeptDAO dao;
	private DeptDTO dto;
	private DeptView dv;
	private DeptInput di;
	private List<DeptDTO> dtos;

	public DeptController() {
		sc = new Scanner(System.in);
		dao = new DeptDAO();
		dto = new DeptDTO();
		dv = new DeptView();
		di = new DeptInput();
		dtos = new ArrayList<DeptDTO>();
	}

	public void start() {

		boolean check = true;
		while (check) {
			System.out.println();
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 부서 번호로 검색");
			System.out.println("3. 부서 정보 추가");
			System.out.println("4. 프로그램 종료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			System.out.println();
			switch (select) {
			case 1:
				dtos = dao.getSelectList();
				dv.view(dtos);
				break;
			case 2:
				int choice = di.deptnoInput();
				dto = dao.getSelectOne(choice);
				if (dto != null)
					dv.view(dto);
				else
					dv.view("찾으시는 정보가 없습니다.");
				break;
			case 3:

				dto = di.insert();
				select = dao.deptInsert(dto);
				String s = "Insert Fail";
				if(select > 0 ) 
					s = "insert Success";
				dv.view(s);
				break;
			default:
				System.out.println("프로그램 종료 ");
				check = !check;
			}

		}

	}
}