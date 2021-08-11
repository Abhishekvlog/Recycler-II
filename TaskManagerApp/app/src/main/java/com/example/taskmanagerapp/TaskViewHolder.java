package com.example.taskmanagerapp;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder {
    private TextView mtvTask;
    RelativeLayout relativeLayout;
    private ImageView mtvAdd;
    private ImageView mtvDelete;
    private ItemClickedListener itemClickedListener;

    public TaskViewHolder(@NonNull  View itemView, ItemClickedListener itemClickedListener) {

        super(itemView);
        this.itemClickedListener = itemClickedListener;
        initView(itemView);
    }

    private void initView(View itemView) {
        mtvTask =itemView.findViewById(R.id.teskView);
        relativeLayout = itemView.findViewById(R.id.cardView);
        mtvAdd = itemView.findViewById(R.id.tvAdd);
        mtvDelete = itemView.findViewById(R.id.tvdelete);


    }

    public void setData(Task task){
        mtvTask.setText(task.getMtvTask()+"");
        mtvAdd.setImageResource(task.getMtvAdd());
        mtvDelete.setImageResource(task.getMtvDelete());
        mtvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickedListener.onItemClick(getAdapterPosition());
            }
        });
        mtvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickedListener.onItemDeleteClick(getAdapterPosition());
            }
        });
    }
}
