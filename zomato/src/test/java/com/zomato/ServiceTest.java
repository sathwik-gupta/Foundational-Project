package com.zomato;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zomato.entity.sendMessageDetails;
import com.zomato.entity.ZomatoUser;
import com.zomato.service.ZomatoService;
import com.zomato.service.ZomatoServiceInterface;

public class ServiceTest {
	ZomatoServiceInterface wsi = null;
	ZomatoUser zu = new ZomatoUser();
	ZomatoUser zu1= new ZomatoUser();
	sendMessageDetails tld = new sendMessageDetails();
	@Before
	public void setUp() throws Exception {
		wsi = new ZomatoService();
	}

	@After
	public void tearDown() throws Exception {
		wsi = null;
	}

	@Test
	public void testViewAllprofile() {
		ArrayList<ZomatoUser> viewall = wsi.viewAllProfileService();
		assert viewall!=null:"view all profile test case failed";
	}

	@Test
	public void testViewProfile() {
		zu.setEmail("sat@gmail.com");
		ZomatoUser view = wsi.viewProfileService(zu);
		assert view!=null:"profile doesnot exist";
	}

	@Test
	public void testDeleteProfile() {
		zu.setEmail("sat@gmail.com");
		int i = wsi.deleteProfileServie(zu);
		assert i>0:"profile not deleted";
	}

	@Test
	public void testEditProfile() {
		zu.setEmail("sat@gmail.com");
		zu.setName("Sath");
		int i = wsi.editProfileService(zu,zu1);
		assert i>0:"first name not editted";
	}

	@Test
	public void testSignUp() {
		/*wud.setUserid("ranga123");
		wud.setFirstname("parkan");
		wud.setLastname("ranganath");
		wud.setEmail("ranganath@gmail.com");
		wud.setPassword("ranganath123");*/
		
		zu.setName("sathwik");
		zu.setAddress("wgl");
		zu.setEmail("sat@gmail.com");
		zu.setPassword("sath");
		int i = wsi.signUp(zu);
		
		assert i>0:"signup failed";
	}

	@Test
	public void testValidation() {
		zu.setEmail1("sat@gmail.com");
		zu.setPassword1("sath");
		ZomatoUser vali = wsi.validation(zu);
		assert vali!=null:"profile doesnot exist";
	}

	@Test
	public void testSendMessage() {
		tld.setMessageid("1");
		tld.setSender("sat@gmail.com");
		tld.setMessage("hello");
		tld.setDate1("12-08-2022");
		tld.setReceiver("kish@gmail.com");
		int i = wsi.sendMessageService(tld);
		assert i>0:"timeline failed";
	}

	@Test
	public void testSearchProfile() {
		zu.setName("Sath");
		List<ZomatoUser> search = wsi.searchProfileService(zu);
		assert search!=null:"search not found";
	}

}