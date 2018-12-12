package com.logingmail;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.List;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginGmail extends AppCompatActivity {
//    private Spinner spinner1;
//    private View view;
//    private Button login_btn;
//    private CheckBox forgotPass;
//    private EditText username;
//    private EditText password;
//    private TextView text_message;

//    private Button btnOK;
//    private EditText edtName, edtClasses;
//    private TextView txtResult;
//    ArrayList<Student> array = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_gmail);




//        <!-- binding view and Handling action: -->
//        login_btn = (Button) findViewById(R.id.btn_login);
//        username = (EditText) findViewById(R.id.input_email);
//        password = (EditText) findViewById(R.id.input_password);
//        forgotPass = (CheckBox) findViewById(R.id.forgot_password);
//        text_message = (TextView) findViewById(R.id.text_message);
//
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//                if(("admin").equals(user) && ("123456").equals(pass)) {
//                    Toast.makeText(LoginGmail.this, "You already login!", Toast.LENGTH_SHORT).show();
//                    text_message.setText("Bạn vừa đăng nhập!!!");
//                } else {
//                    Toast.makeText(LoginGmail.this,"Incorrect username or password!",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//
//        forgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(forgotPass.isChecked()==true) {
//                    forgotPass.setTextColor(Color.RED);
//                } else {
//                    forgotPass.setTextColor(Color.CYAN);
//                }
//            }
//        });

//        <!-- Design Layout: -->
        //addItemsOnSpinner1();
//        onRadioButtonClicked(view);
    }

    // add items into spinner dynamically
//    public void addItemsOnSpinner1() {
//
//        spinner1 = (Spinner) findViewById(R.id.spinner1);
//        List<String> list = new ArrayList<String>();
//        list.add("TGD: Trần Đình Nhân");
//        list.add("Ly Ca Tiếu đẹp trai");
//        list.add("Tâm Pưởm");
//        list.add("Pluto đầu heo");
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner1.setAdapter(dataAdapter);
//    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.radio1:
//                if (checked)
//                    break;
//            case R.id.radio2:
//                if (checked)
//                    break;
//            case R.id.radio3:
//                if (checked)
//                    break;
//            case R.id.radio4:
//                if (checked)
//                    break;
//            case R.id.radio5:
//                if (checked)
//                    break;
//            case R.id.radio6:
//                if (checked)
//                    break;
//            case R.id.radio7:
//                if (checked)
//                    break;
//        }
//    }
}
