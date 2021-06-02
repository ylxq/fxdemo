package com.tao.fx;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Arc arc1;

    @FXML
    private Pane pane;

    @FXML
    private Circle circle;

    @FXML
    private Arc arc3;

    @FXML
    private Arc arc2;

    @FXML
    private Arc arc4;

    public void initialize(URL location, ResourceBundle resources) {

        RotateTransition rt = new RotateTransition(Duration.seconds(1), pane);
        rt.setByAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.play();  // 开始播放动画
    }
}
