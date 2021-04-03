package com.spring.springboot.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "username")
    @Size(min=4, message = "Имя пользователя должно быть не меньше 4 знаков")
    private String username;

    @Column(name = "password")
    @Size(min = 6, message = "Пароль должен быть не менее 6 знаков")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private byte enabled;

    @Transient
    private String confirmPassword;

    @Transient
    @OneToOne(cascade = CascadeType.ALL
            , mappedBy = "users"
            , fetch = FetchType.EAGER)
    private Authorities authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<Authorities> getAuthorities() {
        return (Collection<Authorities>) authorities;
    }
}
