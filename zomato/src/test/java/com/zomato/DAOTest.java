package com.zomato;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zomato.dao.ZomatoDAO;
import com.zomato.dao.ZomatoDAOInterface;
import com.zomato.entity.sendMessageDetails;
import com.zomato.entity.ZomatoUser;

public class DAOTest 
{
	ZomatoDAOInterface wd=null;
	ZomatoUser zu = new ZomatoUser();
	ZomatoUser zu1 = new ZomatoUser();
	sendMessageDetails tld = new sendMessageDetails();
	@Before
	public void setUp() throws Exception {
		wd = new ZomatoDAO();
	}

	@After
	public void tearDown() throws Exception {
		wd = null;
	}

	@Test
	public void testSignUp() {
		zu.setName("sathwik");
		zu.setAddress("wgl");
		zu.setEmail("sat@gmail.com");
		zu.setPassword("sath");
		
		int i = wd.signUp(zu);
		
		assert i>0:"signup failed";
	}

	@Test
	public void testValidation() {
		zu.setEmail1("sat@gmail.com");
		zu.setPassword1("sath");
		ZomatoUser vali = wd.validation(zu);
		assert vali!=null:"profile doesnot exist";
	}

	@Test
	public void testViewAllProfile() {
		ArrayList<ZomatoUser> viewall = wd.viewAllProfileDAO();
		assert viewall!=null:"view all profile test case failed";
	}

	@Test
	public void testViewProfile() {
		zu.setEmail("sat@gmail.com");
		ZomatoUser view = wd.viewProfileDao(zu);
		assert view!=null:"profile doesnot exist";
	}

	@Test
	public void testEditFirstName() {
		zu.setEmail("sat@gmail.com");
		zu.setName("Sath");
		int i = wd.editProfileDAO(zu,zu1);
		assert i>0:"first name not editted";
	}

	@Test
	public void testTimeline() {
		tld.setMessageid("1");
		tld.setSender("sat@gmail.com");
		tld.setMessage("hello");
		tld.setDate1("12-08-2022");
		tld.setReceiver("kish@gmail.com");
		int i = wd.sendMessageDAO(tld);
		assert i>0:"timeline failed";
	}

	@Test
	public void testSearchProfile() {
		zu.setName("Sath");
		List<ZomatoUser> search = wd.searchProfileDao(zu);
		assert search!=null:"search not found";
	}

	@Test
	public void testDeleteProfile() {
		zu.setEmail("sat@gmail.com");
		int i = wd.deleteProfileDao(zu);
		assert i>0:"profile not deleted";
	}
}
