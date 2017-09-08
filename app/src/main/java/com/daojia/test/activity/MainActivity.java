package com.daojia.test.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.daojia.test.MyListView;
import com.daojia.test.R;
import com.daojia.test.TestAdapter;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    final String TAG = "mainactivity";

    MyListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (MyListView) findViewById(R.id.lv_test);

        listView.setAdapter(new TestAdapter(this));


        listView.setOnTouchListener(this);

        findViewById(R.id.bt_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog pd = ProgressDialog.show(MainActivity.this, "Installing...", "Please wait...", true, true);
                // FIXME: 仅用于安装流程演示 2017/7/24
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        simulateInstallExternalPlugin();
                        pd.dismiss();
                    }
                }, 1000);
//                RePlugin.startActivity(MainActivity.this,RePlugin.createIntent("com.wuba.dswuxian.wh","com.wuba.dswuxian.wh.LoginActivity"));
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        Log.e(TAG,"MainActivity  dispatchTouchEvent ");

//        if (super.dispatchTouchEvent(ev)){
//            Log.e(TAG,"MainActivity  parent  dispatchTouchEvent");
//        }

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onUserInteraction();

            Log.e(TAG," onUserInteraction ");
        }
        if (getWindow().superDispatchTouchEvent(ev)) {

            Log.e(TAG," superDispatchTouchEvent ");

            return true;
        }
        return onTouchEvent(ev);

//        return super.onTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"MainActivity  onTouchEvent");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                Log.e(TAG,"Activity ACTION_DOWN");

                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG,"Activity ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"Activity ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"Activity ACTION_UP");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        Log.e(TAG,"MainActivity  onTouch");
        return false;
    }

    /**
     * 模拟安装或升级（覆盖安装）外置插件
     * 注意：为方便演示，外置插件临时放置到Host的assets/external目录下，具体说明见README</p>
     */
    private void simulateInstallExternalPlugin() {
        String demo3Apk= "app-debug.apk";
        String demo3apkPath = "external" + File.separator + demo3Apk;

        // 文件是否已经存在？直接删除重来
        String pluginFilePath = getFilesDir().getAbsolutePath() + File.separator + demo3Apk;

        Log.e(TAG,pluginFilePath);
        File pluginFile = new File(pluginFilePath);
        if (pluginFile.exists()) {
            FileUtils.deleteQuietly(pluginFile);
        }



        // 开始复制

        copyAssetsFileToAppFiles(demo3apkPath, demo3Apk);
        PluginInfo info = null;
        if (pluginFile.exists()) {
            info = RePlugin.install(pluginFilePath);

        }

        if (info != null) {
            RePlugin.startActivity(MainActivity.this, RePlugin.createIntent(info.getName(), "com.wuba.dswuxian.wh.LoginActivity"));
        } else {
            Toast.makeText(MainActivity.this, "install external plugin failed", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 从assets目录中复制某文件内容
     *  @param  assetFileName assets目录下的Apk源文件路径
     *  @param  newFileName 复制到/data/data/package_name/files/目录下文件名
     */
    private void copyAssetsFileToAppFiles(String assetFileName, String newFileName) {
        InputStream is = null;
        FileOutputStream fos = null;
        int buffsize = 1024;

        try {
            is = this.getAssets().open(assetFileName);
            fos = this.openFileOutput(newFileName, Context.MODE_PRIVATE);
            int byteCount = 0;
            byte[] buffer = new byte[buffsize];
            while((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
