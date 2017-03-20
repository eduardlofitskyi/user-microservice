package com.lofitskyi;

import com.lofitskyi.entity.User;
import com.lofitskyi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserRepository userRepository){
		return string -> {
			java.util.stream.Stream.of(
					new User(1L, "Alex",	asList(BigDecimal.valueOf(105), BigDecimal.TEN)),
					new User(2L, "Den",		asList(BigDecimal.TEN)),
					new User(3L, "Serge",	emptyList()))
					.forEach(userRepository::save);
		};
	}
}
