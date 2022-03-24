package mypack.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/adminProfilePasswordChange")
public class AdminPasswordValidationFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		
		if(newPassword1.equals(newPassword2))
		chain.doFilter(request, response);
		
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("New password and re-entered new password don't match");
			
			HttpServletRequest httpRequest=(HttpServletRequest)request;
			RequestDispatcher rd = request.getRequestDispatcher("adminpasswordchangepage.jsp");
			rd.include(request, response);
		}
	}

	

}
