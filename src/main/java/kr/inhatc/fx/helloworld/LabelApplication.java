package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LabelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Label label = new Label("라벨");

        TextField textField = new TextField();
        textField.setPromptText("입력하세요");

        Button btn = new Button("버튼");
        btn.setOnAction(e -> {
            System.out.println("버튼 클릭");
            String str = textField.getText().trim();        // trim() : 앞뒤 공백 제거
            label.setText(str);
        });

        Button btn2 = new Button("버튼2");
        btn2.setOnAction(e -> {
            textField.setText("");
            label.setText("");
        });

        TextArea textArea = new TextArea();
        Button btn3 = new Button("버튼3");
        btn3.setOnAction(e -> {
            String str = textField.getText().trim();
            textField.setText("");
            textArea.appendText(str + "\n");
            textField.requestFocus();
        });

        VBox vBox = new VBox(textField, label, btn, btn2, btn3, textArea);

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Label");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}