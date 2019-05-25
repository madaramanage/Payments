package models;

import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class Payments 
{

	public String getPayments() 
	{             
		String paymentsGrid = null;             
		Connection con = null;             
		Statement st = null;             
		ResultSet rs = null;       
		
		try {       
			con = DBConnection.createConnection();     
			st = con.createStatement();    
			rs = st.executeQuery("select * from payments");     
			
			if (rs.first())       
			{ 
				paymentsGrid = "<table border='1' cellspacing='1' cellpadding='1'>"
						+ "<tr>"
						+ "<th>No</th>"
						+ "<th>Name</th>"
						+ "<th>Description</th>"
						+ "<th>Edit</th>"
						+ "<th>Delete</th>"
						+ "</tr>"; 
				rs.beforeFirst(); 
				
				while(rs.next())  
				{   
					paymentsGrid = paymentsGrid + "<tr><td>" + rs.getString(1) + 
							"</td>"      + "<td>" + rs.getString(2) + "</td>"     
							+ "<td>" + rs.getString(3) + "</td>"      
							+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"  param=\"" 
							+ rs.getString(1) + "\" value=\"Edit\"</td>"      
							+ "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\"" 
							+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";                        
				} 
				
			}                   
			else                         
				paymentsGrid = "There are no payments...";                   
				paymentsGrid = paymentsGrid + "</table></br>";             
			}             
		catch (SQLException e) 
		{                   
			e.printStackTrace();             
		}             
		
		return paymentsGrid;       
		
		}       
	
		public String saveAnPayment(String itmName,  String accno, String Address) 
		{
			String res = null;             
			String sql = null;            
			Connection con = null;             
			Statement st = null;             
			try 
			{                   
				con = DBConnection.createConnection();                  
				st = con.createStatement();                  
				sql = "insert into payments (nameitems, acc, addr ) values ('" + itmName + "', '" + accno + "' , '" + itmName + "')";                   
				st.executeUpdate(sql);                   
				res = "Successfully inserted...";             
			}             
			catch (SQLException e) 
			{                   
				e.printStackTrace();             
			}             
			
			return res;       
			
		}
			}
		
		
	


