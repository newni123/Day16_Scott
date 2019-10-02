package com.iu.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.emp.EmpDAO;
import com.iu.emp.EmpDTO;
import com.iu.input.EmpInput;
import com.iu.view.EmpView;

public class EmpController {
	// start
	// 1. 사원 전체 정보 출력
	// 2. 사원 검색 출력
	// 3. 프로그램 종료
	public void start() {
		Scanner sc = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		EmpDTO dto = new EmpDTO();
		EmpView ev = new EmpView();
		EmpInput ei = new EmpInput();
		List<EmpDTO> dtos = new ArrayList<EmpDTO>();
		boolean check = true;
		while (check) {
			System.out.println();
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 직원 번호로 검색");
			System.out.println("3. 직원 정보 추가");
			System.out.println("4. 프로그램 종료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			System.out.println();
			switch (select) {
			case 1:
				dtos = dao.getSelectList();
				ev.view(dtos);
				break;
			case 2:
				int choice = ei.empnoInput();
				dto = dao.getSelectOne(choice);
				if (dto != null)
					ev.view(dto);
				else
					ev.view("찾으시는 정보가 없습니다.");
				break;
			case 3:
				dto = ei.EmpInsert();
				select = dao.mgrCheck(dto);
				if (select == 1)
					dao.insert(dto);
				else 
					System.out.println("없는 매니저 번호");
				String s = "Insert Fail";
				if (select > 0)
					s = "insert Success";
				ev.view(s);
				break;

			default:
				System.out.println("프로그램 종료 ");
				check = !check;
			}

		}

	}
}
