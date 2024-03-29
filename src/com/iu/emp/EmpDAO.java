package com.iu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iu.dept.DeptDTO;
import com.iu.util.DBConnector;

public class EmpDAO {
	

	public List<EmpDTO> getSelectOne(String ename) {
		// 전체 사원 정보를 리턴
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO dto = null;
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();

		try {
			conn = DBConnector.getConnect();
			ename = ename.toUpperCase();
			String sql = "select empno,ename,job,mgr,hiredate,sal,nvl(comm,0) comm,"
					+ "deptno from emp where ename like '%" + ename + "%'";
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
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;

	}

	public int delete(int empno) {
		Connection conn = null;
		PreparedStatement st = null;
		int check = 0;
		try {
			conn = DBConnector.getConnect();
			conn.setAutoCommit(false); // 오토커밋해제
			String sql = "delete from emp where empno = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, empno);
			check = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;

	}

	public int mgrCheck(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int check = 0;
		try {
			conn = DBConnector.getConnect();
			String sql = "select empno from emp where mgr = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, dto.getMgr());
			rs = st.executeQuery();
			if (rs.next())
				check = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;

	}

	public int insert(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			conn = DBConnector.getConnect();
			String sql = "insert into emp values (?,?,?,?,sysdate,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setInt(1, dto.getEmpno());
			st.setString(2, dto.getEname());
			st.setString(3, dto.getJob());
			st.setInt(4, dto.getMgr());
			st.setInt(5, dto.getSal());
			st.setInt(6, dto.getComm());
			st.setInt(7, dto.getDeptno());
			result = st.executeUpdate();
			if (result > 0)
				System.out.println("정보 입력 완료");
			else
				System.out.println("정보 입력 실패");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// getSelectOne
	// 매개변수로 사원번호
	public List<EmpDTO> getSelectList() {

		// 전체 사원 정보를 리턴
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO dto = null;
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();

		try {
			conn = DBConnector.getConnect();
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
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dtos;

	}

	public EmpDTO getSelectOne(int empno) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO dto = null;

		try {
			conn = DBConnector.getConnect();
			String sql = "select * from emp where empno = ?";
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
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
