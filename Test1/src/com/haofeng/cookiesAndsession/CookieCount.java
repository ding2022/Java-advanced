package com.haofeng.cookiesAndsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.INTERNAL;

/**
 * Servlet implementation class CookieCount
 */
@WebServlet("/CookieCount")
public class CookieCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookiesname,numString;
		cookiesname="numString";
		numString="1";
		
		Cookie[] cks=request.getCookies();
		if(cks!=null){
			for(int i=0;i<cks.length;i++){
				Cookie tempCK=cks[i];
				if(cookiesname.equals(tempCK.getName())){
					numString=tempCK.getValue();
				}
			}
		}
		int num=0;
		try {
			num=Integer.parseInt(numString);
		} catch (Exception e) {
		}
		Cookie myCookie=new Cookie("numString",String.valueOf(num+1));
		myCookie.setMaxAge(60*60*24);
		response.addCookie(myCookie);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title="User Access Count";
		String docType="<! DOCTYPE HTML PUBLIC \"-//W3C//DTD FTML 4.0 Transitional //EN\">\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>"+title+"</title></head>"+
				"<body>\n"+
				"<h1>Access Count is :"+num+"</h1>"+
				"</body></html>"
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
