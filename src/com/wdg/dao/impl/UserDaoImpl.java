package com.wdg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wdg.bean.User_reg;
import com.wdg.dao.UserDao;
import com.wdg.util.DBUtil;

public class UserDaoImpl implements UserDao {
	public ResultSet selectSQL(String sql) {
		DBUtil util = new DBUtil();
		ResultSet rs = null;
		Connection conn = util.getConnection();
		try {
			Statement sm = conn.createStatement();
			rs = sm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 查询所有（查）
	public ArrayList findAll() {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		DBUtil util = new DBUtil();
		String sql = "select * from user_reg";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while (rs.next()) {
				User_reg u = new User_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPw(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setEmail(rs.getString(5));
				u.setReg_time(rs.getString(6));
				u.setReg_ip(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return list;
	}

	// 插入方法（增）
	/*
	 * public void add(String user, String pw, Integer age, String email, String
	 * reg_ip) { DBUtil util = new DBUtil(); Connection conn =
	 * util.getConnection(); DateUtil today = new DateUtil(); String reg_date =
	 * today.getDate(); String sql =
	 * "insert into user_reg(user,pw,age,email,reg_time,reg_ip) values(?,?,?,?,?,?)"
	 * ; try { PreparedStatement psmt = conn.prepareStatement(sql);
	 * psmt.setString(1, user); psmt.setString(2, pw); psmt.setInt(3, age);
	 * psmt.setString(4, email); psmt.setString(5, reg_date); psmt.setString(6,
	 * reg_ip); psmt.executeUpdate(); } catch (SQLException e) {
	 * e.printStackTrace(); } finally { util.closeConn(conn); } }
	 */

	// 插入方法（增）
	public void add(User_reg u) {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "insert into user_reg(user,pw,age,email,reg_time,reg_ip,grade) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, u.getUser());
			psmt.setString(2, u.getPw());
			psmt.setInt(3, u.getAge());
			psmt.setString(4, u.getEmail());
			psmt.setString(5, u.getReg_time());
			psmt.setString(6, u.getReg_ip());
			psmt.setInt(7, u.getGrade());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

	// 核对重名方法（查：核对匹配）
	public boolean check(String user) {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select * from user_reg where user=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}

	// 登录方法（查：核对匹配）
	public boolean login(String user, String pw) {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select * from user_reg where user=? and pw=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user);
			psmt.setString(2, pw);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return false;
	}

	// 删除方法（删）
	public void del(int id) {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "delete from user_reg where id = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

	// 通过id得到用户，得到要修改的表单，为更新做准备的（改）
	public User_reg get(Integer id) {
		User_reg u = null;
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select * from user_reg where id = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				String user = rs.getString(2);
				String pw = rs.getString(3);
				Integer age = rs.getInt(4);
				String email = rs.getString(5);
				String reg_time = rs.getString(6);
				String reg_ip = rs.getString(7);

				u = new User_reg();
				u.setId(id);
				u.setUser(user);
				u.setAge(age);
				u.setPw(pw);
				u.setEmail(email);
				u.setReg_time(reg_time);
				u.setReg_ip(reg_ip);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return u;
	}

	// 更新方法（修改数据）（改）
	public void modify(User_reg u) {
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "update user_reg set pw=?, age=?, email=?, reg_time=?, reg_ip=? where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, u.getPw());
			psmt.setInt(2, u.getAge());
			psmt.setString(3, u.getEmail());
			psmt.setString(4, u.getReg_time());
			psmt.setString(5, u.getReg_ip());
			psmt.setInt(6, u.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

	public User_reg getName(String user){
		User_reg u = null;
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select * from user_reg where user = ?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, user);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				String pw = rs.getString(3);
				Integer age = rs.getInt(4);
				String email = rs.getString(5);
				String reg_time = rs.getString(6);
				String reg_ip = rs.getString(7);
				Integer grade=rs.getInt(8);

				u = new User_reg();
				u.setId(id);
				u.setUser(user);
				u.setAge(age);
				u.setPw(pw);
				u.setEmail(email);
				u.setReg_time(reg_time);
				u.setReg_ip(reg_ip);
				u.setGrade(grade);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return u;
	}

	public ArrayList findUser(String user){
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		DBUtil util = new DBUtil();
		String sql = "select * from user_reg where user = ?";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setString(1, user);
			rs = psta.executeQuery();
			while (rs.next()) {
				User_reg u = new User_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPw(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setEmail(rs.getString(5));
				u.setReg_time(rs.getString(6));
				u.setReg_ip(rs.getString(7));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return list;
	}

	public int findTotalCount() {
        //1.定义模板初始化sql
        String sql = "select * from user_reg";
        //2.定义记录数的变量；
        int count=0;
        ResultSet rs = null;
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		try {
			Statement sm = conn.createStatement();
			rs = sm.executeQuery(sql);
/*
 //方法一：
			while (rs.next()) {
				//3.统计记录个数；
				count=count+1;
			}
*/
//方法二：
			rs.last();
			count=rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<User_reg> findByPage(int start, int rows) {
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		ArrayList list = new ArrayList();
		DBUtil util = new DBUtil();
		String sql = "select * from user_reg limit ?,?";
		try {
			conn = util.getConnection();
			psta = conn.prepareStatement(sql);
			psta.setInt(1, start);
			psta.setInt(2, rows);
			rs = psta.executeQuery();
			while (rs.next()) {
				User_reg u = new User_reg();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				u.setPw(rs.getString(3));
				u.setAge(rs.getInt(4));
				u.setEmail(rs.getString(5));
				u.setReg_time(rs.getString(6));
				u.setReg_ip(rs.getString(7));
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
