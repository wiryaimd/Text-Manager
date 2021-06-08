package com.wiryaimd.textmanager.ui.auth;

/**
 * katanya sich best practice yach
 * biar ngerti, liat di authviewmodel class
 */
public class AuthResource<T> {

    public final AuthStatus authStatus;

    public final T data;

    public final String msg;

    public AuthResource(AuthStatus authStatus, T data, String msg) {
        this.authStatus = authStatus;
        this.data = data;
        this.msg = msg;
    }

    public static <T> AuthResource<T> authenticated(T data){
        return new AuthResource<>(AuthStatus.AUTHENTICATED, data, null);
    }

    public static <T> AuthResource<T> loading(T data){
        return new AuthResource<>(AuthStatus.LOADING, data, null);
    }

    public static <T> AuthResource<T> error(String msg, T data){
        return new AuthResource<>(AuthStatus.ERROR, data, msg);
    }

    public static <T> AuthResource<T> logout(T data){
        return new AuthResource<>(AuthStatus.NOT_AUTHENTICATED, data, null);
    }

    public enum AuthStatus{
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }

}
