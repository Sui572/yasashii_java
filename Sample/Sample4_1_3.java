package Sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sample4_1_3 extends Application{
    private Button[][] bt = new Button[6][3];

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        for(int i=0; i<bt.length; i++){
            for(int j=0; j<bt[i].length; j++){
                bt[i][j] = new Button(Integer.toString(i) + Integer.toString(j));
            }
        }

        // ペインの作成
        GridPane gp = new GridPane();

        // ペインへの追加
        for(int i=0; i<bt.length; i++){
            for(int j=0; j<bt[i].length; j++){
                gp.add(bt[i][j], i,j);
            }
        }

        // シーンの作成
        Scene sc = new Scene(gp, 300, 200);

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("サンプル");
        stage.show();
    }    
}
