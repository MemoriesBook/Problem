package com.wdg.dao;

import com.wdg.bean.Log;

public interface LogDao {
	public void insertLog(Log log);
	public Integer getId(String name);
}
