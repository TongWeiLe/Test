package com.daojia.test.bridge;

import android.util.Log;

/**
 * Created by allen on 17/8/10.
 */

public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditive mCoffeeAdditive) {
        super(mCoffeeAdditive);
    }

    @Override
    public void makeCoffee() {
        Log.e("small","小杯的" + mCoffeeAdditive.addSomething() +"咖啡");
    }
}
