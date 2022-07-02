package de.linushoja.fire.agtueberwachung.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public abstract class CustomControl extends AnchorPane {
    private final CustomController controller;

    public CustomControl(String fxmlFile, Class<? extends CustomController> controllerClass) {
        super();
        try {
            FXMLLoader loader = new FXMLLoader(CustomControl.class.getResource(fxmlFile));
            controller = controllerClass.getConstructor().newInstance();
            loader.setController(controller);
            Node rootNode = loader.load();
            this.getChildren().add(rootNode);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 IOException e) {
            throw new RuntimeException(e);
        }
    }
}
