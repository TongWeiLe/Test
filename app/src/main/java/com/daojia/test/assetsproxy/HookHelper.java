package com.daojia.test.assetsproxy;

import android.app.Instrumentation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by allen on 17/12/19.
 */

public class HookHelper {

    public static void hookResourecs(){

        try {
            Class<?> clzss = Class.forName("android.app.ActivityThread");

            Method method = clzss.getDeclaredMethod("currentActivityThread");

            method.setAccessible(true);

            //ActivityThread
            Object object = method.invoke(null);

            Field field = clzss.getDeclaredField("mInstrumentation");

            field.setAccessible(true);

            Instrumentation instrumentation = (Instrumentation) field.get(object);

            Instrumentation proxyInstrumentation = new MyInstrumentation();

            field.set(object,proxyInstrumentation);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
