package com.packt.learnjava.ch12_tools;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloWorldController {
    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfAge;

    @FXML
    protected void submitClicked(ActionEvent e) {
        String fn = tfFirstName.getText();
        String ln = tfLastName.getText();
        String age = tfAge.getText();
        int a = 42;
        try {
            a = Integer.parseInt(age);
        } catch (Exception ex) {
        }
        fn = fn.isBlank() ? "Nick" : fn;
        ln = ln.isBlank() ? "Samoylov" : ln;
        String hello = "Hello, " + fn + " " + ln + ", age " + a + "!";
        System.out.println("\n" + hello);
        Platform.exit();
    }
}
