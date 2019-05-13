package razdwatrzy.zzpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ZzpjApplication {

	@RequestMapping("/")
	String home() {
		return "Test OK";
	}

	public static void main(String[] args) {
		SpringApplication.run(ZzpjApplication.class, args);
	}

}
