

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * Servlet Filter implementation class TransferFilter
 */
@WebFilter("/TransferFilter")
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session=((HttpServletRequest) request).getSession();
		int amt=Integer.parseInt(request.getParameter("tamt"));
		int balance=(int) session.getAttribute("balance");
		System.out.println(amt);
		System.out.println(balance);
		if(amt<balance && amt>0)
		{
			
			RequestDispatcher reqd=request.getRequestDispatcher("/TransferAmount");
			reqd.include(request, response);
			((javax.servlet.http.HttpServletResponse) response).sendRedirect("transfersuccess.jsp");
		}
		
		else
		{
		((javax.servlet.http.HttpServletResponse) response).sendRedirect("transferfail.jsp");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
