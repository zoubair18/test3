package com.bookstore.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Security.User;
import com.bookstore.domain.Security.UserRole;
import com.bookstore.repository.RoleRepository;
import com.bookstore.repository.UserRepository;
import com.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService{
private static final Logger LOG=LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Transactional
	public User CreateUser(User user, Set<UserRole> userRoles) {
		User localUser=userRepository.findByUsername(user.getUsername());
		if(localUser!=null) {
			LOG.info("User with username {} already exist",user.getUsername());
		}else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRole().addAll(userRoles);
			localUser=userRepository.save(user);
		}
		return localUser;
	}

}
