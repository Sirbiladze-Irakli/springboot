package com.spring.springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private byte enabled;

    @Transient
    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "users"
            , fetch = FetchType.LAZY)
    private List<Authorities> authorities;

}
