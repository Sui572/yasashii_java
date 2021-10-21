package Sample;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class Sample3_3_2 extends Application{
    private Label lb;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb);

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // イベントハンドラの登録
        sc.addEventHandler(MouseEvent.MOUSE_CLICKED, new SampleEventHandler());

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("サンプル");
        stage.show();
    }
    
    // イベントハンドラクラス
    class SampleEventHandler implements EventHandler<MouseEvent>{
        public void handle (MouseEvent e){
            lb.setText("ご購入ありがとうございます。");
        }
    }
}
