package org.gms.microservice.health;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthResource {

	@RequestMapping(value="/health", method=RequestMethod.GET)
	public Map<String, Boolean> health(){
		return Collections.singletonMap("health", true);
	}
}
