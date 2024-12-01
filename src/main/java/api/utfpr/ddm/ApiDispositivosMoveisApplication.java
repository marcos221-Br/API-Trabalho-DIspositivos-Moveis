package api.utfpr.ddm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import api.utfpr.ddm.configs.StorageConfig;

@SpringBootApplication
@EnableConfigurationProperties(StorageConfig.class)
public class ApiDispositivosMoveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDispositivosMoveisApplication.class, args);
	}

}
