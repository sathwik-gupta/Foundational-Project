package com.zomato.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zomato.entity.ZomatoUser;

public class ZomatoDAO implements ZomatoDAOInterface {

	/*public int CreateProfileDAO(ZomatoUser zu)
	{
		int i=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps=con.prepareStatement("insert into ZomatoUser values(?,?,?,?)");
			ps.setString(1,zu.getName());
			ps.setString(2,zu.getPassword());
			ps.setString(3,zu.getEmail());
			ps.setString(4,zu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}*/

	public ZomatoUser viewProfileDao(ZomatoUser zu)
	{
		ZomatoUser z2=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps=con.prepareStatement("select * from ZomatoUser where email=?");

			ps.setString(1,zu.getEmail());
						
			ResultSet res=ps.executeQuery(); 
			
			
			if(res.next()) 
			{
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				z2= new ZomatoUser();
				z2.setName(n);
				z2.setPassword(p);
				z2.setEmail(e);
				z2.setAddress(a);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return z2;
	}

	public int deleteProfileDao(ZomatoUser zu)
	{
		int i=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps=con.prepareStatement("delete from ZomatoUser where email=?");

			ps.setString(1,zu.getEmail());
			i=ps.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<ZomatoUser> viewAllProfileDAO() 
	{
		
		ZomatoUser z2=null;
		ArrayList<ZomatoUser> ll=new ArrayList<ZomatoUser>();
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
		PreparedStatement ps=con.prepareStatement("select * from ZomatoUser");
		
		ResultSet res=ps.executeQuery();
		while(res.next()) 
		{
			String n=res.getString(1);
			String p=res.getString(2);
			String e=res.getString(3);
			String a=res.getString(4);
			
			z2=new ZomatoUser();
			z2.setName(n);
			z2.setPassword(p);
			z2.setEmail(e);
			z2.setAddress(a);
			
			ll.add(z2);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ll;
	}

	public ArrayList<ZomatoUser> searchProfileDao(ZomatoUser zu) 
	{
		ZomatoUser z2=null;
		ArrayList<ZomatoUser> ll=new ArrayList<ZomatoUser>();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps=con.prepareStatement("select * from ZomatoUser where name=?");

			ps.setString(1,zu.getName());
						
			ResultSet res=ps.executeQuery(); 
			
			while(res.next()) 
			{
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				z2=new ZomatoUser();
				z2.setName(n);
				z2.setPassword(p);
				z2.setEmail(e);
				z2.setAddress(a);
				
				ll.add(z2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ll;
	}

	public int editProfileDAO(ZomatoUser zu, ZomatoUser zu1) 
           	{
		int i=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps=con.prepareStatement("update ZomatoUser set name = ?, password = ?, email = ?, address=? where email=?");
			ps.setString(1,zu1.getName());
			ps.setString(2,zu1.getPassword());
			ps.setString(3,zu1.getEmail());
			ps.setString(4,zu1.getAddress());
			
			ps.setString(5,zu.getEmail());
			i=ps.executeUpdate();
			    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}

	public ZomatoUser validation(ZomatoUser zu)
	{
		ZomatoUser data = null;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			PreparedStatement ps = con.prepareStatement("select * from ZomatoUser where email=?");
			
			ps.setString(1, zu.getEmail1());
			
			ResultSet s1 =ps.executeQuery();
			if(s1.next())
			{
				
				String e=s1.getString(3);
				String p=s1.getString(2);
				
				data=new ZomatoUser();
				
				data.setPassword(p);
				data.setEmail(e);
				
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}

	public int signUp(ZomatoUser zu)
	{
		int i=0;
		PreparedStatement ps = null;
		try 
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","database");
			ps = con.prepareStatement("insert into ZomatoUser values(?,?,?,?)");
			
			ps.setString(1, zu.getName());
			ps.setString(2, zu.getPassword());
			ps.setString(3, zu.getEmail());
			ps.setString(4, zu.getAddress());			
			
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			if(ps!=null) 
			{
					try 
					{
						ps.close();
					}
				catch (SQLException e) 
					{
					e.printStackTrace();
					}
			}
		}
		return i;
		
	}
}
