package api.utfpr.ddm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import api.utfpr.ddm.configs.StorageConfig;
import api.utfpr.ddm.services.ImageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfig.class)
public class ApiDispositivosMoveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDispositivosMoveisApplication.class, args);
	}

	@SuppressWarnings("unused")
	@Bean
	CommandLineRunner createDirectory(ImageService imageService){
		return (args) -> {
			imageService.createDirectory();
		};
	}
}
