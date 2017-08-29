package com.daojia.test.bridge;

import android.util.Log;

/**
 * Created by allen on 17/8/10.
 */

public class LargeCoffee extends Coffee {

    public LargeCoffee(CoffeeAdditive mCoffeeAdditive) {
        super(mCoffeeAdditive);
    }

    @Override
    public void makeCoffee() {

        Log.e("large","大杯的" + mCoffeeAdditive.addSomething() + "咖啡");

    }
}
