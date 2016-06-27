package org.gms.microservice.consul;

import java.util.List;

import org.gms.microservice.discovery.ServiceDiscovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

@Service
public class ConsulDiscovery implements ServiceDiscovery {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public ServiceInstance discover(String service) {
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(service);
		if(serviceInstances != null && serviceInstances.size() > 0){
			return serviceInstances.get(0);
		}
		return null;
	}

}
