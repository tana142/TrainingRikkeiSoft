package com.rikkei.training.activity.trainingapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    List<Employee> employeeList;
    Employeelistener listener;

    public EmployeeAdapter(List<Employee> employeeList, Employeelistener listener) {
        this.employeeList = employeeList;
        this.listener = listener;
    }

    interface Employeelistener {

        void onClickEmployee(Employee e);
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_employee,parent, false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder holder, int position) {

        Employee employee = employeeList.get(position);
        if(employee != null){
            holder.id.setText(String.valueOf(employee.getId()));
            holder.name.setText(employee.getName());
            holder.age.setText(String.valueOf(employee.getAge()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickEmployee(employee);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeHolder extends  RecyclerView.ViewHolder{
        TextView id, name, age;
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_empl);
            name = itemView.findViewById(R.id.name_empl);
            age = itemView.findViewById(R.id.age_empl);

        }
    }
}
