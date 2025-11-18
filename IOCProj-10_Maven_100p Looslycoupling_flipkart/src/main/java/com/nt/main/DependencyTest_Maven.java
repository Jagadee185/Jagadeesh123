package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.FlipCart;

public class DependencyTest_Maven

{

	public static void main(String[] args) 
	{
		try(AnnotationConfigApplicationContext ctx
				=new AnnotationConfigApplicationContext(AppConfig.class);)
		{
			
			//get target spring bean id
			FlipCart fkpk=ctx.getBean("flip",FlipCart.class);
			String msg=fkpk.shopping(new String[] {"shirts"}, new double[] {1000});
			System.out.println(msg);
			
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}

	}

}
