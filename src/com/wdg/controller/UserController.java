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
@RequestMapping("/admin")
public class UserController {
	UserService service = new UserServiceImpl();
	// 全浏览
	@RequestMapping("/looklist.action")
	public String look(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Integer grade = Integer.parseInt(session.getAttribute("grade")
				.toString());
		String user = (String) session.getAttribute("username");
		if (grade > 2) {
			ArrayList<User_reg> looklist = service.findAllService();
			request.setAttribute("lookList", looklist);
		} else {
			ArrayList<User_reg> looklist = service.findUserService(user);
			request.setAttribute("lookList", looklist);
		}
		return "look";
	}
	// 删除
	@RequestMapping("/delete.action")
	public String del(Integer id) {
		service.delService(id);
		return "redirect:looklist.action";
	}
	// 批量删除
	@RequestMapping("/delSelecte.action")
	public String delSelect(Integer[] ids) {
		if (ids != null) {
			for (Integer id : ids) {
				service.delService(id);
			}
		}
		return "redirect:looklist.action";
	}
	// 通过ID找到指定要修改的用户
	@RequestMapping("/findUser.action")
	public String findUser(HttpServletRequest request,
			HttpServletResponse response, Integer id) {
		User_reg user = service.findUserById(id);
		request.setAttribute("user", user);
		return "modify";
	}
	// 提交修改的用户信息
	@RequestMapping(value="/modify.action")
	public void modify(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out, User_reg user) {
		DateUtil today = new DateUtil();
		String reg_time = today.getDate();
		String reg_ip = request.getRemoteAddr();
		User_reg u = service.getService(user.getId());
		u.setPw(user.getPw());
		u.setAge(user.getAge());
		u.setEmail(user.getEmail());
		u.setReg_time(reg_time);
		u.setReg_ip(reg_ip);
		service.modifyService(u);
		out.print("修改成功！3秒后自动跳转浏览数据。");
		response.setHeader("refresh", "3; URL=looklist.action");
	}
	// 指定后台管理页面首页
	@RequestMapping("welcome.action")
	public String welcome() {
		return "welcome";
	}
}
