package com.zomato.utility;

import com.zomato.controller.ZomatoController;
import com.zomato.controller.ZomatoControllerInterface;

public class ControllerFactory 
{
	public static ZomatoControllerInterface createObject()
	{
		return new ZomatoController();
	}
}
