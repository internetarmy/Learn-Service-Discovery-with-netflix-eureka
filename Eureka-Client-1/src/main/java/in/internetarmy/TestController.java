package in.internetarmy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client1/")
public class TestController {

	@GetMapping("/test-microservice/{id}")
	public String sourceMicroservice(@PathVariable String id) {
		return "The provided id is: "+id;
	}
}
