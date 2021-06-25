import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ApplyLoan")
public class ApplyLoan extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response)
{
	
	HttpSession session=request.getSession(true);	
	String accno=(String) session.getAttribute("accno");
	
	
	Model  m=new Model();
	m.setAccno(accno);
	
	boolean loan=m.applyloan();

	String emailid=m.getEmailid();
	
	
	if(loan==true)
	{
		
		session.setAttribute("emailid", emailid);
	try {
		
	response.sendRedirect("loansuccess.jsp");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
	
	else
	{
		try {
			response.sendRedirect("loandeclined.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	
}
