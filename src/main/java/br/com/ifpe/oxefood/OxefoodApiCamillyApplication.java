package br.com.ifpe.oxefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OxefoodApiCamillyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OxefoodApiCamillyApplication.class, args);
	}

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  return new BCryptPasswordEncoder();
    }


}
