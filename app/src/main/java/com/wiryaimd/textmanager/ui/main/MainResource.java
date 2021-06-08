package com.wiryaimd.textmanager.ui.main;

import com.wiryaimd.textmanager.ui.auth.AuthResource;

public class MainResource<T> {

    public final MainResource.MainStatus mainStatus;

    public final T data;

    public final String msg;

    public MainResource(MainResource.MainStatus mainStatus, T data, String msg) {
        this.mainStatus = mainStatus;
        this.data = data;
        this.msg = msg;
    }

    public static <T> MainResource<T> success(T data){
        return new MainResource<>(MainStatus.SUCCESS, data, null);
    }

    public static <T> MainResource<T> loading(T data){
        return new MainResource<>(MainStatus.LOADING, data, null);
    }

    public static <T> MainResource<T> error(String msg, T data){
        return new MainResource<>(MainStatus.ERROR, data, msg);
    }

    public enum MainStatus{
        SUCCESS, ERROR, LOADING
    }

}
