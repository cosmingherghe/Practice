package dev.cosmingherghe.securitywithjwt.dao;

import org.springframework.data.repository.CrudRepository;

import dev.cosmingherghe.securitywithjwt.domain.User;

public interface IUserRepo extends CrudRepository<User, Long> {
  User findByUsername(String username);
}