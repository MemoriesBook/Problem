package com.wdg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wdg.bean.User_reg;
import com.wdg.dao.impl.UserDaoImpl;
import com.wdg.service.UserService;
import com.wdg.service.impl.UserServiceImpl;
import com.wdg.util.DateUtil;

@Controller
public class RegController {
	@RequestMapping(value="/reg.action")
	public void reg(HttpServletRequest request, HttpServletResponse response,
			PrintWriter out, User_reg user) {
		DateUtil today = new DateUtil();
		String reg_time = today.getDate();
		String reg_ip = request.getRemoteAddr();
		Integer grade=2;
		User_reg u = new User_reg();
		u.setUser(user.getUser());
		u.setPw(user.getPw());
		u.setAge(user.getAge());
		u.setEmail(user.getEmail());
		u.setReg_time(reg_time);
		u.setReg_ip(reg_ip);
		u.setGrade(grade);
		UserService service = new UserServiceImpl();
		boolean check = service.checkService(user.getUser());
		if (check) {
			out.print("该用户名已经存在，请用其他名重新注册！3秒后自动跳转注册页面。");
			response.setHeader("refresh", "3; URL=reg.jsp");
		} else {
			service.addService(u);
			out.print("添加成功！3秒后自动跳转浏览数据。");
			response.setHeader("refresh", "3; URL=login.jsp");
		}
	}
}
