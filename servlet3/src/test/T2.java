package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T2
 */
public class T2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("T2.doGet()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("T2.doPost()");
		ServletConfig config = getServletConfig();
//		System.out.println(config.getInitParameter("p1"));
		System.out.println(this.getClass().hashCode());
		System.out.println(config.getServletContext());
		try {
			new Thread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
