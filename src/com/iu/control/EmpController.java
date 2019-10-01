package com.iu.control;

import java.util.ArrayList;

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
		EmpDAO dao = new EmpDAO();
		EmpDTO dto = new EmpDTO();
		EmpView ev = new EmpView();
		EmpInput ei = new EmpInput();
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		while (true) {
			int select = ei.select();
			if (select == 1) {
				dtos = dao.getSelectList(dtos);
				ev.view(dtos);
			} else if (select == 2) {
				int choice = ei.empnoInput();
				dto = dao.getSelectOne(choice);
				if (dto != null)
					ev.view(dto);
				else
					ev.view("찾으시는 정보가 없습니다.");

			} else {
				System.out.println("프로그램 종료 ");
				break;
			}

		}

	}
}
