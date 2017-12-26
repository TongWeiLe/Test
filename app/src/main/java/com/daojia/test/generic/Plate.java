package com.daojia.test.generic;

/**
 * Created by allen on 17/12/20.
 */

public class Plate<T> {

    private T t;

    public Plate(T t) {
        this.t = t;
    }

    public void setT(T tt){
        t = tt;
    }

    public T getT(){
        return t;
    }
}
