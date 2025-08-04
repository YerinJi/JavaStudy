package com.multi.object.abstractobj;

public class Admin extends User {
    public Admin(String id) {
        super(id);
    }

    @Override
    void accessPage() {
        System.out.println(id + "관리자 페이지 접근");
    }
}
