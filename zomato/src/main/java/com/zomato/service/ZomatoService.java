package com.zomato.service;

import java.util.ArrayList;

import com.zomato.dao.ZomatoDAOInterface;
import com.zomato.entity.ZomatoUser;
import com.zomato.utility.FactoryDAO;

public class ZomatoService implements ZomatoServiceInterface {

	public int CreateProfileService(ZomatoUser zu) 
	{
		int i=0;
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		i=zd.CreateProfileDAO(zu);
		return i;
	}

	public ZomatoUser viewProfileService(ZomatoUser zu) 
	{
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		ZomatoUser z1=zd.viewProfileDao(zu);
		return z1;		
	}

	public int deleteProfileServie(ZomatoUser zu) 
	{
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		int i=zd.deleteProfileDao(zu);
		return i;
	}

	public ArrayList<ZomatoUser> viewAllProfileService() 
	{
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		ArrayList<ZomatoUser> z=zd.viewAllProfileDAO();
		return z;
	}


	public ArrayList<ZomatoUser> searchProfileService(ZomatoUser zu) 
	{
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		ArrayList<ZomatoUser> z1=zd.searchProfileDao(zu);
		return z1;	
	}

	public int editProfileService(ZomatoUser zu, ZomatoUser zu1) 
	{
		ZomatoDAOInterface zd=FactoryDAO.createObject();
		int z1=zd.editProfileDAO(zu,zu1);
		return z1;
	}

}
