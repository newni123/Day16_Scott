package com.iu.control;

import java.util.ArrayList;

import com.iu.dept.DeptDAO;
import com.iu.dept.DeptDTO;
import com.iu.input.DeptInput;
import com.iu.view.DeptView;

public class DeptController {
	public void start() {
		DeptDAO dao = new DeptDAO();
		DeptDTO dto = new DeptDTO();
		DeptView ev = new DeptView();
		DeptInput ei = new DeptInput();
		ArrayList<DeptDTO> dtos = new ArrayList<DeptDTO>();
		while (true) {
			int select = ei.select();
			if (select == 1) {
				dtos = dao.getSelectList(dtos);
				ev.view(dtos);
			} else if (select == 2) {
				int choice = ei.deptnoInput();
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