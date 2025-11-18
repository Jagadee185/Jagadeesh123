package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public class DTDC  implements Courier
{

	@Override
	public String deliver(int oid)
	{
		
		return oid+" these items are kept fot delivery using DTDC";
	}
	

}
