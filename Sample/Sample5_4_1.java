package Sample;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Sample5_4_1 extends Application{
    private Label lb;
    private MenuBar mb;
    private Menu[] mn = new Menu[4];
    private MenuItem[] mi = new MenuItem[7];

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");
        mb = new MenuBar();

        // コントロールの設定
        mn[0] = new Menu("メイン1");
        mn[1] = new Menu("メイン2");
        mn[2] = new Menu("サブ1");
        mn[3] = new Menu("サブ2");

        mi[0] = new MenuItem("乗用車");
        mi[1] = new MenuItem("トラック");
        mi[2] = new MenuItem("オープンカー");
        mi[3] = new MenuItem("タクシー");
        mi[4] = new MenuItem("スポーツカー");
        mi[5] = new MenuItem("ミニカー");
        mi[6] = new SeparatorMenuItem();

        mn[0].getItems().addAll(mi[0], mi[1]);
        mn[2].getItems().addAll(mi[2], mi[3]);
        mn[3].getItems().addAll(mi[4], mi[5]);

        mn[1].getItems().addAll(mn[2]);
        mn[1].getItems().addAll(mi[6], mn[3]);

        mb.getMenus().addAll(mn[0], mn[1]);
        
        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(mb);
        bp.setCenter(lb);

        // イベントハンドラの登録
        for(int i=0; i<mi.length; i++){
            mi[i].setOnAction(new SampleEventHandler());
        }

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
            MenuItem tmp = (MenuItem) e.getSource();
            String str = tmp.getText();
            lb.setText(str + "ですね");
        }
    }
}
