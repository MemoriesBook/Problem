package com.wdg.service;

import java.util.ArrayList;

import com.wdg.bean.PageBean;
import com.wdg.bean.Student_reg;

public interface StudentService {
	Student_reg findStudentById(Integer id);

	PageBean<Student_reg> findStudentByPage(String currentPage, String rows);

	ArrayList<Student_reg> selectUserService(String field, String key);

	ArrayList<Student_reg> selectUserKeyService(String key);
}
