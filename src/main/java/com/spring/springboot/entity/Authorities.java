package com.spring.springboot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    @Transient
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "username")
    private User user;

}
