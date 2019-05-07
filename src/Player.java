
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juliano
 */
public class Player {

    Deck deck;
    protected int currentscore = 0;
    int numberofaces = 0;
    boolean ace11;
    ArrayList<Card> hand = new ArrayList<>();

    public Player(Deck deck) {
        this.deck = deck;

    }

    public int getCurrentScore() {
        return currentscore;
    }

    public void newGame() {
        currentscore = 0;
        hand.clear();

    }

    public Card dealCard() {
        Card c = deck.dealCard();

        addCardToScore(c);

        //System.out.println("Your card is: " + c);
        checkForBust();
        return c;
    }

    public boolean aceExists() {
        boolean aceexists=false;
        for (Card c : hand) {
            if (numberofaces==1 && currentscore>11 && ace11==true){
                currentscore-=10; // we turn an 11 Ace into a 1 by subtracting 10
                aceexists=true;
            }
        } return aceexists;
    }

    public void addAceValue(){
        if (numberofaces>1|| currentscore>11){
            currentscore+=1;
            numberofaces++;
        } else {
            currentscore+=11;
            numberofaces++;
            ace11=true;
        }
    }

    public boolean checkForBust() {
        return currentscore > 21;
    }

    public boolean checkForBlackjack() {
        return currentscore == 21;
    }

    public String finalScore(Player p) {

        if (currentscore == 21) {
            return "Blackjack!";
        } else if (this.currentscore > p.getCurrentScore() && checkForBust()==false||p.checkForBust()) {
            return "You win!";
        } else if (checkForBust() && p.checkForBust()) {
            return "you lose";
        } else {return "you lose";
        }
    }

    public void addCardToScore(Card c) {
        switch (c.getRank()) {
            case 11:
            case 12:
            case 13:
                hand.add(c);
                 aceExists();
                currentscore += 10;         
                
                break;
            case 1: //1= Ace 

                addAceValue();

                break;
            default:
                hand.add(c);
                aceExists();
                currentscore += c.getRank();
                
                break;
        }
    }
}
