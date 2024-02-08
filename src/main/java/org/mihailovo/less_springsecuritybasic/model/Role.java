package org.mihailovo.less_springsecuritybasic.model;

public enum Role {

    ADMIN,
    USER,
    LOSER
    /*ADMIN("read"), // возможность через конструктор присвоить константам дополнительное значение
    USER("write"),
    LOSER("lose");

    String authority;

    Role(String authority) { // конструктор
        this.authority = authority;
    }*/
}
