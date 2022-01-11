package com.webdb.footballagent.footballagent;

import com.webdb.footballagent.footballagent.model.Role;
import com.webdb.footballagent.footballagent.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootballagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballagentApplication.class, args);
	}
	@Bean
	public CommandLineRunner setupRoles(RoleRepository roleRepository) {
		return (args) -> {
			Role userRole = new Role(1,"USER", "USER");
			Role adminRole = new Role(2,"ADMIN", "ADMIN");

			roleRepository.save(userRole);
			roleRepository.save(adminRole);
		};
	}


}
