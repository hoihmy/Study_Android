package com.example.myhoih.midtermandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    private Context myContext;
    private ArrayList<Bill> myBill;
    OnEditClickListener myListener;

    public ListAdapter(Context context, ArrayList<Bill> my, OnEditClickListener listener) {
        myContext = context;
        myBill = my;
        myListener = listener;
    }

    @Override
    public int getCount() {
        return myBill.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_bill, parent, false);

        TextView txtProductName = (TextView) rowView.findViewById(R.id.txt_productName);
        txtProductName.setText(myBill.get(position).getProductName());

        TextView txtProductPrice = (TextView) rowView.findViewById(R.id.txt_productPrice);
        txtProductPrice.setText(myBill.get(position).getPrice()+"");

        Button btnEdit = (Button) rowView.findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(myListener != null) {
                myListener.onEditClick(position);
            }
            }
        });

        Button btnDelete = (Button) rowView.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(myListener != null) {
                myListener.onDeleteClick(position);
            }
            }
        });

        return rowView;
    }

    public interface OnEditClickListener {
        void onEditClick(int pos);
        void onDeleteClick(int pos);
    }
}
