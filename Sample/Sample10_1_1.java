package Sample;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Sample10_1_1 {
    public static void main(String[] args) throws Exception{
        // DOMの準備をする
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // 文書を読み込む
        Document doc = db.parse(new FileInputStream("Sample10_1_1.xml"));

        // 文書を書き出す
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.transform(new DOMSource(doc), new StreamResult("result.xml"));
        System.out.println("result.xmlに出力しました。");
    }
}
