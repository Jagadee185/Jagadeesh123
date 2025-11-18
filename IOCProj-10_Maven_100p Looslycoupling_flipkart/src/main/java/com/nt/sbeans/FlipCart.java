package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("flip")
public class FlipCart 
{
	@Autowired
	@Qualifier("dtdc")
	private Courier courier;
	
	
	public FlipCart() 
	{
		System.out.println("FlipCart.FlipCart() created");
	}
	
	//b method
	
	public String shopping(String[] items,double [] prices)
	{
		// get priecss
		double totalAmount=0.0;
		
		for(double p:prices)
			totalAmount=totalAmount+p;
		
		//get order id
		int oid=new Random().nextInt(10000);
		String msg=courier.deliver(oid);
		return Arrays.toString(items)+" with bill Amount is"+oid+msg;
		
		
	}
	
}
