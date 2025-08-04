package com.multi.object.abstractobj;

public abstract class Screen {
    void show(){
        init();
        render();
        cleanup();
    }

    abstract void init();
    abstract void render();
    abstract void cleanup();
}
