package in.internetarmy;

import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client2")
public class TestController {
	
	@Autowired
	private RestTemplate rt;
	
	@Autowired
    private LoadBalancerClient loadBalancerClient;

	private URI getErrorEurekaInsId() {
		try {
			return loadBalancerClient.choose("EUREKA_CLIENT-1").getUri();
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping("/callService/{id}")
	public String test(@PathVariable String id) throws MalformedURLException {
		URI uri = getErrorEurekaInsId();
		String url = uri.toURL().toString()+"/client1/test-microservice/"+id;
		System.out.println(url);
		return rt.getForObject(url, String.class);
//		return rt.getForObject("http://EUREKA_CLIENT-1/client1/test-microservice/1", String.class);
	}
}
