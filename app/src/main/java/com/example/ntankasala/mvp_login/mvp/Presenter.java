package com.example.ntankasala.mvp_login.mvp;

import android.content.Context;

/**
 * Created by ntankasala on 8/7/17.
 */

public class Presenter implements GetPreferenceContract.Presenter , GetPreferenceCallBack{

    GetPreferenceContract.View mView;
    Model mModel;
    Context context;

    public Presenter(GetPreferenceContract.View mView,Context context) {
        this.mView = mView;
        this.context = context;
        mModel = new Model(context);
        mView.setPresenter(this);
    }

    @Override
    public void buttonClicked(String res_id) {
        mModel.getPreference(res_id, this);
    }

    @Override
    public void onReceiveSuccess(String result) {
        mView.showResult(result);
    }

    @Override
    public void onReceiveFailure(String message) {
        mView.showResult(message);
    }
}
