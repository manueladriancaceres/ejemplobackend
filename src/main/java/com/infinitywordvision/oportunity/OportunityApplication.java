package com.infinitywordvision.oportunity;

import com.infinitywordvision.oportunity.entity.UserSystem;
import com.infinitywordvision.oportunity.repository.UserSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OportunityApplication implements CommandLineRunner {

	@Autowired
	UserSystemRepository userSystemRepository;


	public static void main(String[] args) {
		SpringApplication.run(OportunityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		boolean agregarAdmin = false;
		if (userSystemRepository.findAll().size() == 0) {
			agregarAdmin = true;
		} else {
			if (!userSystemRepository.findByUsername("admin").isPresent()) {
				agregarAdmin = true;
			}
		}
		if(agregarAdmin) {
			UserSystem userSystem = new UserSystem();
			userSystem.setUsername("admin");
			userSystem.setPassword("123456");
			userSystemRepository.save(userSystem);
		}
	}
}
