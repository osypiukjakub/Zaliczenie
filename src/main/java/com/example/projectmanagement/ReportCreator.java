package com.example.projectmanagement;

import java.util.List;

public class ReportCreator {

    public static void createReport(List<Member> memberList, List<Assignment> assignmentList) {
        System.out.println("=== Assignment Report ===");
        for (Member member : memberList) {
            System.out.println("Member: " + member.getPersonName());
            System.out.println("Assigned Tasks: " + member.getTaskCount());
            System.out.println("___TASKS___");
            for (Assignment assignment : assignmentList) {
                
                    System.out.println("Assignment: " + assignment.getAssignmentTitle());
                    System.out.println("Status: " + assignment.getAssignmentStatus());
                    if (assignment.getAssignmentStatus() != AssignmentStatus.PENDING) {
                    System.out.println("Start Timestamp: " + assignment.getStartTimestamp());
                    System.out.println("Logged Hours: " + assignment.getLoggedHours());
                    System.out.println("Assogned to: " + assignment.getAssignedPerson());}
                    if (assignment.getAssignmentStatus() == AssignmentStatus.DONE) {
                        System.out.println("End Timestamp: " + assignment.getEndTimestamp());
                        System.out.println("Time Spent: " + assignment.getTimeSpent() + " seconds");
                    
                }
            }
        }
    }
}