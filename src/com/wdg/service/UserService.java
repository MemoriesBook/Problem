package com.wdg.service;

import java.util.ArrayList;
import java.util.Map;

import com.wdg.bean.PageBean;
import com.wdg.bean.Student_reg;
import com.wdg.bean.User_reg;

public interface UserService {
	PageBean<User_reg> findUserByPage(String currentPage, String rows);

	User_reg findUserById(Integer id);

	boolean checkService(String user);

	void addService(User_reg u);

	void delService(Integer id);

	ArrayList<User_reg> findAllService();

	ArrayList<User_reg> findUserService(String user);

	User_reg getService(Integer id);

	void modifyService(User_reg u);

	boolean loginService(String user, String pw);

	User_reg getNameService(String user);

}
