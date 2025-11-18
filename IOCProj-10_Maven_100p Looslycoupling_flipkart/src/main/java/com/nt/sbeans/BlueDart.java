package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bdart")
public class BlueDart implements Courier
{

	

	@Override
	public String deliver(int oid)
	{
		
		return oid +" these items are kept fot delivery using blueDart";
	}

}
