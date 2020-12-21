package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField eingabe_txt;

    @FXML
    private TextArea stack_txt;

    @FXML
    private Button bt_7;

    @FXML
    private Button bt_4;

    @FXML
    private Button bt_1;

    @FXML
    private Button bt_0;

    @FXML
    private Button bt_8;

    @FXML
    private Button bt_5;

    @FXML
    private Button bt_2;

    @FXML
    private Button komma_bt;

    @FXML
    private Button bt_9;

    @FXML
    private Button bt_6;

    @FXML
    private Button bt_3;

    @FXML
    private Button vorzeichen_bt;

    @FXML
    private Button enter_bt;

    @FXML
    private Button c_bt;

    @FXML
    private Button ce_bt;

    @FXML
    private Button plus_bt;

    @FXML
    private Button mal_bt;

    @FXML
    private Button kehrwert_bt;

    @FXML
    private Button minus_bt;

    @FXML
    private Button durch_bt;

    @FXML
    private Button vertauschen_bt;

    @FXML
    public void enterNumber(ActionEvent event) {

    }

    @FXML
    public void enterComma() {

    }

    @FXML
    public void enterSign() {

    }

    @FXML
    public void addStackNumbers() {

    }

    @FXML
    public void substractStackNumbers() {

    }

    @FXML
    public void multiplyStackNumbers() {

    }

    @FXML
    public void divideStackNumbers() {

    }

    @FXML
    public void swapStackTop() {

    }

    @FXML
    public void invertStackTop() {


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

    }


    public void confirmNumber() {

    }
}


