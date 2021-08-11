package com.example.taskmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private ArrayList<Task> taskList;
    private ItemClickedListener itemClickedListener;
    public TaskAdapter(ArrayList<Task> taskList , ItemClickedListener itemClickedListener){
        this.taskList = taskList;
        this.itemClickedListener = itemClickedListener;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
       return new TaskViewHolder(view,itemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task =  taskList.get(position);
        holder.setData(task);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
