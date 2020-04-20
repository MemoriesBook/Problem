package com.wdg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wdg.bean.Student_reg;
import com.wdg.bean.User_reg;
import com.wdg.dao.StudentDao;
import com.wdg.dao.UserDao;
import com.wdg.util.DBUtil;

public class StudentDaoImpl implements StudentDao {

	// 通过id得到用户，得到要修改的表单，为更新做准备的（改）
	public Student_reg get(Integer id) {
		Student_reg u = null;
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select * from student_reg where id = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				String user = rs.getString(2);
				String pwd = rs.getString(3);
				String username = rs.getString(4);
				String sort = rs.getString(5);
				String userclass = rs.getString(6);
				String teacher = rs.getString(7);
				String sxtype = rs.getString(8);
				u = new Student_reg();
				u.setId(id);
				u.setUser(user);
				u.setPwd(pwd);
				u.setUsername(username);
				u.setUserclass(userclass);
				u.setSort(sort);
				u.setTeacher(teacher);
				u.setSxtype(sxtype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return u;
	}

	// 分页中获得总记录数
	public int findTotalCount() {
		// 1.定义模板初始化sql
		String sql = "select * from student_reg";
		// 2.定义记录数的变量；
		int count = 0;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		try {
			Statement sm = conn.createStatement();
			rs = sm.executeQuery(sql);
			/*
			 * //方法一： while (rs.next()) { //3.统计记录个数； count=count+1; }
			 */
			// 方法二：
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// 获得当前页的集合
	public List<Student_reg> findByPage(int start, int rows) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		DBUtil util = new DBUtil();
		String sql = "select * from student_reg limit ?,?";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setInt(1, start);
			psta.setInt(2, rows);
			rs = psta.executeQuery();
			while (rs.next()) {
				Student_reg u = new Student_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setSort(rs.getString(5));
				u.setUserclass(rs.getString(6));
				u.setTeacher(rs.getString(7));
				u.setSxtype(rs.getString(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return list;
	}

	// 模糊查询后获得的集合
	public ArrayList<Student_reg> selectUserKey(String key) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList<Student_reg> listKey = new ArrayList<Student_reg>();
		DBUtil util = new DBUtil();
		String sql = "select * from student_reg where username like ?";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setString(1, "%" + key + "%");
			rs = psta.executeQuery();
			while (rs.next()) {
				Student_reg u = new Student_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setSort(rs.getString(5));
				u.setUserclass(rs.getString(6));
				u.setTeacher(rs.getString(7));
				u.setSxtype(rs.getString(8));
				listKey.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return listKey;
	}
	
	// 筛选条件模糊查询后获得的集合
	public ArrayList<Student_reg> selectUser(String field, String key) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList<Student_reg> list = new ArrayList<Student_reg>();
		DBUtil util = new DBUtil();
		// String sql="select * from student_reg where ? like ?";
		String sql = "select * from student_reg where " + field + " like ?";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			//不能把表名或字段名当成占位符
			// psta.setString(1, field);
			psta.setString(1, "%" + key + "%");
			rs = psta.executeQuery();
			while (rs.next()) {
				Student_reg u = new Student_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPwd(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setSort(rs.getString(5));
				u.setUserclass(rs.getString(6));
				u.setTeacher(rs.getString(7));
				u.setSxtype(rs.getString(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return list;
	}

}
