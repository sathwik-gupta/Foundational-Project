package com.zomato.utility;

import com.zomato.dao.ZomatoDAO;
import com.zomato.dao.ZomatoDAOInterface;

public class FactoryDAO 
{

	public static ZomatoDAOInterface createObject() 
	{
		// TODO Auto-generated method stub
		return new ZomatoDAO();
	}

}
