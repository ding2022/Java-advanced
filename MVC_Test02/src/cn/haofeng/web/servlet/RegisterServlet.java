package cn.haofeng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.haofeng.domin.User;
import cn.haofeng.service.UserException;
import cn.haofeng.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * 封装表单数据到user对象中
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserService userService = new UserService();

		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String vcode = request.getParameter("vcode");

		User form = new User(name, pass, vcode);

		try {
			userService.regist(form);
			response.getWriter().print(
					"<h1><font color='green'>注册成功</font><h1><br><a href='" + request.getContextPath()
							+ "/user/login.jsp" + "'>点击登录</a>");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher(
					 "/user/register.jsp").forward(
					request, response);
		}
	}

}
