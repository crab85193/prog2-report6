package jp.ac.uryukyu.ie.e215726;

import java.util.ArrayList;
import java.util.Random;

/**
 * フィールドクラス
 *  ArrayList field; //フィールドにあるカードを記憶するためのリスト
 *  ArrayList stack; //山札のカードを記憶するためのリスト
 * Created by CrabAnderson on 2022/01/18.
 */

public class Field {
    private ArrayList<Card> field = new ArrayList<Card>();
    private ArrayList<Card> stack = new ArrayList<Card>();

    /**
     * コンストラクタ
     *
     */
    Field(){
        stack.add(new Card("01.png","松に鶴",1,"松","光",20));
        stack.add(new Card("02.png","松に赤短",1,"松","短冊",5));
        stack.add(new Card("03.png","松のカス",1,"松","カス",1));
        stack.add(new Card("04.png","松のカス",1,"松","カス",1));
        stack.add(new Card("05.png","梅に鴬",2,"梅","種",10));
        stack.add(new Card("06.png","梅に赤短",2,"梅","短冊",5));
        stack.add(new Card("07.png","梅にカス",2,"梅","カス",1));
        stack.add(new Card("08.png","梅にカス",2,"梅","カス",1));
        stack.add(new Card("09.png","桜に幕",3,"桜","光",20));
        stack.add(new Card("10.png","桜に赤短",3,"桜","短冊",5));
        stack.add(new Card("11.png","桜にカス",3,"桜","カス",1));
        stack.add(new Card("12.png","桜にカス",3,"桜","カス",1));
        stack.add(new Card("13.png","藤に不如帰",4,"藤","種",10));
        stack.add(new Card("14.png","藤に短冊",4,"藤","短冊",5));
        stack.add(new Card("15.png","藤にカス",4,"藤","カス",1));
        stack.add(new Card("16.png","藤にカス",4,"藤","カス",1));
        stack.add(new Card("17.png","杜若に八橋",5,"杜若","種",10));
        stack.add(new Card("18.png","杜若に短冊",5,"杜若","短冊",5));
        stack.add(new Card("19.png","杜若のカス",5,"杜若","カス",1));
        stack.add(new Card("20.png","杜若のカス",5,"杜若","カス",1));
        stack.add(new Card("21.png","牡丹に蝶",6,"牡丹","種",10));
        stack.add(new Card("22.png","牡丹に青短",6,"牡丹","短冊",5));
        stack.add(new Card("23.png","牡丹にカス",6,"牡丹","カス",1));
        stack.add(new Card("24.png","牡丹にカス",6,"牡丹","カス",1));
        stack.add(new Card("25.png","萩に猪",7,"萩","種",10));
        stack.add(new Card("26.png","萩に短冊",7,"萩","短冊",5));
        stack.add(new Card("27.png","萩にカス",7,"萩","カス",1));
        stack.add(new Card("28.png","萩にカス",7,"萩","カス",1));
        stack.add(new Card("29.png","芒に月",8,"芒","光",20));
        stack.add(new Card("30.png","芒に雁",8,"芒","短冊",5));
        stack.add(new Card("31.png","芒にカス",8,"芒","カス",1));
        stack.add(new Card("32.png","芒にカス",8,"芒","カス",1));
        stack.add(new Card("33.png","菊に盃",9,"菊","種",10));
        stack.add(new Card("34.png","菊に青短",9,"菊","短冊",5));
        stack.add(new Card("35.png","菊にカス",9,"菊","カス",1));
        stack.add(new Card("36.png","菊にカス",9,"菊","カス",1));
        stack.add(new Card("37.png","紅葉に鹿",10,"紅葉","種",10));
        stack.add(new Card("38.png","紅葉に青短",10,"紅葉","短冊",5));
        stack.add(new Card("39.png","紅葉にカス",10,"紅葉","カス",1));
        stack.add(new Card("40.png","紅葉にカス",10,"紅葉","カス",1));
        stack.add(new Card("41.png","柳に小野道風",11,"柳","光",20));
        stack.add(new Card("42.png","柳に燕",11,"柳","種",10));
        stack.add(new Card("43.png","柳に短冊",11,"柳","短冊",5));
        stack.add(new Card("44.png","柳にカス",11,"柳","カス",1));
        stack.add(new Card("45.png","桐に鳳凰",12,"桐","光",20));
        stack.add(new Card("46.png","桐にカス",12,"桐","カス",1));
        stack.add(new Card("47.png","桐にカス",12,"桐","カス",1));
        stack.add(new Card("48.png","桐にカス",12,"桐","カス",1));
    }

    /**
     * フィールドにカードを設定するメソッド
     */
    public void setFieldCards(){
        Random ra = new Random();
        for(int i=0;i<8;i++){
            int selector = ra.nextInt(stack.size());
            field.add(stack.get(selector));
            stack.remove(selector);
        }
    }

    /**
     * フィールドにカードを追加するメソッド
     * @param card 追加するカード
     */
    public void addFieldCard(Card card){
        field.add(card);
    }

    /**
     * フィールドからカードを削除するメソッド
     * @param card 削除するカード
     */
    public void removeFieldCard(Card card){
        field.remove(card);
    }

    /**
     * フィールドにあるカードを取得するメソッド
     * @return フィールド上にあるカード
     */
    public ArrayList<Card> getFieldCards(){
        return field;
    }

    /**
     * 山札にカードを追加するメソッド
     * @param card 追加するカード
     */
    public void addStackCard(Card card){
        stack.add(card);
    }

    /**
     * 山札からカードを削除するメソッド
     * @param card 削除するメソッド
     */
    public void removeStackCard(Card card){
        stack.remove(card);
    }

    /**
     * 山札にあるカードを取得するメソッド
     * @return 山札にあるカード
     */
    public ArrayList<Card> getStackCards(){
        return stack;
    }

    /**
     * 山札からカードを１枚引くメソッド
     * @return 引いたカード
     */
    public Card draw(){
        Random ra = new Random();
        int selector = ra.nextInt(field.size());
        Card select_card = stack.get(selector);
        stack.remove(selector);

        return select_card;
    }
}
