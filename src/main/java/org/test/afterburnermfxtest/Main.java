package org.test.afterburnermfxtest;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.test.afterburnermfxtest.view.mainView.MainView;

public class Main extends Application {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Main.class);
    
    @Override
    public void start(Stage stage) {
        
        log.info("AfterburnerMfxTest - Main - start");
        final Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        final MainView mainView = new MainView();
        Scene scene = new Scene(mainView.getView(), visualBounds.getWidth(), visualBounds.getHeight());

        stage.setTitle("TouchEventDistributor");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
        
        stage.setScene(scene);
        stage.show();
    }

}
