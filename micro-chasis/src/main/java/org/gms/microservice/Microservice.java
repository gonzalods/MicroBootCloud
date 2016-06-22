package org.gms.microservice;

import org.springframework.boot.builder.SpringApplicationBuilder;


public abstract class Microservice {

	public void run(String[] args){
		new SpringApplicationBuilder(ChasisConfig.class)
			.sources(getModules())
			.run(args);
	}
	
	public abstract Class<?>[] getModules();
}
