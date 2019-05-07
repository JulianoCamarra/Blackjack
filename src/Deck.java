/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliano
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    final int totalcards;
    ArrayList<Card> deck = new ArrayList<>();
    boolean cardexists;

    public Deck() {
        this.cardexists = false;
        this.totalcards=44;
    }

   
    public void generateDeck() {
 //initialize the deck by adding all 52 cards using for loop//
        for (int i = 0; i < totalcards; i++) {
           
            Card c = new Card();

            if (alreadyExists(c) == false) {
                deck.add(c);
             
            } else {
                i--; 
                
            }
        }
    }
    
    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    public boolean alreadyExists(Card c) {
        boolean exists = false;
        
        for (Card currentcard : deck) {
          
            int rank= currentcard.getRank();
            String suit= currentcard.getSuit();

            if (c.getRank()==rank && c.getSuit().equals(suit)) {
                exists = true;
               
            }
        }
        return exists;
    }

    public void printDeck() {
        for (Card c : deck) {
            System.out.print(deck.indexOf(c));
            System.out.println(c);
        }
    }
    
    public Card findCard(int v, String s){
        Card returnCard=null;
        for (Card c:deck){
            if (c.getRank()==v && c.getSuit().equals(s)){
                System.out.println(c);
                returnCard=c;
            }
        } return returnCard;
    }
    
    public Card dealCard(){
        Card c= deck.get(0);
        deck.remove(0);
        deck.add(c);
        return c;
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }

}
