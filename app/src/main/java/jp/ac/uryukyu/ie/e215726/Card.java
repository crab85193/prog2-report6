package jp.ac.uryukyu.ie.e215726;

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
     * img（札の画像名）を返すメソッド
     * @return 画像名
     */
    public String getImgName(){
        return img;
    }

    /**
     * name（札の名前）を返すメソッド
     * @return 札名
     */
    public String getName(){
        return name;
    }

    /**
     * month（札の月）を返すメソッド
     * @return 札の月
     */
    public int getMonth(){
        return month;
    }

    /**
     * flower（札の花名）を返すメソッド
     * @return 札の花名
     */
    public String getFlower(){
        return flower;
    }

    /**
     * type（札の種類）を返すメソッド
     * @return 札の種類
     */
    public String getType(){
        return type;
    }

    /**
     * score（札の点数）を返すメソッド
     * @return 札の点数
     */
    public int getScore(){
        return score;
    }

    /**
     * img（札の画像名）を設定するメソッド
     * @param _img 画像名
     */
    public void setImgName(String _img){
        img = _img;
    }

    /**
     * name（札の名前）を設定するメソッド
     * @param _name 札名
     */
    public void setName(String _name){
        name = _name;
    }

    /**
     * month（札の月）を設定するメソッド
     * @param _month 札の月
     */
    public void setMonth(int _month){
        month = _month;
    }

    /**
     * flower（札の花名）を設定するメソッド
     * @param _flower 札の花名
     */
    public void setFlower(String _flower){
        flower = _flower;
    }

    /**
     * type（札の種類）を設定するメソッド
     * @param _type 札の種類
     */
    public void setType(String _type){
        type = _type;
    }

    /**
     * score（札の点数）を設定するメソッド
     * @param _score 札の点数
     */
    public void setScore(int _score){
        score = _score;
    }
}
