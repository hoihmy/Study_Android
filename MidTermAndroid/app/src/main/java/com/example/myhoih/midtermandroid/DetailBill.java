package com.example.myhoih.midtermandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class DetailBill extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_bill);

        String productName = getIntent().getStringExtra("product_name");
        String price = getIntent().getIntExtra("product_price", 0)+"";
        String quantity = getIntent().getIntExtra("product_quantity", 0)+"";

        TextView txt_productName = (TextView)findViewById(R.id.txt_detail_productName);
        TextView txt_productPrice = (TextView)findViewById(R.id.txt_detail_price);
        TextView txt_productQuantity = (TextView)findViewById(R.id.txt_productQuantity);

        txt_productName.setText(productName);
        txt_productPrice.setText(price);
        txt_productQuantity.setText(quantity);
    }
}
