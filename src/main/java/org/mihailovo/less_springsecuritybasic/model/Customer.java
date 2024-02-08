package org.mihailovo.less_springsecuritybasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private int id;
    private String userName;
    private String email;
}
