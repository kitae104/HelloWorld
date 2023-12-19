package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class FindNumberApp extends Application {

    private int answer;

    @Override
    public void start(Stage stage) throws IOException {

        Random random = new Random();
        answer = random.nextInt(10) + 1;

        TextField textField = new TextField();
        textField.setPromptText("숫자를 입력하세요.");

        textField.setOnAction(e -> {
            try {
                int guess = Integer.parseInt(textField.getText().trim());
                if (guess == answer) {
                    System.out.println("정답입니다. 다시 시작합니다.");
                    answer = random.nextInt(10) + 1;
                } else if (guess > answer) {
                    System.out.println("숫자가 너무 큽니다.");
                } else {
                    System.out.println("숫자가 너무 작습니다.");
                }
            } catch (Exception ex) {
                System.out.println("숫자를 입력해주세요.");
            }


        });

        Label label = new Label("숫자를 1~10 사이의 숫자를 입력해주세요.");
        Label label2 = new Label("결과 : ");

        Button btn = new Button("버튼");
        btn.setOnAction(actionEvent -> System.out.println("버튼 클릭"));

        VBox vBox = new VBox(textField, label, label2);
        vBox.setSpacing(2);                                             // 컨트롤간의 간격 설정
        vBox.setPadding(new Insets(10, 10, 10, 10)); // 상, 우, 하, 좌 패딩 설정

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("숫자 찾기!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}