package org.test.afterburnermfxtest.view.mainView;

import org.test.afterburnermfxtest.view.leftView.LeftView;
import org.test.afterburnermfxtest.view.rightView.RightView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author joerg
 */
public class MainController implements Initializable {

    @FXML
    private BorderPane mainView;
    
    @FXML
    private Pane leftPane;
    
    @FXML
    private Pane rightPane;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        mainView.widthProperty().addListener((observable, oldValue, newValue) -> {
            leftPane.setPrefWidth(newValue.doubleValue()/2);
            rightPane.setPrefWidth(newValue.doubleValue()/2);
        });
        
        addLeftView();
        addRightView();
    }
    
    private void addLeftView() {
        final LeftView leftView = new LeftView();
        
        leftPane.getChildren().add(leftView.getView());
        /** 
         * Following does not work on android using dalvik-sdk-8u60-b5.
         * The class java.util.concurrent.CompletableFuture in compat-1.0.0.jar
         * uses UNSAFE = sun.misc.Unsafe.getUnsafe().
         * This throws java.lang.SecurityException: Unsafe access denied
         */
//        leftView.getView (leftPane.getChildren()::add);
//        leftView.getViewAsync(leftPane.getChildren()::add);
        
        leftPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            ((Pane)leftView.getView()).setPrefHeight(newValue.doubleValue());
        });

        leftPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            ((Pane)leftView.getView()).setPrefWidth(newValue.doubleValue());
        });
    }
    
    private void addRightView() {
        final RightView rightView = new RightView();
        
        rightPane.getChildren().add(rightView.getView());
        /** 
         * Following does not work on android using dalvik-sdk-8u60-b5.
         * The class java.util.concurrent.CompletableFuture in compat-1.0.0.jar
         * uses UNSAFE = sun.misc.Unsafe.getUnsafe().
         * This throws java.lang.SecurityException: Unsafe access denied
         */
//        rightView.getView(rightPane.getChildren()::add);
//        rightView.getViewAsync(rightPane.getChildren()::add);
        
        rightPane.heightProperty().addListener((observable, oldValue, newValue) -> {
            ((Pane)rightView.getView()).setPrefHeight(newValue.doubleValue());
        });

        rightPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            ((Pane)rightView.getView()).setPrefWidth(newValue.doubleValue());
        });
    }
}
