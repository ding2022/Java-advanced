package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String vcode=request.getParameter("vcode");
		String tvcode=(String) request.getSession().getAttribute("session_vcode");
		
		if(!vcode.equalsIgnoreCase(tvcode)){
			request.setAttribute("msg2", "验证码错误");
			request.getRequestDispatcher("/login_session/login.jsp").forward(request, response);
			return;
		}
		if(user.equals("aaa")&&pass.equals("bbb")){
			/*
			 * 把用户名保存到cookie中，发送给客户端浏览器
			 * 当再次打开登录时，显示到文本框中
			 */
			Cookie c=new Cookie("user", user);
			c.setMaxAge(24*60*60);
			response.addCookie(c);
			
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("pass", pass);
			response.sendRedirect(request.getContextPath()+"/login_session/succ1.jsp");
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login_session/login.jsp").forward(request, response);
		}
	
	}

}
