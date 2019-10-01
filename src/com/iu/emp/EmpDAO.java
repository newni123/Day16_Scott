package com.iu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.util.DBConnector;

public class EmpDAO {

	// getSelectOne
	// 매개변수로 사원번호
	public ArrayList<EmpDTO> getSelectList(ArrayList<EmpDTO> dtos) {

		// 전체 사원 정보를 리턴
		DBConnector db = new DBConnector();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO dto = null;

		try {
			conn = db.getConnect();
			String sql = "select empno,ename,job,mgr,hiredate,sal,nvl(comm,0) comm,"
					+ "deptno from emp order by hiredate desc";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHireDate(rs.getDate("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dtos;

	}

	public EmpDTO getSelectOne(int empno) {
		DBConnector db = new DBConnector();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO dto = null;

		try {
			conn = db.getConnect();
			String sql = "select empno,ename,job,mgr,hiredate,sal,nvl(comm,0) comm,"
					+ "deptno from emp where empno = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, empno);
			rs = st.executeQuery();
			if (rs.next()) {
				dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHireDate(rs.getDate("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
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
		return dto;
	}
}
