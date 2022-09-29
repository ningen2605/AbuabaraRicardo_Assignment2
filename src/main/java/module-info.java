module notationgroup.abuabararicardo_assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires junit;

    opens notationgroup.abuabararicardo_assignment2.notation to javafx.fxml;
    exports notationgroup.abuabararicardo_assignment2.notation;
}