package aplicactions.ticas.appticas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"aplicactions.ticas.appticas", "aplicactions.ticas.appticas.service"})
public class AppticasApplication {


	public static void main(String[] args) {

		SpringApplication.run(AppticasApplication.class, args);
	}

}
