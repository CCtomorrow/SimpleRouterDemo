package com.ai.router.normalusage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.ai.router.normalusage.base.IRoute;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Project:</b> SimpleRouterDemo <br>
 * <b>Create Date:</b> 2017/3/24 <br>
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

    public void init(IRoute route) {
        if (route != null) {
            route.initRouter(mTables);
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
