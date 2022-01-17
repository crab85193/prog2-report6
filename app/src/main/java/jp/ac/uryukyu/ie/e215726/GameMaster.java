package jp.ac.uryukyu.ie.e215726;

import java.util.ArrayList;

/**
 * ゲームマスタークラス
 *  ArrayList players; //ゲームをプレイするプレイヤー情報を複数記憶するリスト
 *  ArrayList yaku_list; //役情報を記憶するリスト
 *  Field field; //フィールドクラスのインスタンス
 *  Command command; //コマンドクラスのインスタンス
 *  boolean isGameEnd; //ゲームの終了判定。true=終了。
 * Created by CrabAnderson on 2022/01/18.
 */

public class GameMaster {
    private ArrayList<Player> players;
    private ArrayList<Yaku> yaku_list;
    private Field field;
    private Command command;
    private boolean isGameEnd;

    /**
     * コンストラクタ
     *
     */
    GameMaster(){
        players = new ArrayList<Player>();
        yaku_list = new ArrayList<Yaku>();
        field = new Field();
        command = new Command();
        isGameEnd = false;

        players.add(new Player("Player"));
        players.add(new Player("CPU"));

        yaku_list.add(new Yaku("五光","松に鶴","桜に幕","芒に月","柳に小野道風","桐に鳳凰"));
        yaku_list.add(new Yaku("四光","松に鶴","桜に幕","柳に小野道風","桐に鳳凰"));
        yaku_list.add(new Yaku("三光","松に鶴","桜に幕","桐に鳳凰"));
        yaku_list.add(new Yaku("猪鹿蝶","萩に猪","紅葉に鹿","牡丹に蝶"));
        yaku_list.add(new Yaku("赤短","松に赤短","梅に赤短","桜に赤短"));
        yaku_list.add(new Yaku("青短","牡丹に青短","萩に短冊","紅葉に青短"));
        yaku_list.add(new Yaku("月見で一杯","芒に月","菊に盃"));
        yaku_list.add(new Yaku("花見で一杯","桜に幕","菊に盃"));
    }

    /**
     * 初期化する
     */
    public void init(){
        field.setFieldCards();
        for(var player : players){
            for(int i=0;i<8;i++){
                player.addHandCard(field.draw());
            }
        }
    }

    /**
     * ゲームを開始する
     */
    public void start(){
        while(!isGameEnd){
            for(var player : players){
                if(player.getName() != "CPU"){
                    showHandCards(player);

                    while(true){
                        int fieldCards_number = selectFieldCards(field.getFieldCards());
                        int handCards_number = selectHandCards(player.getHandCard());

                        if(field.getFieldCards().size() <= fieldCards_number){
                            if(checkDuplicateMonth(player)){
                                System.out.println("同じ月のカードが場に出ているので出せません。取ってください。");
                            }else{
                                field.addFieldCard(player.getHandCard().get(handCards_number));
                                player.removeHandCard(player.getHandCard().get(handCards_number));
                                break;
                            }
                        }else if(field.getFieldCards().get(fieldCards_number).getMonth() == player.getHandCard().get(handCards_number).getMonth()){
                            player.addTakeCard(player.getHandCard().get(handCards_number));
                            player.addTakeCard(field.getFieldCards().get(fieldCards_number));
                            player.removeHandCard(player.getHandCard().get(handCards_number));
                            field.removeFieldCard(field.getFieldCards().get(fieldCards_number));
                            break;
                        }else{
                            System.out.println("月が違うので取れません");
                        }
                    }

                    System.out.println("山札からカードを引きます");
                    var drawCard = field.draw();
                    System.out.println("-- 引いたカード --");
                    System.out.println(drawCard.getName() + ": " + drawCard.getMonth() + "月の" + drawCard.getType() + "札");

                    while(true){
                        int fieldCards_number = selectFieldCards(field.getFieldCards());

                        if(field.getFieldCards().size() <= fieldCards_number){
                            if(checkDuplicateMonth(drawCard)){
                                System.out.println("同じ月のカードが場に出ているので出せません。取ってください。");
                            }else{
                                field.addFieldCard(drawCard);
                                break;
                            }
                        }else if(field.getFieldCards().get(fieldCards_number).getMonth() == drawCard.getMonth()){
                            player.addTakeCard(drawCard);
                            player.addTakeCard(field.getFieldCards().get(fieldCards_number));
                            field.removeFieldCard(field.getFieldCards().get(fieldCards_number));
                            break;
                        }else{
                            System.out.println("月が違うので取れません");
                        }
                    }
                }else{

                }
                showTakeCards(player);
                checkYaku(player);
            }
        }
    }

