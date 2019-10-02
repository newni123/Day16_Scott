package com.iu.region;

import java.util.List;

public class RegionView {
	public void view(String str) {
		System.out.println(str);
	}

	public void view(RegionDTO regionDTO) {
		System.out.println("REGION_ID : " + regionDTO.getRegion_id());
		System.out.println("REGION_NAME : " + regionDTO.getRegion_name());

	}

	public void view(List<RegionDTO> ar) {
		for (RegionDTO regionDTO : ar)
			this.view(regionDTO);
	}

}
