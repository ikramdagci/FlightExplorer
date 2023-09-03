package com.amadeus.ikramdagci.domain.entity.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public enum Role {
    USER,
    ADMIN;


    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
