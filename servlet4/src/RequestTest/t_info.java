package RequestTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class t_info
 */
@WebServlet("/t_info")
public class t_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public t_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(request.getScheme()+"<br/>");
		response.getWriter().write(request.getServerName()+"<br/>");
		response.getWriter().write(request.getServerPort()+"<br/>");
		response.getWriter().write(request.getContextPath()+"<br/>");
		response.getWriter().write(request.getServletPath()+"<br/>");
		response.getWriter().write(request.getQueryString()+"<br/>");
		response.getWriter().write(request.getRequestURI()+"<br/>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
