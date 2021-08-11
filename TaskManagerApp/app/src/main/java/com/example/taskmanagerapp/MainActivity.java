package com.example.taskmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickedListener {
    private ArrayList<Task> taskList = new ArrayList<>();
    RecyclerView recyclerView;
    private ImageView mtvAdd;
    private ImageView mtvDelete;
    TaskAdapter taskAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildViewData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        taskAdapter = new TaskAdapter(taskList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(linearLayoutManager);
         recyclerView.setAdapter(taskAdapter);

    }

    private void buildViewData() {
        Task task1 = new Task("Task1",R.drawable.ic_add,R.drawable.ic_baseline_delete_24);
        Task task2 = new Task("Task2",R.drawable.ic_add,R.drawable.ic_baseline_delete_24);
        Task task3 = new Task("Task3",R.drawable.ic_add,R.drawable.ic_baseline_delete_24);
        Task task4 = new Task("Task4",R.drawable.ic_add,R.drawable.ic_baseline_delete_24);
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);
        taskList.add(task4);

    }
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mtvAdd = findViewById(R.id.tvAdd);
        mtvDelete = findViewById(R.id.tvdelete);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(MainActivity.this,"New Task is added",Toast.LENGTH_SHORT).show();
        Task newtask = new Task("New Task",R.drawable.ic_add,R.drawable.ic_baseline_delete_24);
        taskList.add(newtask);
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemDeleteClick(int position) {
        Toast.makeText(MainActivity.this,"Task is Deleted from List",Toast.LENGTH_SHORT).show();
        taskList.remove(position);
        taskAdapter.notifyDataSetChanged();
    }
}