import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Model {

	String url="jdbc:mysql://localhost:3306/lms";
	String user="root";
	String pwd="Sharu@123";
	
	java.sql.PreparedStatement pstmt;
	ResultSet res;
	String name,accno,custid,password,ifsc,emailid;
	int balance;
	int contactno;
	Connection con;
	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getContactno() {
		return contactno;
	}

	public void setContactno(int contactno) {
		this.contactno = contactno;
	}

	

	public Model()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=	(Connection) DriverManager.getConnection(url,user,pwd);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public boolean login() {
		try
		{
			String s="select * from lms.banking where custid=? and password=?";
			pstmt= (PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, custid);
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			while(res.next()==true) {
				name=res.getString(1);
				accno=res.getString(2);
				balance=res.getInt(7);
				
				return true;
			}
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	
	}

	public boolean checkbalance() {
		String s="select * from lms.banking where accno=?";
		try {
			pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, accno);
			
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean applyloan() 
	{
		String s="select * from lms.banking where accno=?";
		try {
			pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				
				emailid=res.getString(6);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	public boolean changepwd() {
		String s="update lms.banking set password=? where accno=?";
		
		try {
		pstmt=(PreparedStatement) con.prepareStatement(s);
		pstmt.setString(1, password);
		pstmt.setString(2, accno);
		int x=pstmt.executeUpdate();
		if(x==1)
		{
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	public boolean transferamt(String tamt) {
		
		String s="update lms.banking set balance=balance-? where accno=?";
		try {
			pstmt=(PreparedStatement) con.prepareStatement(s);
			pstmt.setString(1, tamt);
			pstmt.setString(2, accno);
			int x=pstmt.executeUpdate();
			if(x==1)
			{
				String s1="insert into lms.statement values(?,?)";
				pstmt=(PreparedStatement) con.prepareStatement(s1);
				pstmt.setString(1, accno);
				pstmt.setString(2, tamt);
				pstmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList getStatement() {
		String s="select * from lms.statement where accno=?";
		
		try {
		ArrayList al=new ArrayList();
		pstmt= con.prepareStatement(s);
		pstmt.setString(1, accno);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			
			al.add(res.getInt(2));
			System.out.println(al);
			
		}
		return al;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
		
	}

	
	}
	
	
