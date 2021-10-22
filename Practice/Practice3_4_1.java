package Practice;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.*;

public class Practice3_4_1 extends Application{
    private Label lb;
    private Button bt;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ");
        bt = new Button("購入");

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb);
        bp.setCenter(bt);

        // イベントハンドラの登録
        bt.setOnAction(new PracticeEventHandler());

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("練習");
        stage.show();
    }

    // イベントハンドラクラス
    class PracticeEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            bt.setText("Thanks!");
        }
    }
}
