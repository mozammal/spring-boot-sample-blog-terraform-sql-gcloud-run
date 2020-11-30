package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  @Column(name = "user_id")
  private Long id;

  @Email(message = "*Please provide a valid Email")
  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false)
  @Size(min = 6, message = "Password should have min 6 characters")
  @NotEmpty
  @JsonIgnore
  private String password;

  @Column(unique = true, nullable = false)
  @Size(min = 3, message = "Username should have min 3 characters")
  @NotEmpty
  private String username;

  @NotEmpty private String name;

  @Column(name = "last_name")
  @NotEmpty
  private String lastName;

  @Column(nullable = false)
  private int active;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Post> posts = new ArrayList<>();
}