    /**
     * フィールド上の札を表示する
     */
    public void showFieldCards(){
        System.out.println("-- 場の札 --");
        for(var fieldCard : field.getFieldCards()){
            System.out.println(fieldCard.getName() + ": " + fieldCard.getMonth() + "月の" + fieldCard.getType() + "札");
        }
        System.out.println();
    }

    /**
     * 手札を表示する
     * @param player 表示する手札を持っているプレイヤー
     */
    public void showHandCards(Player player){
        System.out.println("-- " + player.getName() + "の手札 --");
        for(var card : player.getHandCard()){
            System.out.println(card.getName() + ": " + card.getMonth() + "月の" + card.getType() + "札");
        }
        System.out.println();
    }

    /**
     * 取札を表示する
     * @param player 表示する取札を持っているプレイヤー
     */
    public void showTakeCards(Player player){
        System.out.println("-- " + player.getName() + "の取札 --");
        for(var card : player.getTakeCard()){
            System.out.println(card.getName() + ": " + card.getMonth() + "月の" + card.getType() + "札");
        }
        System.out.println();
    }

    /**
     * 役ができているか調べる
     * @param player 調べるプレイヤー
     */
    public void checkYaku(Player player){
        // ArrayList<Yaku> acquisitionYaku = new ArrayList<Yaku>();
        int kasu = 0;
        int tan = 0;
        int tane = 0;

        for(var yaku : yaku_list){
            int i=0;
            for(var take : player.getTakeCard()){
                for(var yaku_card : yaku.getCardInformation()){
                    if(take.getName() == yaku_card) i++;
                }
            }
            if(yaku.getCardInformation().size() == i){
                System.out.println(yaku.getYakuName());
            }
        }

        for(var take : player.getTakeCard()){
            if(take.getType() == "カス") kasu++;
            else if(take.getType() == "札") tan++;
            else if(take.getType() == "種") tane++;
        }
        if(kasu>=10){ System.out.println("カス" + String.valueOf(kasu-9) + "文"); }
        if(tan>=5){ System.out.println("タン" + String.valueOf(tan-4) + "文"); }
        if(tane>=5){ System.out.println("タネ" + String.valueOf(tane-4) + "文"); }
    }

    /**
     * フィールドのカードを取得できるか調べる
     * @param player 対象プレイヤー
     * @return 取得できるか否か
     */
    public boolean checkDuplicateMonth(Player player){
        for(var field_card : field.getFieldCards()){
            for(var hand_card : player.getHandCard()){
                if(field_card.getMonth() == hand_card.getMonth()) return true;
            }
        }
        return false;
    }

    /**
     * フィールドのカードを取得できるか調べる
     * @param card 調べるカード
     * @return 取得できるか否か
     */
    public boolean checkDuplicateMonth(Card card){
        for(var field_card : field.getFieldCards()){
            if(field_card.getMonth() == card.getMonth()) return true;
        }
        return false;
    }

    /**
     * フィールド上のカードを選択する
     * @param fealdCards フィールド上のカード
     * @return 選択したフィールド上のカード番号
     */
    public int selectFieldCards(ArrayList<Card> fealdCards){
        command.clearCommand();

        System.out.println("-- 場の札 --");
        for(var fieldCard : fealdCards){
            command.addCommand(fieldCard.getName() + ": " + fieldCard.getMonth() + "月の" + fieldCard.getType() + "札");
        }
        command.addCommand("カードを取らない");
        int fieldCards_number = command.waitUserCommand("どのカードを取りますか？");
        System.out.println();

        return fieldCards_number;
    }

    /**
     * 手札のカードを選択する
     * @param handCards 手札のカード
     * @return 選択した手札のカード番号
     */
    public int selectHandCards(ArrayList<Card> handCards){
        command.clearCommand();

        System.out.println("-- 手札 --");
        for(var card : handCards){
            command.addCommand(card.getName() + ": " + card.getMonth() + "月の" + card.getType() + "札");
        }
        int handCards_number = command.waitUserCommand("どのカードを場に出しますか？");
        System.out.println();

        return handCards_number;
    }
}
