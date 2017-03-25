package com.ai.router.normalusage;

import android.app.Activity;
import android.app.Application;

import com.ai.router.normalusage.base.IRoute;

import java.util.Map;

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
        manager.init(new IRoute() {
            @Override
            public void initRouter(Map<String, Class<? extends Activity>> routers) {
                routers.put("router://activity/main", MainActivity.class);
                routers.put("router://activity/main2", Main2Activity.class);
                routers.put("router://activity/main3", Main3Activity.class);
            }
        });
    }

}
