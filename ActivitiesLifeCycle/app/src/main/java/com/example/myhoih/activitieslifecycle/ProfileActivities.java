package com.example.myhoih.activitieslifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivities extends Activity {

    TextView txtFullName;
    Button btnExit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_profile);

        txtFullName = (TextView)findViewById(R.id.activities_profile_txtfullname);
        btnExit = (Button)findViewById(R.id.activities_profile_btn_exit);

        if(getIntent() != null) {
            String s = getIntent().getStringExtra("fullName");
            txtFullName.setText(s);
        }

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
