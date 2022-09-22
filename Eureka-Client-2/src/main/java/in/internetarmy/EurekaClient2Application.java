package in.internetarmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClient2Application {

	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

}
