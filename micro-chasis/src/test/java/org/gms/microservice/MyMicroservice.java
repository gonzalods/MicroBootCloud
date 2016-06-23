package org.gms.microservice;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

@SpringBootApplication
public class MyMicroservice extends Microservice {

	
	
	@Override
	public Class<?>[] getModules() {
		return new Class<?>[]{
			MyMicroservice.class
		};
	}

	public static void main(String[] args) {
		new MyMicroservice().run(args);

	}

	@Component
	@Path("/")
	public static class DumbResource{
		
		@Autowired
		private Environment env;
		
		@Autowired
		public DumbResource(JerseyConfig jerseyConfig){
			jerseyConfig.register(DumbResource.class);
		}
		@GET
		@Produces("application/json")
		public Map<String, String> getResource(){
			return ImmutableMap.of("sample.config", env.getProperty("sample.config"),
					"microservice.name", env.getProperty("spring.application.name"));
		}
	}
	
}
