package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  @Column(name = "post_id")
  private Long id;

  @Column(nullable = false)
  @NotBlank
  @Size(min = 6, message = "Title should have min 6 characters")
  private String title;

  @NotBlank @Lob private String body;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date", nullable = false, updatable = false)
  @CreationTimestamp
  private Date createDate;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
  @NotNull
  private User user;

  @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
  private List<Comment> comments = new ArrayList<>();
}
