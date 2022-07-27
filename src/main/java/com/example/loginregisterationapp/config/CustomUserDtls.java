package com.example.loginregisterationapp.config;

import com.example.loginregisterationapp.entity.UserData;
import net.bytebuddy.build.Plugin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomUserDtls implements UserDetails {

    private UserData u;

    // Constructor
    public CustomUserDtls(UserData u) {
        super();
        this.u = u;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
        set.add(new SimpleGrantedAuthority(u.getRole()));

        return set;
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getEmail();
    }

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
}
