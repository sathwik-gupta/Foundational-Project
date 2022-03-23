package com.zomato.dao;

import java.util.ArrayList;

import com.zomato.entity.ZomatoUser;
import com.zomato.entity.sendMessageDetails;

public interface ZomatoDAOInterface {

	//int CreateProfileDAO(ZomatoUser zu);

	ZomatoUser viewProfileDao(ZomatoUser zu);

	int deleteProfileDao(ZomatoUser zu);

	ArrayList<ZomatoUser> viewAllProfileDAO();

	ArrayList<ZomatoUser> searchProfileDao(ZomatoUser zu);

	int editProfileDAO(ZomatoUser zu, ZomatoUser zu1);

	ZomatoUser validation(ZomatoUser zu);

	int signUp(ZomatoUser zu);

	int sendMessageDAO(sendMessageDetails smd);

}
