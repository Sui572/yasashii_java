package Sample;

import java.io.*;

public class Sample9_1_1 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("パラメータの数が違います。");
            System.exit(1);
        }

        try{
            File f1 = new File(args[0]);
            System.out.println("ファイル名は" + f1.getName() + "です。");
            System.out.println("絶対パスは" + f1.getAbsolutePath() + "です。");
            System.out.println("サイズは" + f1.length() + "バイトです。");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
