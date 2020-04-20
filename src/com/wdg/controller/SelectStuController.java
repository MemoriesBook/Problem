package com.wdg.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wdg.bean.Student_reg;
import com.wdg.bean.User_reg;
import com.wdg.dao.impl.UserDaoImpl;
import com.wdg.service.StudentService;
import com.wdg.service.UserService;
import com.wdg.service.impl.StudentServiceImpl;
import com.wdg.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class SelectStuController {
	StudentService service = new StudentServiceImpl();
	//模糊查询
	@RequestMapping("/selectUserKey.action")
	public String selectUserKey(HttpServletRequest request,
			HttpServletResponse response,String key) throws ServletException, IOException {
		ArrayList<Student_reg> stu_list = service.selectUserKeyService(key);
		request.setAttribute("key", key);
		request.setAttribute("stu_list", stu_list);
		return "selectKey";
	}
	//选择字段进行模糊查询
	@RequestMapping("/selectUserField.action")
	protected String selectUserField(HttpServletRequest request,
			HttpServletResponse response,String key,String field) throws ServletException, IOException {
		String a = request.getParameter("field");
		String aa = null;
		switch (a) {
		case "sxtype":
			aa = "实习类型";
			break;
		case "sort":
			aa = "专业";
			break;
		case "username":
			aa = "学生姓名";
			break;
		case "teacher":
			aa = "指导教师";
			break;
		}
		ArrayList<Student_reg> stu_list = service.selectUserService(field, key);
		request.setAttribute("key", key);
		request.setAttribute("a", aa);
		request.setAttribute("stu_list", stu_list);
		return "selectField";
	}
	@RequestMapping("/selectKeyPage.action")
	public String SelectKey(){
		return "selectKey";
	}
	@RequestMapping("/selectFieldPage.action")
	public String SelectField(){
		return "selectField";
	}
	
}
