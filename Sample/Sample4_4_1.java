package Sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sample4_4_1 extends Application{
    private Label lb;
    private TextField tf;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");
        tf = new TextField();

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb);
        bp.setBottom(tf);

        // イベントハンドラの登録
        tf.setOnAction(new SampleEventHandler());

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("サンプル");
        stage.show();
    }

    // イベントハンドラクラス
    class SampleEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            lb.setText(tf.getText() + "ですね。");
        }
    }
}
