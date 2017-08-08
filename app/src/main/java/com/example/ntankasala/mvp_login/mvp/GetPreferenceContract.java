package com.example.ntankasala.mvp_login.mvp;

import com.example.ntankasala.mvp_login.BasePresenter;
import com.example.ntankasala.mvp_login.BaseView;

/**
 * Created by ntankasala on 8/7/17.
 */

public interface GetPreferenceContract {
    interface View extends BaseView<com.example.ntankasala.mvp_login.mvp.Presenter>{
        void showResult(String resultText);
    }
    interface Presenter extends BasePresenter{
        void buttonClicked(String resourceId);
    }



}

