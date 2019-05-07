/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliano
 */
import java.util.Random;

public class Card {

   private final Random random;   
   private final int rank;   
   private final String suit;
   private final String[] suits=new String[]{"C","D","H","S"};
 
    public Card() {
       random= new Random();
       suit= suits[random.nextInt(4)];
       rank=random.nextInt(13)+1;
       
    }
    
    public int getRank(){
        return rank;
    }
    
    public String getSuit(){
        return suit;
    }
    
   
    @Override
    public String toString(){
        return "["+rank+", "+suit+"]";
    }
}