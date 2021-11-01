package Sample;

import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.geometry.*;

public class Sample9_2_1 extends Application{
    private Label lb;
    private TextArea ta;
    private Button bt1, bt2;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("ファイルを選択してください。");
        ta = new TextArea();
        bt1 = new Button("読込");
        bt2 = new Button("保存");

        // ペインの作成
        BorderPane bp = new BorderPane();
        HBox hb = new HBox();

        // ペインの追加
        hb.getChildren().add(bt1);
        hb.getChildren().add(bt2);

        bp.setTop(lb);
        bp.setCenter(ta);
        bp.setBottom(hb);

        // イベントハンドラの登録
        bt1.setOnAction(new SampleEventHandler());
        bt2.setOnAction(new SampleEventHandler());

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
            if(e.getSource() == bt1){
                try{
                    File flo = fc.showOpenDialog(new Stage());
                    if(flo != null){
                        BufferedReader br = new BufferedReader(new FileReader(flo));
                        StringBuffer sb = new StringBuffer();
                        String str = null;
                        while((str = br.readLine()) != null){
                            sb.append(str + "\n");
                        }
                        ta.setText(sb.toString());
                        br.close();
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            else if(e.getSource() == bt2){
                try{
                    File fls = fc.showSaveDialog(new Stage());
                    if(fls != null){
                        BufferedWriter bw = new BufferedWriter(new FileWriter(fls));
                        String str = ta.getText();
                        bw.write(str);
                        bw.close();
                    }
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
