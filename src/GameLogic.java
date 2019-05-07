/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliano
 */
public class GameLogic {
    
    private Deck gameDeck;
    private Player player;
    private CpuPlayer cpu;
    
    
    public GameLogic(Deck deck, Player player, CpuPlayer cpu){
        
        this.gameDeck=deck;
        this.player=player;
        this.cpu=cpu;
    }
}
