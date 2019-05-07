/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juliano
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public final class GUI {

    JFrame frame;
    JPanel panel;

    JLabel score;
    JLabel gameover;
    JLabel cpuscore;

    JButton newgame;
    JButton hit;
    JButton staybutton;

    Deck deck = new Deck();
    Player p = new Player(deck);
    CpuPlayer cpu = new CpuPlayer(deck);

    int xaxis = 100;
    int yaxis = 200;
    int width = 200;
    int length = 200;
    int xaxisCPU = 100;
    int yaxisCPU = 1;

    int numberofcards = 1;

    public GUI() {

        frame = new JFrame("Blackjack");
        initComp();
        initializeEvents();

        frame.setSize(600, 600);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initComp() {
        panel = new JPanel(null);
        panel.setBackground(new Color(40, 95, 16));

        score = new JLabel();
        score.setBounds(167, 380, 100, 100);
        score.setForeground(Color.white);

        gameover = new JLabel("hello");
        gameover.setBounds(267, 380, 100, 100);
        gameover.setForeground(Color.white);

        cpuscore = new JLabel("CPU score");
        cpuscore.setBounds(0, 0, 50, 50);

        hit = new JButton("Hit");
        hit.setBounds(100, 500, 200, 50);

        staybutton = new JButton("Stay");
        staybutton.setBounds(310, 500, 200, 50);

        newgame = new JButton("New game");

        deck.generateDeck();

        newgame.setBounds(200, 450, 200, 30);
        newgame.setVisible(false);

        panel.add(staybutton);
        panel.add(hit);
        panel.add(score);
        panel.add(gameover);
        panel.add(cpuscore);
        panel.add(newgame);
    }

    public void initializeEvents() {
        hitEvent();
        stayEvent();
        dealCPUCard();
    }

    public void showScore(Player player, JLabel l) {

        String i = String.valueOf(player.getCurrentScore());
        l.setText(i);
    }

     public void newGameEvent() {
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.newGame();
                deck.shuffle();
            }
        });
    }

    public void stayEvent() {
        staybutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameOver();
            }
        });
    }

    public void hitEvent() {

        hit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Card c = p.dealCard();
                showScore(p, score);
                JLabel newCardLabel = addCardToPanel(c, xaxis, yaxis);
                xaxis = newCardLabel.getX() + 110;
                
                if (p.checkForBust() == true || p.checkForBlackjack() == true) {
                    gameOver();
                }
            }
        }
        );
    }

       public void dealCPUCard() {

        Card c = cpu.dealCard();
        showScore(cpu, cpuscore);

        JLabel newCardLabel = addCardToPanel(c, xaxisCPU, yaxisCPU);
        xaxisCPU = newCardLabel.getX() + 110;
    }
    
    public JLabel addCardToPanel(Card c, int xAxis, int yAxis) {
        ImageIcon pic = new ImageIcon("/home/juliano/NetBeansProjects/Blackjack/src/PNG/" + c.getRank() + c.getSuit() + ".png");
        JLabel card = new JLabel(pic);

        card.setVisible(true);
        card.setBounds(xAxis, yAxis, 200, 200);
        panel.add(card);
        panel.repaint();

        return card;

    }
    
    public void gameOverScreen() {
        String text = p.finalScore(cpu);
        gameover.setText(text);
        hit.setEnabled(false);
        staybutton.setEnabled(false);
        gameover.setText(text);
        newgame.setVisible(true);
        newGameEvent();

    }

    public void gameOver() {
        if (p.checkForBust()) {
            gameOverScreen();

        } else {
            while (cpu.scoreIsLower(p)) {
                dealCPUCard();
            }
            gameOverScreen();
        }
    }
}
