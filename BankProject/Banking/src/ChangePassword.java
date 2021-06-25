import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
public void service(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session=request.getSession();
	String accno=(String)session.getAttribute("accno");
	String npwd=request.getParameter("npwd");
	

	Model  m=new Model();
	m.setAccno(accno);
	m.setPassword(npwd);
	
	boolean changepwd=m.changepwd();
	if(changepwd==true)
	{
		try {
			response.sendRedirect("changepwdsuccess.jsp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	else {
		try {
			response.sendRedirect("changepwdfail.jsp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	
}
}
