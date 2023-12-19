package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BasicCalcApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TextField textField = new TextField();
        TextField textField2 = new TextField();


        Button btn = new Button("+");
        Button btn2 = new Button("-");
        Button btn3 = new Button("*");
        Button btn4 = new Button("/");

        Label label = new Label("결과 :");

        HBox hBox = new HBox(textField, textField2);
        hBox.setSpacing(5);

        HBox hBox2 = new HBox(btn, btn2, btn3);
        hBox2.setSpacing(5);

        VBox vBox = new VBox(hBox, hBox2, label);
        vBox.setSpacing(4);
        vBox.setPadding(new Insets(10, 10, 10, 10)); // 상, 우, 하, 좌 패딩 설정

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("초간단 계산기");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}