package com.daojia.test.assetsproxy;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by allen on 17/12/19.
 *
 * ActivityThread handlePerformLaunchActivity()方法内
 * 调用Instrumentation的callActivityOnCreate()方法
 *
 */

public class MyInstrumentation extends Instrumentation {

    @Override
    public void callActivityOnCreate(Activity activity, Bundle icicle) {
        super.callActivityOnCreate(activity, icicle);


        try {

            Field mBaseField = Activity.class.getSuperclass().getSuperclass().getDeclaredField("mBase");

            mBaseField.setAccessible(true);

            Context context = (Context) mBaseField.get(activity);

            Class<?> clzss = Class.forName("android.app.ContextImpl");

            Field mResourcesField = clzss.getField("mResources");

            mResourcesField.setAccessible(true);

            String pluginPath = Environment.getExternalStorageState() + "";
            String hostPath = activity.getPackageResourcePath();

            AssetManager assetManager = AssetManager.class.newInstance();

            Method method = AssetManager.class.getDeclaredMethod("addAssetPath",String.class);
            method.setAccessible(true);

            method.invoke(assetManager,pluginPath);
            method.invoke(assetManager,hostPath);

            Method ensureMethod = AssetManager.class.getMethod("ensureStringBlocks");
            ensureMethod.setAccessible(true);
            ensureMethod.invoke(assetManager);


            Resources hostResource = activity.getResources();

            Resources newResource = new Resources(assetManager,hostResource.getDisplayMetrics(),hostResource.getConfiguration());

            mResourcesField.set(context,newResource);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
