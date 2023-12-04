package com.pocket.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class PocketWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketWalletApplication.class, args);
	}

}
