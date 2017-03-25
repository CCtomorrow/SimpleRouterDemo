package com.ai.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Project:</b> SimpleRouterDemo <br>
 * <b>Create Date:</b> 2017/3/25 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class RouterManager {

    private static volatile RouterManager sManager;
    private Map<String, Class<? extends Activity>> mTables;
    private String mSchemeprefix;

    private RouterManager() {
        mTables = new HashMap<>();
    }

    public static RouterManager getManager() {
        if (sManager == null) {
            synchronized (RouterManager.class) {
                if (sManager == null) {
                    sManager = new RouterManager();
                }
            }
        }
        return sManager;
    }

    public void init() {
        try {
            String className = "com.ai.router.impl.AppRouter";
            Class<?> moduleRouteTable = Class.forName(className);
            Constructor constructor = moduleRouteTable.getConstructor();
            IRoute instance = (IRoute) constructor.newInstance();
            instance.initRouter(mTables);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSetSchemeprefix(String setSchemeprefix) {
        this.mSchemeprefix = setSchemeprefix;
    }

    public void openResult(Context context, String path) {
        if (!TextUtils.isEmpty(mSchemeprefix)) {
            // router://activity/main
            path = mSchemeprefix + "://" + path;
        }
        try {
            Class aClass = mTables.get(path);
            Intent intent = new Intent(context, aClass);
            if (!(context instanceof Activity)) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
