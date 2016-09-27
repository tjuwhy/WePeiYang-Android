package cn.campusapp.router.router;

import android.content.Context;

import cn.campusapp.router.route.IRoute;

/**
 * Created by huangyong on 16/8/30.
 */

public class ActionRouter extends BaseRouter {
    @Override
    public boolean open(IRoute route) {
        return false;
    }

    @Override
    public boolean open(String url) {
        return false;
    }

    @Override
    public boolean open(Context context, String url) {
        return false;
    }

    @Override
    public IRoute getRoute(String url) {
        return null;
    }

    @Override
    public boolean canOpenTheRoute(IRoute route) {
        return false;
    }

    @Override
    public boolean canOpenTheUrl(String url) {
        return false;
    }

    @Override
    public Class<? extends IRoute> getCanOpenRoute() {
        return null;
    }
}
