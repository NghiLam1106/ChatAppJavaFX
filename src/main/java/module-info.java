module org.example.chatapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires org.apache.commons.lang3;
    requires javafx.media;

    // Mở gói chứa các controller cho javafx.fxml
    opens org.example.chatapp.Client.controller to javafx.fxml;

    // Xuất gói Main cho các module khác nếu cần
    exports org.example.chatapp.Client.Main;
}
