package dev.cosmingherghe.securitywithjwt.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
  @Id 
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long appUser_id;
  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER) 
  private List<Role> roles = new ArrayList<>();
  
  
}
