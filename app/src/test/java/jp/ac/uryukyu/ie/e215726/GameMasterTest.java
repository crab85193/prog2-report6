package jp.ac.uryukyu.ie.e215726;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// import java.util.ArrayList;

public class GameMasterTest {
    GameMaster classUnderTest = new GameMaster();
    @Test
    void checkDuplicateMonthTest(){
        Card false_card = new Card("00.png","TESTCARD",13,"?","?",0);
        assertEquals(classUnderTest.checkDuplicateMonth(false_card), false);
    }

    // @Test
    // void selectFieldCardsTest(){
    //     ArrayList<Card> card_list = new ArrayList<Card>();
    //     card_list.add(new Card("01.png","松に鶴",1,"松","光",20));
    //     assertEquals(classUnderTest.selectFieldCards(card_list), 0);
    // }
}
