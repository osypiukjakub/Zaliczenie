package com.example.projectmanagement;

import java.time.LocalDateTime;

public class Assignment {
    private String assignmentTitle;
    private String assignmentDetails;
    private AssignmentStatus assignmentStatus;
    private Member assignedPerson;
    private LocalDateTime startTimestamp;
    private LocalDateTime endTimestamp;
    private long loggedHours;


    public Assignment(String assignmentTitle, String assignmentDetails) {
        this.assignmentTitle = assignmentTitle;
        this.assignmentDetails = assignmentDetails;
        this.assignmentStatus = AssignmentStatus.PENDING;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }
    public void logHours(long hours) {
        loggedHours += hours;
    }

    public long getLoggedHours() {
        return loggedHours;
    }
    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public AssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    public Member getAssignedPerson() {
        return assignedPerson;
    }

    public void assignTo(Member person) {
        this.assignedPerson = person;
        this.startTimestamp = LocalDateTime.now();
        person.incrementTaskCount();
        this.assignmentStatus = AssignmentStatus.ONGOING;
    }

    public void completeAssignment() {
        this.assignmentStatus = AssignmentStatus.DONE;
        this.endTimestamp = LocalDateTime.now();
        if (assignedPerson != null) {
            assignedPerson.decrementTaskCount();
        }
    }

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public LocalDateTime getEndTimestamp() {
        return endTimestamp;
    }

    public long getTimeSpent() {
        if (endTimestamp != null && startTimestamp != null) {
            return java.time.Duration.between(startTimestamp, endTimestamp).toSeconds();
        }
        return 0;
    }

    @Override
    public String toString() {
        return assignmentTitle;
    }
}