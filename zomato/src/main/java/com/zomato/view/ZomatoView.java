package com.zomato.view;
import java.util.Scanner;
import java.util.logging.Logger;

import com.zomato.controller.ZomatoControllerInterface;
import com.zomato.utility.ControllerFactory;

public class ZomatoView {

	public static void main(String[] args) 
	{
		Logger log=Logger.getLogger("ZomatoController");
		ZomatoControllerInterface zc=ControllerFactory.createObject();
		int s1;
		
		String s="y";
		while(s.equals("y"))
		{
			log.info("*************");
			log.info("Welcome to Zomato");
			log.info("Sign-up/Sign-in To Order");
			log.info("*************");
			log.info("Press 1 to Sign-up");
			log.info("Press 2 to Sign-in");
			
			Scanner sc=new Scanner(System.in);
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				zc.signUp();
				break;
			case 2:
				s1=zc.signIn();
				if(s1==1)
				{
					while(s.equals("y"))
					{
						System.out.println("*****MAIN MENU*****");
						
						System.out.println("press 1 to view profile");
						System.out.println("press 2 to delete profile");
						System.out.println("press 3 to viewAll profile");
						System.out.println("press 4 to search profile");
						System.out.println("press 5 to edit profile");
						System.out.println("press 6 to send message");

						System.out.println("enter choice");
						ch=sc.nextInt();
			
						switch(ch)
						{
						case 1:
							zc.viewProfileController();
							break;
						case 2:
							zc.deleteProfileController();
							break;
						case 3:
							zc.viewAllProfileController();
							break;
						case 4:
							zc.searchProfileController();
							break;
						case 5:
							zc.editProfileController();
							break;
						case 6:
							zc.sendMessageController();
							break;
						default: 
							System.out.println("wrong choice");
						}
						
						System.out.println();
						System.out.println("do you want to continue y/n");
						s=sc.next();
					}
				}
				else
					System.out.println("OOPS! You entered the wrong password \n If not registered press 1 to sign-up");
				break;
			}

			System.out.println();
			System.out.println();
			log.info("do you want to continue y/n");
			s=sc.next();
		}
	}
}
