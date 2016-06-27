package org.gms.microservice.discovery;

import org.springframework.cloud.client.ServiceInstance;

public interface ServiceDiscovery {

	ServiceInstance discover(String service);
}
