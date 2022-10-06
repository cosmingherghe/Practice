package dev.cosmingherghe.securitywithjwt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.cosmingherghe.securitywithjwt.dao.IRoleRepo;
import dev.cosmingherghe.securitywithjwt.dao.IUserRepo;
import dev.cosmingherghe.securitywithjwt.domain.Role;
import dev.cosmingherghe.securitywithjwt.domain.User;

@SpringBootApplication
public class SecuritywithjwtApplication {

	@Autowired
	IRoleRepo roleRepo;

	@Autowired
	IUserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SecuritywithjwtApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Role role1 = new Role(null, "ROLE_USER");
			Role role2 = new Role(null, "ROLE_ADMIN");
			Role role3 = new Role(null, "ROLE_MANAGER");

			User user1 = new User(null, "cosmin", "ok", Arrays.asList(role1,role2,role3));
			User user2 = new User(null, "kasi", "ok", Arrays.asList(role2,role3));
			User user3 = new User(null, "alesia", "ok", Arrays.asList(role3));

			roleRepo.save(role1);
			roleRepo.save(role2);
			roleRepo.save(role3);

			userRepo.save(user1);
			userRepo.save(user2);
			userRepo.save(user3);
		};
	}
}
