package com.testNG.packs;

import org.testng.annotations.Test;

public class TestNGClassTwo extends TestNGClassOne
{
	@Test
	public void CheckLogin()
	{
		System.out.println("Login Verified SuccessFully");
	}
	
	@Test
	public void CheckDashBoard()
	{
		System.out.println("DashBoard Verified SuccessFully");
	}
	
	@Test
	public void CheckUserDetails()
	{
		System.out.println("Userdetails Verified SuccessFully");
	}
}