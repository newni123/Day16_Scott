 package com.iu.region;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegionController {
	private Scanner sc;
	private RegionDAO regionDAO;
	private RegionDTO regionDTO;
	private RegionInput regionInput;
	private RegionView regionView;
	private List<RegionDTO> ar;

	public RegionController() {
		sc = new Scanner(System.in);
		regionDAO = new RegionDAO();
		regionDTO = new RegionDTO();
		regionInput = new RegionInput();
		regionView = new RegionView();
		ar = new ArrayList<RegionDTO>();

	}

	public void start() {

		boolean check = true;
		while (check) {
			System.out.println();
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 지역번호로 검색");
			System.out.println("3. 지역 정보 추가");
			System.out.println("4. 지역 정보 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				ar = regionDAO.getSelectAll();
				regionView.view(ar);
				break;
			case 2:
				 select = regionInput.idInput();
				regionDTO = regionDAO.getSelectOne(select);
				if (regionDTO != null)
					regionView.view(regionDTO);
				else
					regionView.view("찾으시는 정보가 없습니다.");
				break;
			case 3:

				regionDTO = regionInput.salInsert();
				select = regionDAO.insert(regionDTO);
				if (select > 0)
					System.out.println("정보 입력 완료.");
				else
					System.out.println("정보 입력 실패");
				break;
			case 4:
				select = regionInput.idInput();
				select = regionDAO.delete(select);
				if (select == 1)
					System.out.println("삭제 완료");
				else
					System.out.println("삭제 실패");
				break;
			default:
				System.out.println("프로그램 종료");
				check = !check;
			}
		}
	}

}
