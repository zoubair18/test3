package com.bookstore.service;

import java.util.Set;

import com.bookstore.domain.Security.User;
import com.bookstore.domain.Security.UserRole;

public interface UserService {

	User CreateUser(User user,Set<UserRole> userRoles);
}
