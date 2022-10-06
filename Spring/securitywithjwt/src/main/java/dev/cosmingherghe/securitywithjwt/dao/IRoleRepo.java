package dev.cosmingherghe.securitywithjwt.dao;

import org.springframework.data.repository.CrudRepository;

import dev.cosmingherghe.securitywithjwt.domain.Role;

public interface IRoleRepo extends CrudRepository<Role,Long> {
  Role findByName(String name);
}
