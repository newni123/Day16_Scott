package com.iu.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class DeptDAO {
	public ArrayList<DeptDTO> getSelectList(ArrayList<DeptDTO> dtos) {

		// 전체 사원 정보를 리턴
		DBConnector db = new DBConnector();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DeptDTO deptdto = null;

		try {
			conn = db.getConnect();
			String sql = "select * from dept";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				deptdto = new DeptDTO();
				deptdto.setDeptno(rs.getInt("deptno"));
				deptdto.setDname(rs.getString("dname"));
				deptdto.setLoc(rs.getString("loc"));
				dtos.add(deptdto);
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
		return dtos;

	}

	public DeptDTO getSelectOne(int deptno) {
		DBConnector db = new DBConnector();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DeptDTO deptdto = null;

		try {
			conn = db.getConnect();
			String sql = "select * from dept where deptno = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, deptno);
			rs = st.executeQuery();
			if (rs.next()) {
				deptdto = new DeptDTO();
				deptdto.setDeptno(rs.getInt("deptno"));
				deptdto.setDname(rs.getString("dname"));
				deptdto.setLoc(rs.getString("loc"));

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
		return deptdto;
	}
}
