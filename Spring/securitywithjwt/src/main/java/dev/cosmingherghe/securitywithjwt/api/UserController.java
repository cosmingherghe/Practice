package dev.cosmingherghe.securitywithjwt.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cosmingherghe.securitywithjwt.dao.IUserRepo;
import dev.cosmingherghe.securitywithjwt.domain.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {
  private final IUserRepo userRepo;

  @GetMapping(value = "/users")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body((List<User>)userRepo.findAll());
  }
}
