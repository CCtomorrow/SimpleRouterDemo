package com.ai.simplerouterdemo;

import android.app.Application;

import com.ai.router.RouterManager;

/**
 * <b>Project:</b> SimpleRouterDemo <br>
 * <b>Create Date:</b> 2017/3/24 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class RouterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {
        RouterManager manager = RouterManager.getManager();
        manager.setSetSchemeprefix("router");
        manager.init();
    }

}
