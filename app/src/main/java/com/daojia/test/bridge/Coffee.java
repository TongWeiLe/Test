package com.daojia.test.bridge;

/**
 * Created by allen on 17/8/10.
 */

public abstract class Coffee {

    CoffeeAdditive mCoffeeAdditive;

    public Coffee(CoffeeAdditive mCoffeeAdditive) {
        this.mCoffeeAdditive = mCoffeeAdditive;
    }

    public abstract void makeCoffee();
}
