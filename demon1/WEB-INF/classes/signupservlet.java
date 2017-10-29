import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class signupservlet extends HttpServlet
{
	
	String firstName;
	String lastName;
    String emailId;
    String eemailId;
	String phoneNumber;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	public static void registerCustomer(String firstName, String emailId,String eemailId, String phoneNumber)
	{
		try
		{
			Connection conn = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://sher.cvddnfvcff4w.us-east-1.rds.amazonaws.com:3306/demon?autoReconnect=true&useSSL=false", "admin", "password");
			String insertInto = "INSERT INTO Relation(ID,EID, Name,Phone) " + "VALUES (?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertInto);
			
			pst.setString(1,emailId);
			pst.setString(2,eemailId);
			pst.setString(3,firstName);
			
			pst.setString(4,phoneNumber);
			
			pst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	firstName = request.getParameter("firstName");
	emailId = request.getParameter("emailId");
	eemailId = request.getParameter("eemailId");
	phoneNumber = request.getParameter("phoneNumber");

    try{
       
    }catch(NumberFormatException ex){ // handle your exception
       
    }


	
	
	
	if(firstName != null && firstName.length() != 0)
		firstName = firstName.trim();

	if(phoneNumber != null && phoneNumber.length() != 0)
        phoneNumber = phoneNumber.trim();

	if(emailId != null && emailId.length() != 0)
        emailId = emailId.trim();
    if(eemailId != null && eemailId.length() != 0)
        eemailId = eemailId.trim();


    else
	{
		out.println("<h3>The following error may have occured:<h3>");
		out.println("<p>1: Any one field may have been kept empty</p>");
		out.println("<p>2: Passwords do not match</p>");
		out.println("<p>Please go back and try again !</p>");
		
	}
			
		
			registerCustomer(firstName, emailId,eemailId,phoneNumber);
		
			out.println("<!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>Safe Track</title>");
			out.println("<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" /></head><body><div id=\"container\">");
			out.println("<header><h1><a href=\"/\">Safe<span>Track</span></a></h1><h2>Track your safety with us</h2></header>");
			out.println("<h3 align=\"center\">Account Created Successfully. Please Login to continue</h3>");
			out.println("</div></body></html>");
			
	
	
	
	out.println("</div></fieldset></article</div></div></body></html>");
	out.close();
	
	}
	
	public static void main(String[] arg){
		//registerCustomer("firstName", "lastName", "emailId",111);
	}
}
