package com.example.projectmanagement;

public class Member {
    private String personName;
    private int taskCount;

    public Member(String personName) {
        this.personName = personName;
        this.taskCount = 0;
    }

    public String getPersonName() {
        return personName;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void incrementTaskCount() {
        this.taskCount++;
    }

    public void decrementTaskCount() {
        this.taskCount--;
    }

    @Override
    public String toString() {
        return personName;
    }
}