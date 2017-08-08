package com.example.ntankasala.mvp_login.mvp;

/**
 * Created by ntankasala on 8/8/17.
 */

public interface GetPreferenceCallBack {
    void onReceiveSuccess(String result);
    void onReceiveFailure(String message);
}
