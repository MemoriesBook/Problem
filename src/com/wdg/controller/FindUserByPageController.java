package com.wdg.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wdg.bean.PageBean;
import com.wdg.bean.User_reg;
import com.wdg.service.UserService;
import com.wdg.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class FindUserByPageController extends HttpServlet {
	@RequestMapping("/findUserByPage.action")
	protected String findUserByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.获取参数，参数为空，则设置每页显示数量！
		String currentPage = request.getParameter("currentPage");// 当前页码
		String rows = request.getParameter("rows");// 每页显示条数
		String totalPage = request.getParameter("totalPage");// 总页数
        //当前页为空则设置当前页为1，每页显示条数为空则设置每页显示5条
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (rows == null || "".equals(rows)) {
			rows = "5";
		}
		// 当前页大于等于总页数，则当前页为总页数
		if (totalPage != null) {
			int c = Integer.parseInt(currentPage);
			int t = Integer.parseInt(totalPage);
			if (c >= t) {
				currentPage = totalPage;
			}
		}
		// 2.调用service查询
		UserService service = new UserServiceImpl();
		PageBean<User_reg> pb = service.findUserByPage(currentPage, rows);
		// 3.将PageBean存入request
		request.setAttribute("pb", pb);
		// 4.转发到list.jsp
		return "lookPageUser";
	}
}
