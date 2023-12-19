package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Button btn = new Button("버튼");
        btn.setOnAction(actionEvent -> System.out.println("버튼 클릭"));

        VBox vBox = new VBox(btn);

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Button!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}