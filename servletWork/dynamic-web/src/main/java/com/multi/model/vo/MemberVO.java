package com.multi.model.vo;

public class MemberVO {
    private String email;
    private String name;
    private String password;
    private String remember;

    public MemberVO() {
    }

    public MemberVO(String email, String name, String password, String remember) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.remember = remember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", remember='" + remember + '\'' +
                '}';
    }
}
