package org.mihailovo.less_springsecuritybasic.model.user;

public enum Authority {
    CUSTOMER_READ("CUSTOMER_READ"),
    CUSTOMER_WRITE("CUSTOMER_WRITE");

    private final String authority;

    Authority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
