package com.example.Spring_Security;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	//預先建立資料
	@Bean
	ApplicationRunner init(UserRepository repository){
		return (ApplicationArguments args) -> dataSetup(repository);
	}

	private void dataSetup(UserRepository repository) {
		repository.save(User.builder().userName("Admin").password("Admin").active(true).roles("ROLE_USER").build());
		repository.save(User.builder().userName("User").password("abc123").active(true).roles("ROLE_USER,ROLE_ADMIN").build());
	}

}
