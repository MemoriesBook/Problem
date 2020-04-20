package com.wdg.controller;

import com.wdg.bean.PageBean;
import com.wdg.bean.Student_reg;
import com.wdg.bean.User_reg;
import com.wdg.service.StudentService;
import com.wdg.service.UserService;
import com.wdg.service.impl.StudentServiceImpl;
import com.wdg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class FindStudentByPageController extends HttpServlet {
	@RequestMapping("/findStudentByPage.action")
	protected String findStudentByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1.获取参数，参数为空，则设置每页显示数量！
		String currentPage = request.getParameter("currentPage");// 当前页码
		String rows = request.getParameter("rows");// 每页显示条数
		String totalPage = request.getParameter("totalPage");// 总页数

		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (rows == null || "".equals(rows)) {
			rows = "15";
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
		StudentService service = (StudentService) new StudentServiceImpl();
		PageBean<Student_reg> pb = service.findStudentByPage(currentPage, rows);

//		System.out.println(pb);

		// 3.将PageBean存入request
		request.setAttribute("pb", pb);
		// 4.转发到list.jsp
		return "StudentPage";
	}
}
