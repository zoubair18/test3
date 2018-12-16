package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
