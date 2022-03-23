package com.zomato;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zomato.controller.ZomatoController;
import com.zomato.controller.ZomatoControllerInterface;
import com.zomato.entity.ZomatoUser;

public class ControllerTest
{	
	ZomatoControllerInterface zc = null;

	@Before
	public void setUp() throws Exception {
		zc = new ZomatoController();
	}

	@After
	public void tearDown() throws Exception {
		zc=null;
	}
	
	@Test
	public void testSignUp() {
		int i = zc.signUp();
		assert i>0:"test sign up is failed";
	}
	
	@Test
	public void testSignIn() {
		int i = zc.signIn();
		assert i>0:"test sign in is failed";
	}

	@Test
	public void testViewAllProfile() {
		ArrayList<ZomatoUser> viewall = zc.viewAllProfileController();
		assert viewall!=null:"test view all profile is failed";
		
	}

	@Test
	public void testViewProfile() {
		ZomatoUser view = zc.viewProfileController();
		assert view!= null:"test view profile is failed";
	}

	@Test
	public void testDeleteProfile() {
		int i = zc.deleteProfileController();
		assert i>0:"test delete profile is failed";
	}

	@Test
	public void testEditProfile() {
		ZomatoUser i = zc.editProfileController();
		assert i!=null:"test edit profile is failed";
	}

	

	

	@Test
	public void testTimeline() {
		int i = zc.sendMessageController();
		assert i>0:"test timeline is failed";
	}

	@Test
	public void testSearchProfile() {
		List<ZomatoUser> search = zc.searchProfileController();
		assert search!=null:"test search profile is failed";
	}
}
