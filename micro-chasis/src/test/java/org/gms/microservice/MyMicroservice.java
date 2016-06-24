package org.gms.microservice;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
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

@RestController
@RefreshScope
@RequestMapping("/")
class DumbResource{
	
	@Value("${spring.application.name}")
	private String name;
	
	@Value("${sample.config}")
	private String config;
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, String> getResource(){
		
		return Collections.unmodifiableMap(Stream.of(
				new AbstractMap.SimpleEntry<>("application.name", name),
				new AbstractMap.SimpleEntry<>("sample.config", config))
				.collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
	}
}
