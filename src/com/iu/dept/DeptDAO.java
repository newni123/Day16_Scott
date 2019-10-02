package com.iu.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.iu.util.DBConnector;

public class DeptDAO {
	
	public int deptInsert(DeptDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		int result = 0;

		try {
			conn = DBConnector.getConnect();
			String sql = "insert into dept values (?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, dto.getDeptno());
			st.setString(2, dto.getDname());
			st.setString(3, dto.getLoc());
			result = st.executeUpdate();
			if (result > 0)
				System.out.println("정보 입력 완료");
			else
				System.out.println("정보 입력 실패");
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

	public List<DeptDTO> getSelectList() {

		// 전체 사원 정보를 리턴
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DeptDTO deptdto = null;
		ArrayList<DeptDTO> dtos = new ArrayList<DeptDTO>();

		try {
			conn = DBConnector.getConnect();
			String sql = "select * from dept order by deptno asc";
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
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DeptDTO deptdto = null;

		try {
			conn = DBConnector.getConnect();
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
