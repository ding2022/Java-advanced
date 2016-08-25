package servletCom.copy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/MyServlet1")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	/*public MyServlet1() {
		super();
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		RequestDispatcher summary = getServletContext().getRequestDispatcher(
				"/MyServlet2");
		if (summary != null) {
			try {
				summary.include(request, response);
			} catch (IOException e) {

			} catch (ServletException e) {
			}
		} else if (summary == null) {
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<head><title>Error</title></head>");
			out.print("<body>");
			out.print("<big>Summary is null</big>");
			out.print("</body></html>");
		}
	}

}
