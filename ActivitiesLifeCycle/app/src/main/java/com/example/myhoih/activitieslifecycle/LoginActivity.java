package com.example.myhoih.activitieslifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText edtFullName;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtFullName = (EditText)findViewById(R.id.activities_login_fullName);
        btnLogin = (Button)findViewById(R.id.activities_login_btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ProfileActivities.class);
                i.putExtra("fullName", edtFullName.getText().toString());
                startActivity(i);
                finish();
            }
        });

    }
}
