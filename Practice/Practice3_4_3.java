package Practice;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Practice3_4_3 extends Application{
    private Label lb1, lb2;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの設定
        lb1 = new Label("キーを入力してください。");
        lb2 = new Label();

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb1);
        bp.setBottom(lb2);

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // イベントハンドラの登録
        sc.setOnKeyPressed(new PracticeEventHandler());

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("練習");
        stage.show();
    }
    // イベントハンドラクラス
    class PracticeEventHandler implements EventHandler<KeyEvent>{
        public void handle(KeyEvent e){
            //String str;
            KeyCode k = e.getCode();
            lb2.setText(k.toString() + "ですね。");

        }
    }
}
