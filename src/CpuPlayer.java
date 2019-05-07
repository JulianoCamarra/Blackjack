/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliano
 */
public class CpuPlayer extends Player {

    public CpuPlayer(Deck deck) {
        super(deck);
    }
    
    
    
    public boolean scoreIsLower(Player p){
        return currentscore<p.getCurrentScore();
    }
}
  

    
