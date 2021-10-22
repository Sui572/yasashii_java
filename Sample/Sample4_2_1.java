package Sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sample4_2_1 extends Application{
    private Label[] lb = new Label[3];

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        for(int i=0; i<lb.length; i++){
            lb[i] = new Label("車" + i + "はいかがですか？");
        }

        // コントロールの設定
        lb[0].setTextFill(Color.BLACK);
        lb[1].setTextFill(Color.BLUE);
        lb[2].setTextFill(Color.RED);

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
