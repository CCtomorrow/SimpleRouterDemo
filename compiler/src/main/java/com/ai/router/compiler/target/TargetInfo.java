package com.ai.router.compiler.target;

import javax.lang.model.element.TypeElement;

/**
 * <b>Project:</b> SimpleRouterDemo <br>
 * <b>Create Date:</b> 2017/3/25 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class TargetInfo {

    private TypeElement mTypeElement;
    private String mRoute;

    public TargetInfo() {
    }

    public TargetInfo(TypeElement typeElement, String route) {
        mTypeElement = typeElement;
        mRoute = route;
    }

    public TypeElement getTypeElement() {
        return mTypeElement;
    }

    public void setTypeElement(TypeElement typeElement) {
        mTypeElement = typeElement;
    }

    public String getRoute() {
        return mRoute;
    }

    public void setRoute(String route) {
        mRoute = route;
    }
}
