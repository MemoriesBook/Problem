package com.wdg.dao;

import java.util.ArrayList;
import java.util.List;

import com.wdg.bean.Student_reg;

public interface StudentDao {
	//通过ID号得到用户
	public Student_reg get(Integer id);
	//（分页）查询总记录数
	public int findTotalCount();
	//（分页）查询每页记录
	public List<Student_reg> findByPage(int start, int rows);
	// 模糊查询后获得的集合
	public ArrayList<Student_reg> selectUserKey(String key);
	// 筛选条件模糊查询后获得的集合
	public ArrayList<Student_reg> selectUser(String field, String key);
	
}
