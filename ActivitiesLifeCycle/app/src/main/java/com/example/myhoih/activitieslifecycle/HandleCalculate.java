package com.example.myhoih.activitieslifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HandleCalculate extends Activity {

    EditText edtItem1;
    EditText edtItem2;
    Button btnOk;
    TextView edtMethod;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_handle_calculate);

        edtItem1 = (EditText)findViewById(R.id.activities_handle_calculate_edt_item1);
        edtItem2 = (EditText)findViewById(R.id.activities_handle_calculate_edt_item2);
        btnOk = (Button)findViewById(R.id.activities_handle_calculate_btn_ok);
        edtMethod = (TextView)findViewById(R.id.edt_method);

        if(getIntent() != null) {
            if (getIntent().getStringExtra("plus").equals("plus")) {
                edtMethod.setText("PLUS METHOD");
            } else {
                edtMethod.setText("SUBTRACT METHOD");
            }

            btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int val1 = Integer.parseInt(edtItem1.getText().toString());
                    int val2 = Integer.parseInt(edtItem2.getText().toString());
                    Intent in = new Intent();
                    if( getIntent().getStringExtra("plus").equals("plus") ) {
                        in.putExtra("result", (val1 + val2));
                        Log.e("method:","+");
                    } else {
                        in.putExtra("result", (val1 - val2));
                        Log.e("method:","-");
                    }
                    setResult(20,in);
                    finish();
                }
            });
        }
    }
}
