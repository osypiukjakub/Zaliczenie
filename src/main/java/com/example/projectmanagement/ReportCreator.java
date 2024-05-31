package com.example.projectmanagement;

import java.util.List;

public class ReportCreator {

    public static void createReport(List<Member> memberList, List<Assignment> assignmentList) {
        System.out.println("=== Assignment Report ===");
        for (Member member : memberList) {
            System.out.println("Member: " + member.getPersonName());
            System.out.println("Assigned Tasks: " + member.getTaskCount());
            long totalTimeSpent = assignmentList.stream()
                    .filter(assignment -> assignment.getAssignedPerson() != null && assignment.getAssignedPerson().equals(member))
                    .mapToLong(Assignment::getTimeSpent)
                    .sum();
            System.out.println("Total Time Spent on Tasks: " + totalTimeSpent + " hours");
        }
    }
}