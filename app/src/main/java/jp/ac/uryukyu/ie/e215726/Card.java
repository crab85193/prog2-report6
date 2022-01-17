package jp.ac.uryukyu.ie.e215726;

/**
 * 札クラス
 *  String img; //札の画像名
 *  String name; //札の名前
 *  int month; //札の月
 *  String flower; //札の花名
 *  String type; //札の種類
 *  int score; //札単体の点数
 * Created by CrabAnderson on 2022/01/18.
 */
public class Card {
    private String img;
    private String name;
    private int month;
    private String flower;
    private String type;
    private int score;

    /**
     * コンストラクタ
     *
     * @param _img 画像名
     * @param _name 札名
     * @param _month 札の月
     * @param _flower 札の花名
     * @param _type 札の種類
     * @param _score 札の点数
     */
    Card(String _img,String _name,int _month,String _flower,String _type,int _score){
        img = _img;
        name = _name;
        month = _month;
        flower = _flower;
        type = _type;
        score = _score;
    }

    /**
     * 札の画像名を返すメソッド
     * @return 画像名
     */
    public String getImgName(){
        return img;
    }

    /**
     * 札の名前を返すメソッド
     * @return 札名
     */
    public String getName(){
        return name;
    }

    /**
     * 札の月を返すメソッド
     * @return 札の月
     */
    public int getMonth(){
        return month;
    }

    /**
     * 札の花名を返すメソッド
     * @return 札の花名
     */
    public String getFlower(){
        return flower;
    }

    /**
     * 札の種類を返すメソッド
     * @return 札の種類
     */
    public String getType(){
        return type;
    }

    /**
     * 札の点数を返すメソッド
     * @return 札の点数
     */
    public int getScore(){
        return score;
    }

    /**
     * 札の画像名を設定するメソッド
     * @param _img 画像名
     */
    public void setImgName(String _img){
        img = _img;
    }

    /**
     * 札の名前を設定するメソッド
     * @param _name 札名
     */
    public void setName(String _name){
        name = _name;
    }

    /**
     * 札の月を設定するメソッド
     * @param _month 札の月
     */
    public void setMonth(int _month){
        month = _month;
    }

    /**
     * 札の花名を設定するメソッド
     * @param _flower 札の花名
     */
    public void setFlower(String _flower){
        flower = _flower;
    }

    /**
     * 札の種類を設定するメソッド
     * @param _type 札の種類
     */
    public void setType(String _type){
        type = _type;
    }

    /**
     * 札の点数を設定するメソッド
     * @param _score 札の点数
     */
    public void setScore(int _score){
        score = _score;
    }
}
