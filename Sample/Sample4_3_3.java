package Sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Sample4_3_3 extends Application{
    private Label lb;
    private RadioButton rb1, rb2;
    private ToggleGroup tg;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");
        rb1 = new RadioButton("車");
        rb2 = new RadioButton("トラック");
        tg = new ToggleGroup();

        // トグルグループへの追加
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);

        rb1.setSelected(true);

        // ペインの作成
        BorderPane bp = new BorderPane();
        HBox hb = new HBox();

        // ペインへの追加
        hb.getChildren().add(rb1);
        hb.getChildren().add(rb2);
        hb.setAlignment(Pos.CENTER);

        bp.setTop(lb);
        bp.setCenter(hb);

        // イベントハンドラの登録
        rb1.setOnAction(new SampleEventHandler());
        rb2.setOnAction(new SampleEventHandler());

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
            RadioButton tmp = (RadioButton) e.getSource();
            lb.setText(tmp.getText() + "を選びました。");
        }
    }
}
