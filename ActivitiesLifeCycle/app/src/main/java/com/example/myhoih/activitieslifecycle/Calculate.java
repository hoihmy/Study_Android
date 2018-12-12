package com.example.myhoih.activitieslifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculate extends Activity{

    Button btnPlus;
    Button btnSubtract;
    TextView txtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities_calculate);

        btnPlus = (Button)findViewById(R.id.activities_calculate_btn_plus);
        btnSubtract = (Button)findViewById(R.id.activities_calculate_btn_subtract);
        txtResult = (TextView)findViewById(R.id.activities_calculate_txt_result);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plus = new Intent(Calculate.this, HandleCalculate.class);
                plus.putExtra("plus", "plus");
                startActivityForResult(plus,20);
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subtract = new Intent(Calculate.this, HandleCalculate.class);
                subtract.putExtra("plus", "subtract");
                startActivityForResult(subtract,20);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==20){
            int result = data.getIntExtra("result", 0);
            txtResult.setText(String.valueOf(result));
        }
    }
}
