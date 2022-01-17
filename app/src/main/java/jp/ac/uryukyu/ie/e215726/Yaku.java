package jp.ac.uryukyu.ie.e215726;

import java.util.ArrayList;

/**
 * 役クラス
 *  String yakuName; //役の名前
 *  String card1; //役構成に必要なカード１枚目
 *  String card2; //役構成に必要なカード２枚目
 *  String card3; //役構成に必要なカード３枚目
 *  String card4; //役構成に必要なカード４枚目
 *  String card5; //役構成に必要なカード５枚目
 *  ArrayList card_list; //役構成に必要なカードを記憶するリスト
 * Created by CrabAnderson on 2022/01/18.
 */

public class Yaku {
    private String yakuName;
    private String card1;
    private String card2;
    private String card3;
    private String card4;
    private String card5;
    private ArrayList<String> card_list;

    /**
     * コンストラクタ
     * 役構成にカードが５枚必要な場合
     *
     * @param _yakuName 役名
     * @param _card1 役構成に必要なカード１枚目
     * @param _card2 役構成に必要なカード２枚目
     * @param _card3 役構成に必要なカード３枚目
     * @param _card4 役構成に必要なカード４枚目
     * @param _card5 役構成に必要なカード５枚目
     */
    Yaku(String _yakuName,String _card1,String _card2,String _card3,String _card4,String _card5){
        yakuName = _yakuName;
        card1 = _card1;
        card2 = _card2;
        card3 = _card3;
        card4 = _card4;
        card5 = _card5;

        card_list = new ArrayList<String>();
        card_list.add(card1);
        card_list.add(card2);
        card_list.add(card3);
        card_list.add(card4);
        card_list.add(card5);
    }

    /**
     * コンストラクタ
     * 役構成にカードが４枚必要な場合
     *
     * @param _yakuName 役名
     * @param _card1 役構成に必要なカード１枚目
     * @param _card2 役構成に必要なカード２枚目
     * @param _card3 役構成に必要なカード３枚目
     * @param _card4 役構成に必要なカード４枚目
     */
    Yaku(String _yakuName,String _card1,String _card2,String _card3,String _card4){
        this(_yakuName,_card1,_card2,_card3,_card4,"undefined");
    }

    /**
     * コンストラクタ
     * 役構成にカードが３枚必要な場合
     *
     * @param _yakuName 役名
     * @param _card1 役構成に必要なカード１枚目
     * @param _card2 役構成に必要なカード２枚目
     * @param _card3 役構成に必要なカード３枚目
     */
    Yaku(String _yakuName,String _card1,String _card2,String _card3){
        this(_yakuName,_card1,_card2,_card3,"undefined","undefined");
    }

    /**
     * コンストラクタ
     * 役構成にカードが２枚必要な場合
     *
     * @param _yakuName 役名
     * @param _card1 役構成に必要なカード１枚目
     * @param _card2 役構成に必要なカード２枚目
     */
    Yaku(String _yakuName,String _card1,String _card2){
        this(_yakuName,_card1,_card2,"undefined","undefined","undefined");
    }

    /**
     * 役の名前を返すメソッド
     * @return 役名
     */
    public String getYakuName(){
        return yakuName;
    }

    /**
     * 役構成に必要なカードの情報を返すメソッド
     * @return 役構成に必要なカード情報
     */
    public ArrayList<String> getCardInformation(){
        card_list.remove("undefined");
        return card_list;
    }

}
