module com.coin.conversordemoedasgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;
    requires java.desktop;


    opens com.coin.conversordemoedasgui to javafx.fxml;
    exports com.coin.conversordemoedasgui;
    exports com.coin.conversordemoedasgui.controller;
    opens com.coin.conversordemoedasgui.controller to javafx.fxml;
}