package com.ai.router.normalusage.base;

import android.app.Activity;

import java.util.Map;

/**
 * <b>Project:</b> SimpleRouterDemo <br>
 * <b>Create Date:</b> 2017/3/24 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public interface IRoute {

    void initRouter(Map<String, Class<? extends Activity>> routers);

}
