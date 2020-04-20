package com.wdg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wdg.bean.Log;
import com.wdg.dao.LogDao;
import com.wdg.util.DBUtil;

public class LogDaoImpl implements LogDao {

	@Override
	public void insertLog(Log log) {
		// TODO Auto-generated method stub
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "insert into log(name, loginTime, loginId) values(?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, log.getName());
			psmt.setString(2, log.getLoginTime());
			psmt.setInt(3, log.getLoginId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

	@Override
	public Integer getId(String name) {
		// TODO Auto-generated method stub
		DBUtil util = new DBUtil();
		Connection conn = util.getConnection();
		String sql = "select id from user_reg where user=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
		return 0;
	}
}
