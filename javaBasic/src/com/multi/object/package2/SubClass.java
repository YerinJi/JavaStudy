package com.multi.object.package2;

import com.multi.object.package1.SuperClass;

public class SubClass extends SuperClass {
    public SubClass() {
        this.publicData = 200;
        this.protectedData = 300;
        //package가 다르면 default는 접근 불가
    }
}
