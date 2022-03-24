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

import mypack.entity.Users;
import mypack.service.UsersService;


@WebFilter("/userRegistration")
public class AlreadyUserFilter extends HttpFilter implements Filter {
       
   
    public AlreadyUserFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userId = request.getParameter("emailId");
		Users u = new Users();
		u.setEmailId(userId);
		UsersService service = new UsersService();
		boolean status = service.checkAlreadyUser(u);
		if(status == false)
		chain.doFilter(request, response);
		
		else {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("Already a user. Login with your credentials");
			
			HttpServletRequest httpRequest=(HttpServletRequest)request;
			RequestDispatcher rd = request.getRequestDispatcher("userloginpage.jsp");
			rd.include(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
