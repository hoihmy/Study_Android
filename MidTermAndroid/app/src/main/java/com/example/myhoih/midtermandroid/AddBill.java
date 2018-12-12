package com.example.myhoih.midtermandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBill extends Activity {

    EditText edtProductName, edtProductPrice, edtProductQuantity;
    Button btnSave, btnCancel;
    TextView txtType;
    String key, myProductName, myProductPrice, myProductQuantity;
    int pos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bill);

        edtProductName = (EditText) findViewById(R.id.edt_productName);
        edtProductPrice = (EditText) findViewById(R.id.edt_productPrice);
        edtProductQuantity = (EditText) findViewById(R.id.edt_productQuantity);
        txtType = (TextView) findViewById(R.id.txt_type);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        myBundle();

        if(key.equals("1")) {
            txtType.setText("ADD NEW BILL");
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent();
                    i.putExtra("product_name", edtProductName.getText().toString());
                    i.putExtra("product_price", String.valueOf(edtProductPrice.getText().toString()));
                    i.putExtra("product_quantity", String.valueOf(edtProductQuantity.getText().toString()));
                    setResult(10, i);
                    finish();
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        } else if(key.equals("2")) {
            txtType.setText("UPDATE BILL");
            edtProductName.setText(myProductName);
            edtProductPrice.setText(myProductPrice);
            edtProductQuantity.setText(myProductQuantity);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent();
                    i.putExtra("product_name", edtProductName.getText().toString());
                    i.putExtra("product_price", String.valueOf(edtProductPrice.getText().toString()));
                    i.putExtra("product_quantity", String.valueOf(edtProductQuantity.getText().toString()));
                    setResult(20, i);
                    i.putExtra("pos", pos+"");
                    finish();
                }
            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public void myBundle() {
        Bundle myBundle = getIntent().getExtras();
        if(myBundle != null) {
            key = myBundle.getString("key");
            myProductName = myBundle.getString("product_name");
            myProductPrice = myBundle.getString("product_price");
            myProductQuantity = myBundle.getString("product_quantity");
            pos = myBundle.getInt("pos");
        }
    }
}
