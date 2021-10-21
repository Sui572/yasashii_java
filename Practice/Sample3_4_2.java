package Practice;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sample3_4_2 extends Application{
    private Button bt;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage){
        // コントロールの作成
        bt = new Button("ようこそ。");

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setCenter(bt);

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // イベントハンドラの登録
        bt.addEventHandler(MouseEvent.MOUSE_ENTERED, new PracticeEventHandler());
        bt.addEventHandler(MouseEvent.MOUSE_EXITED, new PracticeEventHandler());

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("練習");
        stage.show();
    }

    // イベントハンドラクラス
    class PracticeEventHandler implements EventHandler<MouseEvent>{
        public void handle(MouseEvent e){
            if(e.getEventType() == MouseEvent.MOUSE_ENTERED){
                bt.setText("いらっしゃいませ。");
            }
            else if(e.getEventType() == MouseEvent.MOUSE_EXITED){
                bt.setText("ようこそ。");
            }
        }
    }
}
