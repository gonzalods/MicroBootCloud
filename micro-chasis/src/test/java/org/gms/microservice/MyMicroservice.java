package org.gms.microservice;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public class MyMicroservice extends Microservice {

	
	
	@Override
	public Class<?>[] getModules() {
		return new Class<?>[]{
		};
	}

	public static void main(String[] args) {
		new MyMicroservice().run(args);

	}
}

//@RestController
@RequestMapping("/")
class DumbResource{
	
	//@Value("${discovery.consul.host}")
	private String consul_host;
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, String> getResource(){
		return Collections.singletonMap("discovery.consul.host", consul_host);
	}
}