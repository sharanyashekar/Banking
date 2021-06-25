

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class ChangePwdFilter
 */
@WebFilter("/ChangePwdFilter")
public class ChangePwdFilter  implements Filter  {

   

	/**
     * Default constructor. 
     */
    public ChangePwdFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String np=request.getParameter("npwd");
		String cp=request.getParameter("cpwd");
		
		
		if(np.equals(cp)==true)
		{
			
	
			RequestDispatcher reqd=request.getRequestDispatcher("/ChangePassword");
			reqd.include(request, response);
			((javax.servlet.http.HttpServletResponse) response).sendRedirect("changepwdsuccess.jsp");
			
		}
		
		else
		{
		((javax.servlet.http.HttpServletResponse) response).sendRedirect("changepwdfail.jsp");
		}
	}


	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
