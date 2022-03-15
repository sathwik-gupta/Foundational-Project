package com.zomato.utility;

import com.zomato.service.ZomatoService;
import com.zomato.service.ZomatoServiceInterface;

public class FactoryService 
{
	public static ZomatoServiceInterface createObject() 
	{
		return new ZomatoService();
	}
}
