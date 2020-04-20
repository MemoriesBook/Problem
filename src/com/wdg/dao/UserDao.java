package com.wdg.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wdg.bean.User_reg;

public interface UserDao {
	//通过执行SQL语句得到记录集
	public ResultSet selectSQL(String sql);
	//查询所有得到记录集合
	public ArrayList findAll();
	//通过用户对象添加用户信息
	public void add(User_reg u);
	//通过用户名核对是否重名
	public boolean check(String user);
	//通过用户名和密码登录
	public boolean login(String user, String pw);
	//通过ID号删除指定的记录
	public void del(int id);
	//通过ID号得到用户
	public User_reg get(Integer id);
	//通过用户对象修改用户信息
	public void modify(User_reg u);
	//通过用户名得到该用户
	public User_reg getName(String user);
	//通过用户名得到记录集合
	public ArrayList findUser(String user);
	
	//（分页）查询总记录数
	public int findTotalCount();
	//（分页）查询每页记录
	public List<User_reg> findByPage(int start, int rows);
	
	
}
