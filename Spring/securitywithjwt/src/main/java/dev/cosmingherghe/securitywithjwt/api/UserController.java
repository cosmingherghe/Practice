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

import dev.cosmingherghe.securitywithjwt.dao.IUserRepo;
import dev.cosmingherghe.securitywithjwt.domain.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController extends ApiController {

  @Autowired
  private final IUserRepo userRepo;

  @GetMapping(value = "/users")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body((List<User>)userRepo.findAll());
  }

  @PostMapping(value = "/user/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
    return ResponseEntity.created(uri).body(userRepo.save(user));
  }
}
