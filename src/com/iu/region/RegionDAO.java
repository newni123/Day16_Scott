package com.iu.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iu.util.DBConnector;

public class RegionDAO {

	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	RegionDTO regionDTO = null;
	ArrayList<RegionDTO> ar = null;
	
	public int delete(int id) {
		int result = 0;
		try {
			conn = DBConnector.getConnect();
			String sql = "delete from regions where region_id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			result = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public int insert(RegionDTO regionDTO) {
		int result = 0;
		try {
			conn = DBConnector.getConnect();
			String sql = "insert into regions values (?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, regionDTO.getRegion_id());
			st.setString(2, regionDTO.getRegion_name());
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	public List<RegionDTO> getSelectAll() {
		try {
			ar = new ArrayList<RegionDTO>();
			conn = DBConnector.getConnect();
			String sql = "select * from regions";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				regionDTO = new RegionDTO();
				regionDTO.setRegion_id(rs.getInt("region_id"));
				regionDTO.setRegion_name(rs.getString("region_name"));
				ar.add(regionDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;

	}

	public RegionDTO getSelectOne(int id) {
		try {

			conn = DBConnector.getConnect();
			String sql = "select * from regions where region_id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				regionDTO = new RegionDTO();
				regionDTO.setRegion_id(rs.getInt("region_id"));
				regionDTO.setRegion_name(rs.getString("region_name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return regionDTO;
	}
}
