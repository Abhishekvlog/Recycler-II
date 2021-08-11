package com.example.taskmanagerapp;

public class Task {
    private String mtvTask;
    private int mtvAdd;
    private int mtvDelete;

    public Task(String mtvTask, int mtvAdd, int mtvDelete) {
        this.mtvTask = mtvTask;
        this.mtvAdd = mtvAdd;
        this.mtvDelete = mtvDelete;
    }

    public String getMtvTask() {
        return mtvTask;
    }

    public int getMtvAdd() {
        return mtvAdd;
    }

    public int getMtvDelete() {
        return mtvDelete;
    }
}
