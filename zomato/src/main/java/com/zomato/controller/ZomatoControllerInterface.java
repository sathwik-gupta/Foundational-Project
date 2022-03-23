package com.zomato.controller;

import java.util.ArrayList;
import java.util.List;

import com.zomato.entity.ZomatoUser;

public interface ZomatoControllerInterface 
{

	//void createProfileController();

	ZomatoUser viewProfileController();

	int deleteProfileController();

	ArrayList<ZomatoUser> viewAllProfileController();

	List<ZomatoUser> searchProfileController();

	ZomatoUser editProfileController();

	int signUp();

	int signIn();

	int sendMessageController();

}
