package pers.river.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wdg.bean.Log;
import com.wdg.dao.LogDao;
import com.wdg.dao.impl.LogDaoImpl;

public class LogInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle");
		Log log = new Log();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		log.setLoginTime(dateFormat.format(date).toString());
		HttpSession session = request.getSession();//重要:此处要进行初始化,否则request.getSession().getAttribute可能会报空指针
		log.setName(session.getAttribute("username").toString());
		LogDao dao = new LogDaoImpl();
		log.setId(dao.getId(session.getAttribute("username").toString()));
		dao.insertLog(log);
		System.out.println("登陆日志添加成功");
		return true;
	}

}
