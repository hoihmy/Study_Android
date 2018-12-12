package com.example.myhoih.midtermandroid;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnEditClickListener {

    ListView myListView;
    Button btnAdd;
    EditText edtProductName, edtProductPrice, edtProductQuantity;
    ArrayList<Bill> myBill= new ArrayList<>();
    ListAdapter adapter;

//   Gọi đối tượng MyDatabase:
    MyDatabase myDatabase = new MyDatabase(this,"",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView)findViewById(R.id.activity_listView);
        btnAdd = (Button)findViewById(R.id.btn_add);
        edtProductName = (EditText) findViewById(R.id.edt_productName);
        edtProductPrice = (EditText) findViewById(R.id.edt_productPrice);
        edtProductQuantity = (EditText) findViewById(R.id.edt_productQuantity);

        myBill = getListBill();

        adapter = new ListAdapter(this, myBill, this);
        myListView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtProductName.getText().toString();
                String price = String.valueOf(edtProductPrice.getText().toString());
                String quantity = String.valueOf(edtProductQuantity.getText().toString());
                if (name.matches("")) {
                    Toast.makeText(MainActivity.this, "You did not enter a product name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (price.matches("")) {
                    Toast.makeText(MainActivity.this, "You did not enter a product price!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (quantity.matches("")) {
                    Toast.makeText(MainActivity.this, "You did not enter a product quantity!", Toast.LENGTH_SHORT).show();
                    return;
                }
//                Intent i = new Intent();
//                i.putExtra("product_name", edtProductName.getText().toString());
//                i.putExtra("product_price", String.valueOf(edtProductPrice.getText().toString()));
//                i.putExtra("product_quantity", String.valueOf(edtProductQuantity.getText().toString()));

                String productName = edtProductName.getText().toString();
                String productPrice = edtProductPrice.getText().toString();
                String productQuantity = edtProductQuantity.getText().toString();

                myDatabase.insertBill(productName, Double.parseDouble(productPrice), Integer.parseInt(productQuantity));
                edtProductName.setText("");
                edtProductPrice.setText("");
                edtProductQuantity.setText("");

                ArrayList<Bill> list =  myDatabase.getBills();
                for(int oldVersion=0; oldVersion<list.size(); oldVersion++) {
                    Log.d("Product name:", list.get(oldVersion).getProductName());
//                    Log.d("Price:", list.get(oldVersion).getPrice());
//                    Log.d("Quantity:", list.get(oldVersion).getQuantity());
                }

//                String productName = edtProductName.getText().toString();
//                String productPrice = edtProductPrice.getText().toString();
//                String productQuantity = edtProductQuantity.getText().toString();
//                Bill bill = new Bill(productName, Double.parseDouble(productPrice),Integer.parseInt(productQuantity));
//                myBill.add(bill);
//                adapter.notifyDataSetChanged();
            }
        });

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AddBill.class);
                intent.putExtra("product_name", myBill.get(position).getProductName());
                intent.putExtra("product_price", myBill.get(position).getPrice());
                intent.putExtra("product_quantity", myBill.get(position).getQuantity());
                startActivity(intent);
            }
        });
    }

    private ArrayList<Bill> getListBill() {
        ArrayList<Bill> bills = new ArrayList<>();
        bills.add(new Bill("Sting", 20000.0,10));
        bills.add(new Bill("Milk Tea", 19000.0, 5));
        return bills;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 10){
            String productName = data.getStringExtra("product_name");
            String productPrice = data.getStringExtra("product_price");
            String productQuantity = data.getStringExtra("product_quantity");
            Bill bill = new Bill(productName, Double.parseDouble(productPrice),Integer.parseInt(productQuantity));
            myBill.add(bill);
            adapter.notifyDataSetChanged();
        }
        if(resultCode == 20){
            String productName = data.getStringExtra("product_name");
            Double productPrice = Double.parseDouble(data.getStringExtra("product_price"));
            int productQuantity = Integer.parseInt(data.getStringExtra("product_quantity"));
            String pos = data.getStringExtra("pos");
            myBill.get(Integer.parseInt(pos)).setProductName(productName);
            myBill.get(Integer.parseInt(pos)).setPrice(productPrice);
            myBill.get(Integer.parseInt(pos)).setQuantity(productQuantity);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onEditClick(int pos) {
        navigateAddandEdit("2", pos);
    }

    @Override
    public void onDeleteClick(int pos) {
        myBill.remove(myBill.get(pos));
        adapter.notifyDataSetChanged();
    }

    public String navigateAddandEdit(String key, int pos){
        Intent addAndEdit = new Intent(this, AddBill.class);
        addAndEdit.putExtra("product_name", myBill.get(pos).getProductName());
        addAndEdit.putExtra("product_price", String.valueOf(myBill.get(pos).getPrice()));
        addAndEdit.putExtra("product_quantity", String.valueOf(myBill.get(pos).getQuantity()));
        addAndEdit.putExtra("key", key);
        addAndEdit.putExtra("pos", pos);
        startActivityForResult(addAndEdit,20);
        return key;
    }
}
