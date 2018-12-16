package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.Security.Role;
import com.bookstore.domain.Security.User;
import com.bookstore.domain.Security.UserRole;
import com.bookstore.service.UserService;

@SpringBootApplication
public class BootstrapAngularApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User();
		user.setFirstName("zoubair");
		user.setLastName("taidi");
		user.setEmail("zoubair.ta@gmail.com");
		user.setUsername("user");
		user.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		Set<UserRole> userRoles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		
		userRoles.add(new UserRole(user, role));
		userService.CreateUser(user, userRoles);
		userRoles.clear();
		
		
		
		User user1 = new User();
		user1.setFirstName("admin");
		user1.setLastName("admin");
		user1.setEmail("admin@gmail.com");
		user1.setUsername("ADMIN");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		Set<UserRole> userRoles2 = new HashSet<>();
		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
	    role1.setRoleId(0);
		userRoles2.add(new UserRole(user1, role1));
		userService.CreateUser(user1, userRoles2);
	
		
		
		
		
	}
}
