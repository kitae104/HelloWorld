package kr.inhatc.fx.helloworld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ListViewApplication2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ListView<Person> listView = new ListView<>();
        ObservableList<Person> observableList = FXCollections.observableArrayList();
        listView.setItems(observableList);

        // 마우스로 아이템 선택 이벤트
        listView.setOnMouseClicked(e -> {
            Person person = listView.getSelectionModel().getSelectedItem();   // 선택된 아이템
            int index = listView.getSelectionModel().getSelectedIndex();        // 선택된 인덱스
            if(person != null) {                          // null이 아닌 경우만 처리를 위해
                System.out.println(person.getName() + " : " + person.getAge());
            }
        });

        // 항목 선택 변경 이벤트 (이전, 이후)
        listView.getSelectionModel().selectedItemProperty().addListener((ObservableValue, oldValue, newValue) -> {
            System.out.println("이전 : " + oldValue);
            System.out.println("이전 : " + newValue);
        });

        Button btn = new Button("Add");
        btn.setOnAction(e -> {
            Person person1 = new Person("홍길동", 20);
            Person person2 = new Person("이순신", 30);
            Person person3 = new Person("강감찬", 40);

            observableList.addAll(person1, person2, person3);       // 아이템 추가
        });

        Button btn2 = new Button("Remove");
        btn2.setOnAction(e -> {
            int index = listView.getSelectionModel().getSelectedIndex();    // 선택된 인덱스
            observableList.remove(index);                                   // 선택된 인덱스의 아이템 삭제
        });

        Button btn3 = new Button("Update");
        btn3.setOnAction(e -> {
            Person person = listView.getSelectionModel().getSelectedItem();
            int index = listView.getSelectionModel().getSelectedIndex();    // 선택된 인덱스
            if(person != null){
                person.setName("수정");
                person.setAge(100);
                observableList.set(index, person);      // 선택된 인덱스의 아이템 수정
            }
        });

        Button btn4 = new Button("Info");
        btn4.setOnAction(e -> {
            Person person = listView.getSelectionModel().getSelectedItem();
            if(person != null){
                System.out.println(person.getName() + " : " + person.getAge());
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