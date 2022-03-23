package com.zomato.service;

import java.util.ArrayList;

import com.zomato.entity.ZomatoUser;
import com.zomato.entity.sendMessageDetails;

public interface ZomatoServiceInterface
{

	//int CreateProfileService(ZomatoUser zu);

	ZomatoUser viewProfileService(ZomatoUser zu);

	int deleteProfileServie(ZomatoUser zu);

	ArrayList<ZomatoUser> viewAllProfileService();

	ArrayList<ZomatoUser> searchProfileService(ZomatoUser zu);

	int editProfileService(ZomatoUser zu, ZomatoUser zu1);

	int signUp(ZomatoUser zu);

	ZomatoUser validation(ZomatoUser zu);

	int sendMessageService(sendMessageDetails smd);

}
