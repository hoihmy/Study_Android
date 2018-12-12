package com.example.myhoih.sharedpeference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        if(checkLogin()){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onLogin(View view) {
        if (!edtUsername.getText().toString().trim().equals("")) {
            saveLogin(edtUsername.getText().toString().trim());

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean checkLogin() {
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        if (!pref.getString("username", "").equals("")) {
            return true;
        }
        return false;
    }

    public void saveLogin(String usename) {
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString("username", usename);
        editor.commit();
    }
}
