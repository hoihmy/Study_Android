package com.example.myhoih.sharedpeference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends Activity {

    TextView txtShowWelcome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtShowWelcome = (TextView) findViewById(R.id.txt_welcome);

        getInforUser();
    }

    public void getInforUser() {
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        if (!pref.getString("username", "").equals("")) {
            txtShowWelcome.setText("Xin chào " + pref.getString("username", ""));
        }
    }

    public void onLogout(View view) {
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
