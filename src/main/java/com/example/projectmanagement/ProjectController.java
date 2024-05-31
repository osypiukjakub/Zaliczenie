package com.example.projectmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectController {
    @FXML
    private TextField personNameInput;

    @FXML
    private TextField assignmentTitleInput;

    @FXML
    private TextField assignmentDetailsInput;

    @FXML
    private ComboBox<Member> personSelector;

    @FXML
    private ComboBox<Assignment> assignmentSelector;

    @FXML
    private ListView<Assignment> assignmentListView;

    private List<Member> memberRecords = new ArrayList<>();
    private List<Assignment> assignmentRecords = new ArrayList<>();
    private ObservableList<Assignment> observableAssignmentList;

    public void initialize() {
        observableAssignmentList = FXCollections.observableArrayList(assignmentRecords);
        assignmentListView.setItems(observableAssignmentList);
        assignmentListView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Assignment assignment, boolean empty) {
                super.updateItem(assignment, empty);
                if (empty || assignment == null) {
                    setText(null);
                } else {
                    setText(assignment.getAssignmentTitle() + " - " + assignment.getAssignmentStatus());
                }
            }
        });
    }

    @FXML
    private void addPerson() {
        String name = personNameInput.getText();
        if (!name.isEmpty()) {
            Member newMember = new Member(name);
            memberRecords.add(newMember);
            personSelector.getItems().add(newMember);
            personNameInput.clear();
        }
    }

    @FXML
    private void addAssignment() {
        String title = assignmentTitleInput.getText();
        String details = assignmentDetailsInput.getText();
        if (!title.isEmpty() && !details.isEmpty()) {
            Assignment newAssignment = new Assignment(title, details);
            assignmentRecords.add(newAssignment);
            observableAssignmentList.add(newAssignment);
            assignmentSelector.getItems().add(newAssignment);
            assignmentTitleInput.clear();
            assignmentDetailsInput.clear();
        }
    }

    @FXML
    private void assignPerson() {
        Member person = personSelector.getValue();
        Assignment assignment = assignmentSelector.getValue();
        if (person != null && assignment != null) {
            assignment.assignTo(person);
            observableAssignmentList.set(observableAssignmentList.indexOf(assignment), assignment);
        }
    }

    @FXML
    private void generateReport() {
        ReportCreator.createReport(memberRecords, assignmentRecords);
    }
}
