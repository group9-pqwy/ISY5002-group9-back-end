package nus.iss.ais.petoria;

import nus.iss.ais.petoria.config.TelegramBotConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(TelegramBotConfig.class)
public class PetoriaApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PetoriaApplication.class, args);
	}
}
