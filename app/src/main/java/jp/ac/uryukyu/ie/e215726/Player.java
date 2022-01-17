package jp.ac.uryukyu.ie.e215726;

import java.util.ArrayList;

/**
 * プレイヤークラス
 *  String name; //プレイヤー名
 *  ArrayList<Card> hand; //手札
 *  ArrayList<Card> take; //取札
 * Created by CrabAnderson on 2022/01/18.
 */

public class Player {
    private String name;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> take = new ArrayList<Card>();

    /**
     * コンストラクタ
     *
     * @param name プレイヤー名
     */
    Player(String name){
        this.name = name;
    }

    /**
     * プレイヤーの名前を返すメソッド
     * @return プレイヤー名
     */
    public String getName(){
        return name;
    }

    /**
     * プレイヤーの手札を追加するメソッド
     * @param card 追加するカード
     */
    public void addHandCard(Card card){
        hand.add(card);
    }

    /**
     * プレイヤーの手札を削除するメソッド
     * @param card 削除するカード
     */
    public void removeHandCard(Card card){
        hand.remove(card);
    }

    /**
     * プレイヤーの手札を返すメソッド
     * @return 手札
     */
    public ArrayList<Card> getHandCard(){
        return hand;
    }

    /**
     * プレイヤーの取札を追加するメソッド
     * @param card 追加するカード
     */
    public void addTakeCard(Card card){
        take.add(card);
    }

    /**
     * プレイヤーの取札を取得するメソッド
     * @return 取札
     */
    public ArrayList<Card> getTakeCard(){
        return take;
    }
}
