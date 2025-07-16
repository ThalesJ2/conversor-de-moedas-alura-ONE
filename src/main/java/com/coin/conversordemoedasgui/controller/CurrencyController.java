package com.coin.conversordemoedasgui.controller;

import com.coin.conversordemoedasgui.service.ConverterService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.text.html.parser.Parser;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class CurrencyController implements Initializable {
    public ComboBox combo1;
    public ComboBox combo2;
    public Button calcularId;
    public TextField valueId;

    public TextField result;


    private ConverterService service = new ConverterService();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        result.setEditable(Boolean.FALSE);
        combo1.setItems(FXCollections.observableList(service.getAcronym()));
        combo2.setItems(FXCollections.observableList(service.getAcronym()));
    }

    public void onClick(ActionEvent actionEvent) {
        String option1 = combo1.getSelectionModel().getSelectedItem().toString();
        String option2 = combo2.getSelectionModel().getSelectedItem().toString();

        String log = "[LOG] "+ LocalDateTime.now()+"  ";
        if(service.isNumeric(valueId.getText())) {
            double value  = Double.parseDouble(valueId.getText());
            result.setText(((1/service.coinValue(option1) * service.coinValue(option2)) * value)+"");
            log = log + option1 +" para "+option2;
            service.addLog(log);
        }else {
            result.setText("Coloque Apenas numeros no campo.");
        }
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}