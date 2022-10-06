package dev.cosmingherghe.securitywithjwt.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dev.cosmingherghe.securitywithjwt.dao.IRoleRepo;
import dev.cosmingherghe.securitywithjwt.domain.Role;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RoleController extends ApiController {

  @Autowired
  private final IRoleRepo roleRepo;

  @GetMapping(value = "/roles")
  private ResponseEntity<List<Role>> getRoles() {
    return ResponseEntity.ok().body((List<Role>)roleRepo.findAll());
  }

  @PostMapping(value = "/role/save")
  private ResponseEntity<Role> saveRole(@RequestBody Role role) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles/save").toUriString());
    return ResponseEntity.created(uri).body(roleRepo.save(role));
  }
}
