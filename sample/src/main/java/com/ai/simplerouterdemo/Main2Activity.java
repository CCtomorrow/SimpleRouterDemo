package com.ai.simplerouterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ai.router.RouterManager;
import com.ai.router.anno.Route;

@Route("router://activity/main2")
public class Main2Activity extends AppCompatActivity {

    RouterManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mManager = RouterManager.getManager();
    }

    public void one(View view) {
        mManager.openResult(this, "activity/main2");
    }


    public void two(View view) {
        mManager.openResult(this, "activity/main3");
    }

}
