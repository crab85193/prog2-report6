package jp.ac.uryukyu.ie.e215726;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * コマンドクラス
 *  ArrayList<String> commands; //コマンドを追加するリスト
 *  Scanner scanner; //ユーザがコマンドを入力する際に使用するインスタンス
 * Created by CrabAnderson on 2022/01/18.
 */
public class Command {
    private ArrayList<String> commands;
    private Scanner scanner;

    /**
     * コンストラクタ
     *
     */
    Command(){
        scanner = new Scanner(System.in);
        commands = new ArrayList<String>();
    }

    /**
     * コマンドを追加するメソッド
     * @param command 追加するコマンド名
     */
    public void addCommand(String command){
        commands.add(command);
    }

    /**
     * コマンドを削除するメソッド
     * @param command 削除するコマンド名
     */
    public void removeCommand(String command){
        commands.remove(command);
    }

    /**
     * コマンドを全削除するメソッド
     */
    public void clearCommand(){
        commands.clear();
    }

    /**
     * ユーザーからのコマンド入力を受け付けるメソッド
     * @param message コマンド入力の際に表示するメッセージ
     * @return ユーザーの入力したコマンド番号
     */
    public int waitUserCommand(String message){
        int index = 0;
        for(var command : commands){
            System.out.println(index + ": " + command);
            index += 1;
        }
        System.out.print(message + ": ");
        while(true){
            int input = scanner.nextInt();

            if(input>=0 && input<commands.size()){
                return input;
            }
        }
    }
}
