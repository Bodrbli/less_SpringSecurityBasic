package org.mihailovo.less_springsecuritybasic.model.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {

    ADMIN(Set.of(Authority.CUSTOMER_READ, Authority.CUSTOMER_WRITE)),
    USER(Set.of(Authority.CUSTOMER_READ)),
    LOSER(Set.of());

    private final Set<Authority> authorities; // поле дополнительного значения

    /*ADMIN("read"), // возможность через конструктор присвоить константам дополнительное значение
    USER("write"),
    LOSER("lose");

    String authority; // поле дополнительного значаения

    Role(String authority) { // конструктор
        this.authority = authority;
    }*/
    Role (Set<Authority> authorities) { // конструктор
        this.authorities=authorities;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() { // метод возвращающий сет ролей с разрешениями
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toSet());
    }
}
