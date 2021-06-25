import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response)
	
{
	String custid=request.getParameter("custid");
	String pwd=request.getParameter("pwd");
	Model  m=new Model();
	m.setCustid(custid);
	m.setPassword(pwd);
	 
	boolean login=m.login();
	int balance=m.getBalance();
	String name=m.getName();
	String accno=m.getAccno();
	
	
	
	
	
	if(login==true)
	{
		
			
	HttpSession session=request.getSession(true);
	session.setAttribute("name", name);
	session.setAttribute("accno", accno);
	session.setAttribute("balance", balance);
	


	
	try {
	response.sendRedirect("home.jsp");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
	
	else
	{
		try {
			response.sendRedirect("loginfail.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	
	
	
	
}