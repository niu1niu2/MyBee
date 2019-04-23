package com.boyaosmart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exit();
    }
  //退出程序的方法 通常连续点击来退出
    private void exit() {
        if ((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(getApplicationContext(),"再按一次退出",Toast.LENGTH_LONG).show();
            exitTime = System.currentTimeMillis();
        }else {
            finish();
        }
    }
}
