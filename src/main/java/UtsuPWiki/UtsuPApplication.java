package UtsuPWiki;

import UtsuPWiki.utilities.StartUpManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@Log4j2
@SpringBootApplication
public class UtsuPApplication {
	public static void main(String[] args) {
//		SpringApplication.run(UtsuPApplication.class, args);
		ConfigurableApplicationContext context = new SpringApplicationBuilder(UtsuPApplication.class)
				.listeners(new StartUpManager()).run();
	}
}
