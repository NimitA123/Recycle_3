package com.example.recycle_3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvName;
    private TextView mtvAge;
    private TextView mtvAddress;
    private ImageView mtvEdit;
    private ItemClickListener itemClickListener;

    public EmployeeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initData();

    }

    private void initData() {
        mtvName = itemView.findViewById(R.id.etName1);
        mtvAge = itemView.findViewById(R.id.etAge1);
        mtvAddress = itemView.findViewById(R.id.etAddress1);
        mtvEdit = itemView.findViewById(R.id.edit);

    }
    public void setData(Employee employee){
        mtvName.setText(employee.getName());
        mtvAge.setText(employee.getAge()+"");
        mtvAddress.setText(employee.getAddress());

        mtvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(getAdapterPosition(), employee);
            }
        });
    }

}
