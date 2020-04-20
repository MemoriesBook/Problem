package com.wdg.controller;

import java.io.IOException;

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

@Controller
public class LoginController {
	@RequestMapping("/login.action")
	public String login(HttpServletRequest request,
			HttpServletResponse response,User_reg u) throws ServletException, IOException {
		//1.验证码校验
		String verifycode = request.getParameter("verifycode");
		HttpSession session = request.getSession();
		String CHECKCODE_SERVER = (String) session
				.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");   //一次性的验证码使用
		if (!CHECKCODE_SERVER.equalsIgnoreCase(verifycode)) {
			request.setAttribute("error", "验证码错误请重新输入！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return null;
		}
		//2.登录
		UserService service=new UserServiceImpl();
		boolean login = service.loginService(u.getUser(), u.getPw());
		if (login) {
			User_reg user = service.getNameService(u.getUser());
			Integer grade = user.getGrade();
			session.setAttribute("id", u.getId());
			session.setAttribute("username", u.getUser());
			session.setAttribute("grade", grade);
			return "redirect:admin/welcome.action";

		} else {
			session.setAttribute("error", "用户名或密码错误！");
			response.sendRedirect("login.jsp");
			return null;
		}
	}
	@RequestMapping("/logout.action")
	public void logout(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException {
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
}
