package com.example.ntankasala.mvp_login.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ntankasala.mvp_login.R;

public class MainActivity extends AppCompatActivity implements GetPreferenceContract.View{

    Button mresult_bt;
    TextView mresult_tv;

    String resource_id = "sharedpreferences";

    Presenter mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Presenter(this, this.getApplicationContext());
        mresult_bt = (Button)findViewById(R.id.get_bt);
        mresult_tv = (TextView)findViewById(R.id.result_tv);
        mresult_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.buttonClicked(resource_id);
            }
        });
    }

    @Override
    public void showResult(String resultText) {
        mresult_tv.setText(resultText);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        mpresenter = presenter;
    }
}
