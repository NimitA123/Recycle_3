package com.example.recycle_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener  {
    private RecyclerView recyclerView1;
    private ArrayList<Employee> employees1 = new ArrayList<>();
    private ItemClickListener itemClickListener;
    private CardView editCardView1;
    private EditText etName3;
    private EditText etAge3;
    private EditText etAddress3;
    private Button btnDOne;
    private EmployeeAdapter employeeAdapter;
    private ImageView delete;

    /**** include tag is used when item is reapeated it is very diffucult to handle ********/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildData();
        setRecycleView();
    }

    private void setRecycleView() {
        employeeAdapter = new EmployeeAdapter(employees1, this );
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(employeeAdapter);
    }

    private void buildData() {
        for(int i = 0; i < 50;  i++){
           Employee employees2 =  new Employee("Nimit", i+1, "Indore M.P.");
            employees1.add(employees2);

        }
    }

    private void initView() {
        recyclerView1 = findViewById(R.id.recycleView);
        editCardView1 = findViewById(R.id.editCardView);
        etName3 = findViewById(R.id.etName);
        etAge3 = findViewById(R.id.etAge);
        etAddress3 = findViewById(R.id.etAddress);
        btnDOne = findViewById(R.id.btn);
   /*****     delete = findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee = new Employee("Nimit", 10, "ednedjxed");
                employees1.remove(employees1.size()-1);

                employeeAdapter.notifyDataSetChanged();

            }
        });

********/
    }

    @Override
    public void onItemClick(int position, Employee employee1) {
        editCardView1.setVisibility(View.VISIBLE);
       // etName3.setText(employee1.getName());
    //    etAge3.setText(employee1.getAge()+"");
      //  etAddress3.setText(employee1.getAddress());

      //  Employee new_Employee = new Employee(etName3.getText().toString(),
     //                   Integer.parseInt(
      //                  etAge3.getText().toString()), etAddress3.getText().toString());
       btnDOne.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               editCardView1.setVisibility(View.GONE);
               Employee new_Employee = new Employee(etName3.getText().toString(),
                       Integer.parseInt(
                               etAge3.getText().toString()), etAddress3.getText().toString());
               employees1.set(position, new_Employee );
               employeeAdapter.notifyDataSetChanged();

           }
       });
        delete = findViewById(R.id.btnDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Employee new_Employee = new Employee(etName3.getText().toString(),
                        Integer.parseInt(
                                etAge3.getText().toString()), etAddress3.getText().toString());
                employees1.remove(position);
                employeeAdapter.notifyDataSetChanged();

            }
        });


    }
}