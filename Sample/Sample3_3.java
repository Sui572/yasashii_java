package Sample;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Sample3_3 extends Application{
    private Label lb;
    private Button bt;
    
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");
        bt = new Button("購入");

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb);
        bp.setCenter(bt);

        // イベントハンドラの登録
        bt.setOnAction(new SampleEventHandler());

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
            lb.setText("ご購入ありがとうございます。");
        }
    }
}
