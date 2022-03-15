package com.zomato.view;

import java.util.Scanner;

import com.zomato.controller.ZomatoControllerInterface;
import com.zomato.utility.ControllerFactory;

public class ZomatoView {

	public static void main(String[] args) 
	{
		String s="y";
		while(s.equals("y"))
		{
			System.out.println("*****MAIN MENU*****");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to view profile");
			System.out.println("press 3 to delete profile");
			System.out.println("press 4 to viewAll profile");
			System.out.println("press 5 to search profile");
			System.out.println("press 6 to edit profile");
			
			Scanner sc=new Scanner(System.in);

			System.out.println("enter choice");
			int ch=sc.nextInt();
			
			ZomatoControllerInterface zc=ControllerFactory.createObject();
			
			switch(ch)
			{
			case 1:
				zc.createProfileController();
				break;
			case 2:
				zc.viewProfileController();
				break;
			case 3:
				zc.deleteProfileController();
				break;
			case 4:
				zc.viewAllProfileController();
				break;
			case 5:
				zc.searchProfileController();
				break;
			case 6:
				zc.editProfileController();
				break;
				
			default:

				System.out.println("wrong choice");
			}
			System.out.println("do you want to continue y/n");
			s=sc.next();
		}
	}

}
