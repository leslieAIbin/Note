package com.sxt;

/**
 * @program: redis-code
 * @author: 雷哥
 * @create: 2019-12-31 14:37
 **/

public class User {
    private String name;
    private String address;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
