package com.zomato.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.zomato.entity.ZomatoUser;
import com.zomato.service.ZomatoServiceInterface;
import com.zomato.utility.FactoryService;

public class ZomatoController implements ZomatoControllerInterface 
{

	public void createProfileController()
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("enter name");
		String name=sc.next();

		System.out.println("enter password");
		String password=sc.next();
 
		System.out.println("enter email");
		String email=sc.next();

		System.out.println("enter address");
		String address=sc.next();
		
		ZomatoUser zu=new ZomatoUser();
		zu.setName(name);
		zu.setPassword(password);
		zu.setEmail(email);
		zu.setAddress(address);
		
		ZomatoServiceInterface zs=FactoryService.createObject();
		int i=zs.CreateProfileService(zu);
		if(i>0)
		{
			System.out.println("Profile created"+zu.getName());
		}
		else
			System.out.println("unable to create profile");
			
	}

	public void viewProfileController() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		ZomatoUser zu=new ZomatoUser();
		zu.setEmail(email);
		
		ZomatoServiceInterface zs=FactoryService.createObject();
		ZomatoUser z1=zs.viewProfileService(zu);
		if(z1!=null)
		{
			System.out.println("the name is "+z1.getName());
			System.out.println("the password is "+z1.getPassword());
			System.out.println("the email is "+z1.getEmail());
			System.out.println("the address is "+z1.getAddress());
		}
		else
			System.out.println("no profile found");
		
	}

	public void deleteProfileController() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		ZomatoUser zu=new ZomatoUser();
		zu.setEmail(email);
		
		ZomatoServiceInterface zs=FactoryService.createObject();
		int i=zs.deleteProfileServie(zu);
		if(i>0)
			System.out.println("profile deleted");
		else
			System.out.println("profile doesn't exist");
		
	}

	public void viewAllProfileController() 
	{
		ZomatoServiceInterface zs=FactoryService.createObject();
		ArrayList<ZomatoUser> ll=zs.viewAllProfileService();
		
		System.out.println(ll.size()+ "  record found in database");
		for(ZomatoUser r:ll) {
			System.out.println("************************");
			System.out.println("Name is "+r.getName());
			System.out.println("Password is "+r.getPassword());
			System.out.println("Email is "+r.getEmail());
			System.out.println("Address is "+r.getAddress());
		
	}
	}

	public void searchProfileController()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name");
		String name=sc.next();
		
		ZomatoUser zu=new ZomatoUser();
		zu.setName(name);
		
		ZomatoServiceInterface zs=FactoryService.createObject();
		ArrayList<ZomatoUser> ll=zs.searchProfileService(zu);
		for(ZomatoUser r:ll) 
		{
			System.out.println("************************");
			System.out.println("Name is "+r.getName());
			System.out.println("Password is "+r.getPassword());
			System.out.println("Email is "+r.getEmail());
			System.out.println("Address is "+r.getAddress());
		}
		
	}


	public void editProfileController() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the email to edit");
		String email=sc.next();
		
		System.out.println("enter name to be replaced");
		String name1=sc.next();
		System.out.println("enter password to be replaced");
		String password1=sc.next();
		System.out.println("enter email to be replaced");
		String email1=sc.next();
		System.out.println("enter address to be replaced");
		String address1=sc.next();
		
		ZomatoUser zu=new ZomatoUser();
		zu.setEmail(email);
		
		ZomatoUser zu1=new ZomatoUser();
		zu1.setName(name1);
		zu1.setPassword(password1);
		zu1.setEmail(email1);
		zu1.setAddress(address1);
		
		ZomatoServiceInterface zs=FactoryService.createObject();
		int z1=zs.editProfileService(zu,zu1);
		if(z1>0)
		{
			System.out.println("profile edited");
		}
		else
			System.out.println("can't be changed");
	}

}


