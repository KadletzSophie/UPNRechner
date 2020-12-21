package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author Sophie Kadletz
 * @version 21.12.2020
 */

public class Controller {
    private UPNModel model;

    @FXML
    private TextField eingabe_txt;

    @FXML
    private TextArea stack_txt;


    @FXML
    public void enterNumber(ActionEvent event) {
        Button source = (Button) event.getSource();
        eingabe_txt.appendText(source.getText());
    }

    @FXML
    public void enterComma() {  //Alle möglichen Fälle überlegt was sein kann wenn man ein Komma eingibt
        String tmp = eingabe_txt.getText();
        if (!tmp.contains(",")) {
            if (tmp.isEmpty()) {
                eingabe_txt.setText("0,");
            } else if (tmp.startsWith("-") && tmp.length() == 1) {
                eingabe_txt.appendText("0,");
            } else if (tmp.length() >= 1) {
                eingabe_txt.appendText(",");
            }
        }
    }

    @FXML
    public void enterSign() { //Ändert das Vorzeichen
        if (eingabe_txt.getText().contains("-")) {
            String tmp = eingabe_txt.getText();
            tmp = tmp.substring(1);
            eingabe_txt.setText(tmp);
        } else {
            String tmp = eingabe_txt.getText();
            tmp = "-" + tmp;
            eingabe_txt.setText(tmp);
        }
    }

    @FXML
    public void addStackNumbers() { //Rechenoperation: +
        confirmNumber();
        stack_txt.setText(checkMessage(model.addStackNumbers()));
    }

    @FXML
    public void substractStackNumbers() { //Rechenoperation: -
        confirmNumber();
        stack_txt.setText(checkMessage(model.substractStackNumbers()));
    }

    @FXML
    public void multiplyStackNumbers() { //Rechenoperation: *
        confirmNumber();
        stack_txt.setText(checkMessage(model.multiplyStackNumbers()));
    }

    @FXML
    public void divideStackNumbers() { //Rechenoperation: /
        confirmNumber();
        stack_txt.setText(checkMessage(model.divideStackNumbers()));
    }

    @FXML
    public void swapStackTop() { //Tauscht die oberen zwei Wertw
        confirmNumber();
        stack_txt.setText(checkMessage(model.swapStackTop()));
    }

    @FXML
    public void invertStackTop() { //Kehwert der oberen Zahl
        confirmNumber();
        stack_txt.setText(checkMessage(model.invertStackTop()));
    }

    @FXML
    public void addNumber() {
        confirmNumber();
    }

    @FXML
    public void clearEnteredNumber() {
        eingabe_txt.setText("");
    }

    @FXML
    public void clearStack() {
        eingabe_txt.setText("");
        stack_txt.setText(model.clearStack());
    }

    private String checkMessage(String message) {
        if (message.startsWith("a")) {
            alertUser("Division by 0", "Please use a different Operation or swap values.");
            return message.substring(1);
        } else if (message.startsWith("e")) {
            alertUser("Missing Number", "Add numbers to use this operation.");
            return message.substring(1);
        } else {
            return message;
        }
    }

    public void alertUser(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void confirmNumber() {
        if (!eingabe_txt.getText().isEmpty()) {
            String num = eingabe_txt.getText();
            num = num.replace(",", ".");
            System.out.println(num);
            stack_txt.setText(model.addNumber(Double.parseDouble(num)));
            eingabe_txt.clear();
        }
    }

    @FXML
    private void initialize() {
        this.model = new UPNModel();
    }
}
