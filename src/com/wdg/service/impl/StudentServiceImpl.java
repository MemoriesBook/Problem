package com.wdg.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wdg.bean.PageBean;
import com.wdg.bean.Student_reg;
import com.wdg.dao.StudentDao;
import com.wdg.dao.impl.StudentDaoImpl;
import com.wdg.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private StudentDao dao = (StudentDao) new StudentDaoImpl();
	@Override
	public PageBean<Student_reg> findStudentByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        
        //1.创建空的PageBean对象
        PageBean<Student_reg> pb = new PageBean<Student_reg>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询记录总数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Student_reg> list = dao.findByPage(start,rows);
        pb.setList(list);

        //5.计算总页码
        //如果总页数除以页数能整除，则返回这个整数，否则整数加1；
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
	}
	
	@Override
	public Student_reg findStudentById(Integer id) {
		return dao.get(id);
	}

	@Override
	public ArrayList<Student_reg> selectUserService(String field, String key) {
		return dao.selectUser(field, key);
	}

	@Override
	public ArrayList<Student_reg> selectUserKeyService(String key) {
		return dao.selectUserKey(key);
	}

}
