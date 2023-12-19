package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ListViewApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ListView<String> listView = new ListView<>();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        listView.setItems(observableList);

        // 마우스로 아이템 선택 이벤트
        listView.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                String selected = listView.getSelectionModel().getSelectedItem();   // 선택된 아이템
                int index = listView.getSelectionModel().getSelectedIndex();        // 선택된 인덱스
                if(selected != null) {                          // null이 아닌 경우만 처리를 위해
                    String str = observableList.get(index);
                    System.out.println(selected);
                    System.out.println(str);
                }
            }
        });

        // 항목 선택 변경 이벤트 (이전, 이후)
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue, oldValue, newValue) -> {
            System.out.println("이전 : " + oldValue);
            System.out.println("이전 : " + newValue);
        });


        Button btn = new Button("Add");
        btn.setOnAction(e -> {
            observableList.add("item" + (observableList.size() + 1));       // 아이템 추가
        });

        Button btn2 = new Button("Remove");
        btn2.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();    // 선택된 인덱스
            observableList.remove(index);                                   // 선택된 인덱스의 아이템 삭제
        });

        Button btn3 = new Button("Update");
        btn3.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();    // 선택된 인덱스
            observableList.set(index, "item" + (index + 1) + " 수정");      // 선택된 인덱스의 아이템 수정
        });

        Button btn4 = new Button("Contain");
        btn4.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();    // 선택된 인덱스
            String str = "item" + (index + 1);
            if (observableList.contains(str)) {
                System.out.println(str + "이 존재합니다.");
            } else {
                System.out.println(str + "이 존재하지 않습니다.");
            }
        });


        VBox vBox = new VBox(listView, btn, btn2, btn3, btn4);

        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("ListView");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}