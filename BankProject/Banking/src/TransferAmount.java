import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TransferAmount")
public class TransferAmount extends HttpServlet {
public void service(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session=request.getSession();
	String accno=(String)session.getAttribute("accno");
	String tamt=request.getParameter("tamt");
	Model m=new Model();
	
	m.setAccno(accno);
	boolean transferamt=m.transferamt(tamt);
	if(transferamt==true)
	{
		try {
			response.sendRedirect("transfersuccess.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
		else {
			try {
				response.sendRedirect("transferfail.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
