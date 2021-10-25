package Sample;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.beans.property.*;

public class Sample5_3_2 extends Application{
    private Label lb;
    private TableView<RowData> tv;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage) throws Exception{
        // コントロールの作成
        lb = new Label("いらっしゃいませ。");
        tv = new TableView<RowData>();

        // コントロールの設定
        TableColumn<RowData, String> tc1 = new TableColumn<RowData, String>("日付");
        TableColumn<RowData, String> tc2 = new TableColumn<RowData, String>("営業");

        tc1.setCellValueFactory(new PropertyValueFactory<RowData, String>("date"));
        tc2.setCellValueFactory(new PropertyValueFactory<RowData, String>("business"));

        ObservableList<RowData> ol = FXCollections.observableArrayList();
        for(int i=0; i<50; i++){
            ol.add(new RowData(i));
        }

        tv.getColumns().add(tc1);
        tv.getColumns().add(tc2);

        tv.setItems(ol);

        // ペインの作成
        BorderPane bp = new BorderPane();

        // ペインへの追加
        bp.setTop(lb);
        bp.setCenter(tv);

        // シーンの作成
        Scene sc = new Scene(bp, 300, 200);

        // ステージへの追加
        stage.setScene(sc);

        // ステージの表示
        stage.setTitle("サンプル");
        stage.show();
    }

    // RowDataクラス
    public class RowData{
        private final SimpleStringProperty date;
        private final SimpleStringProperty business;

        public RowData(int row){
            DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY/MM/dd");
            LocalDateTime t = LocalDateTime.now();
            LocalDateTime d = t.plusDays(row);

            this.date = new SimpleStringProperty(df.format(d));

            if(d.getDayOfWeek() == DayOfWeek.SUNDAY)
                this.business = new SimpleStringProperty("休業日です。");
            else this.business = new SimpleStringProperty("営業日です。");
        }
        public StringProperty dateProperty(){return date;}
        public StringProperty businessProperty(){return business;}
    }
}
