import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet{

public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session= request.getSession();
	String accno=(String) session.getAttribute("accno");

	Model m=new Model();
	m.setAccno(accno);
	
	
	ArrayList statement=m.getStatement();
	
	session.setAttribute("statement", statement);
	
	
	if(statement.isEmpty())
	{
		try {
			response.sendRedirect("getstmtfail.jsp");
	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	else {
		try {
			response.sendRedirect("getstmtsuccess.jsp");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}
}
