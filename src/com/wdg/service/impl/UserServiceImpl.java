package com.wdg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wdg.dao.UserDao;
import com.wdg.dao.impl.UserDaoImpl;
import com.wdg.bean.PageBean;
import com.wdg.bean.User_reg;
import com.wdg.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao dao = new UserDaoImpl();
	@Override
	public PageBean<User_reg> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <=0) {
            currentPage = 1;
        }
        
        //1.创建空的PageBean对象
        PageBean<User_reg> pb = new PageBean<User_reg>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询记录总数
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User_reg> list = dao.findByPage(start,rows);
        pb.setList(list);

        //5.计算总页码
        //如果总页数除以页数能整除，则返回这个整数，否则整数加1；
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
	}
	
	@Override
	public User_reg findUserById(Integer id) {
		return dao.get(id);
	}

	@Override
	public boolean checkService(String user) {
		return dao.check(user);
	}

	@Override
	public void addService(User_reg u) {
		dao.add(u);
	}

	@Override
	public void delService(Integer id) {
		dao.del(id);
	}

	@Override
	public ArrayList<User_reg> findAllService() {
		return dao.findAll();
	}

	@Override
	public ArrayList<User_reg> findUserService(String user) {
		return dao.findUser(user);
	}

	@Override
	public User_reg getService(Integer id) {
		return dao.get(id);
	}

	@Override
	public void modifyService(User_reg u) {
		dao.modify(u);
	}

	@Override
	public boolean loginService(String user, String pw) {
		return dao.login(user, pw);
	}

	@Override
	public User_reg getNameService(String user) {
		return dao.getName(user);
	}
}
