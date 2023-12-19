module kr.inhatc.fx.helloworld {
    requires javafx.controls;
    requires javafx.fxml;

    opens kr.inhatc.fx.helloworld to javafx.fxml;
    exports kr.inhatc.fx.helloworld;

}