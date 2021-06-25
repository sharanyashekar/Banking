import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckBalance")
public class CheckBalance extends HttpServlet{
	


	public void service(HttpServletRequest request,HttpServletResponse response)
	{
	HttpSession session=request.getSession();	
	String accno=(String) session.getAttribute("accno");

	
	Model  m=new Model();
	m.setAccno(accno);
	
	
boolean checkbal=m.checkbalance();
if(checkbal==true)
{
	try {
		response.sendRedirect("CheckBalSuccess.jsp");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

else
{
	try {
		response.sendRedirect("CheckBalFail.jsp");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	}
}
