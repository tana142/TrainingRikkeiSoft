package com.rikkei.training.activity.trainingapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String  TAG = "Activity Main";
    RecyclerView recyclerView;
    List<Employee> employeeList;
    EmployeeAdapter employeeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Log.e(TAG, "onCreate: " + TAG );

       recyclerView = findViewById(R.id.rcv);

       employeeList = getData();
       employeeAdapter = new EmployeeAdapter(employeeList, new EmployeeAdapter.Employeelistener() {
           @Override
           public void onClickEmployee(Employee e) {
               Toast.makeText(MainActivity.this, "Click " + e.getName(), Toast.LENGTH_SHORT).show();
           }
       });

        RecyclerView.LayoutManager layoutManager  = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(employeeAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    private List<Employee> getData() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"mot", 1));
        list.add(new Employee(2,"hai", 2));
        list.add(new Employee(3,"ba", 3));
        list.add(new Employee(4,"bon", 4));
        list.add(new Employee(5,"nam", 5));
        list.add(new Employee(6,"sau", 6));
        return list;
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        Log.e(TAG, "onStart: " + TAG );
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(TAG, "onResume: " + TAG);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e(TAG, "onPause: " + TAG );
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e(TAG, "onStop: " + TAG);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e(TAG, "onDestroy: "+ TAG );
//    }
}