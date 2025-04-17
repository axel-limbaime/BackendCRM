package gp2.SCRMproj.Gateway_service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class GatewayServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceRegistryApplication.class, args);
	}

}
