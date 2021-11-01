package Sample;

import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample9_1_3 extends Application{
    private Label lb1, lb2, lb3, lb4;
    private Button bt;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb1 = new Label("ファイルを選択してください。");
        lb2 = new Label();
        lb3 = new Label();
        lb4 = new Label();
        bt = new Button("選択");

        // ペインの作成
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();

        // ペインの追加
        vb.getChildren().add(lb1);
        vb.getChildren().add(lb2);
        vb.getChildren().add(lb3);
        vb.getChildren().add(lb4);

        bp.setTop(lb1);
        bp.setCenter(vb);
        bp.setBottom(bt);
        bp.setAlignment(bt, Pos.CENTER);

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
            FileChooser fc = new FileChooser();
            File f1 = fc.showOpenDialog(new Stage());
            if(f1 != null){
                lb2.setText("ファイル名は" + f1.getName() + "です。");
                lb3.setText("絶対パスは" + f1.getAbsolutePath() + "です。");
                lb4.setText("サイズは" + f1.length() + "バイトです。");
            }
        }
    }
}
