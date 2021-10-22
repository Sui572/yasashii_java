package Sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sample4_2_3 extends Application{
    private Label[] lb = new Label[3];
    private Image im;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        for(int i=0; i<lb.length; i++){
            lb[i] = new Label("車" + i + "はいかがですか？");
        }
        im = new Image(getClass().getResourceAsStream("car.jpg"));

        // コントロールの設定
        lb[0].setGraphic(new ImageView(im));
        lb[1].setGraphic(new ImageView(im));
        lb[1].setContentDisplay(ContentDisplay.RIGHT);
        lb[2].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        // ペインの作成
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        // ペインへの追加
        for(int i=0; i<lb.length; i++){
            vb.getChildren().add(lb[i]);
        }
        bp.setCenter(vb);

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("サンプル");
        stage.show();
    }
}
