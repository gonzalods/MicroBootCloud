package org.gms.microservice;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		public DumbResource(JerseyConfig jerseyConfig){
			jerseyConfig.register(DumbResource.class);
		}
		@GET
		@Produces("application/json")
		public Map<String, Boolean> getResource(){
			return ImmutableMap.of("value", true);
		}
	}
	
}
