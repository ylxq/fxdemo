package com.tao.fx;

import com.tao.fx.luckdraw.Prize;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

/**
 * @author taowenchen
 */
public class Controller implements Initializable {

    private final List<Prize> prizes = new ArrayList<>();
    private final List<Color> colors = Arrays.asList(Color.BLUE, Color.BROWN, Color.BURLYWOOD, Color.CHOCOLATE, Color.CORNFLOWERBLUE, Color.CYAN, Color.DARKGOLDENROD);

    @FXML
    private Pane pane;

    @FXML
    private Circle circle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        prizes.add(Prize.builder().name("一等奖").percent(1).build());
        prizes.add(Prize.builder().name("二等奖").percent(5).build());
        prizes.add(Prize.builder().name("三等奖").percent(10).build());
        prizes.add(Prize.builder().name("四等奖").percent(84).build());

        int perAngle = 360 / prizes.size();

        for (int i = 0; i < prizes.size(); i++) {
            // 画第一片扇形，同样的方式固定圆心，根据圆的半径来改变扇形半径，使其与圆的边沿存在间隙
            Arc arc = new Arc();
            arc.centerXProperty().bind(circle.layoutXProperty());
            arc.centerYProperty().bind(circle.layoutYProperty());
            arc.radiusXProperty().bind(circle.radiusProperty().divide(1.0));
            arc.radiusYProperty().bind(circle.radiusProperty().divide(1.0));
            // 定义弧的起始角度
            double startAngle = 45;
            arc.setStartAngle(i * perAngle + startAngle);
            // 弧的角度范围
            arc.setLength(perAngle);
            arc.setFill(colors.get(i));
            arc.setType(ArcType.ROUND);

//            <Arc fill="DODGERBLUE" layoutX="299.0" layoutY="201.0" length="90.0" radiusX="100.0" radiusY="100.0" startAngle="45.0" stroke="BLACK" strokeType="INSIDE" type="ROUND" />
//            <Text layoutX="280.0" layoutY="127.0" strokeType="OUTSIDE" strokeWidth="0.0" text="怎么样看敬礼敬礼敬礼就" wrappingWidth="41.0" />


            Text text = new Text();
            pane.getChildren().add(arc);
        }


    }


    Random random = new Random();

    public void rotate(Event event) {
        int i = random.nextInt(120)+50;
        RotateTransition rt = new RotateTransition(Duration.seconds(3), pane);
        rt.setByAngle(i+360*20);
        rt.setCycleCount(1);
        rt.setInterpolator(Interpolator.EASE_OUT);
        rt.play();

    }


}
