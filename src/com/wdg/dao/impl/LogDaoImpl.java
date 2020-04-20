package com.wdg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		String sql = "insert into log(id, name, loginTime) values(?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, log.getId());
			psmt.setString(2, log.getName());
			psmt.setString(3, log.getLoginTime());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConn(conn);
		}
	}

}
