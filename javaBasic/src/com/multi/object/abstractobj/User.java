package com.multi.object.abstractobj;

public abstract class User {
    String id;

    public User(String id) {
        this.id = id;
    }
    abstract void accessPage();
}

