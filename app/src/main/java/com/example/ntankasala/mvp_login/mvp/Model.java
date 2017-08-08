package com.example.ntankasala.mvp_login.mvp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ntankasala on 8/7/17.
 */

public class Model {

    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor mEditor;

    String resource_id = "sharedpreferences";

    public Model(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("sharedpreferences",Context.MODE_PRIVATE);
        mEditor = sharedPreferences.edit();
    }

    public void getPreference(String id, GetPreferenceCallBack getPreferenceCallBack) {
        mEditor.putString(resource_id,"Inside Model");
        mEditor.commit();
        String default_msg = "not found";
        String msg = sharedPreferences.getString(id, default_msg);
        if(msg.equals(default_msg)){
            getPreferenceCallBack.onReceiveFailure(default_msg);
        }else {
            getPreferenceCallBack.onReceiveSuccess(msg);
        }
    }


}
