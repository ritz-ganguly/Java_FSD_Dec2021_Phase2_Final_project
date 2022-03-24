package mypack.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


@WebFilter("/userRegistration")
public class CheckUserPhoneNumberFilter extends HttpFilter implements Filter {
       
   
    public CheckUserPhoneNumberFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String mobile = request.getParameter("mobile"); 
		Pattern p = Pattern.compile("[1-9][0-9]{9}");
		Matcher m = p.matcher(mobile);
		boolean status = m.matches();
		if(status == true)
		chain.doFilter(request, response);
		
		else {
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("Not a valid phone number");
			
			HttpServletRequest httpRequest=(HttpServletRequest)request;
			RequestDispatcher rd = request.getRequestDispatcher("loginsignup.jsp");
			rd.include(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
