
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juliano
 */
public class GuiBuilder {

    private final JFrame frame;
    private final JPanel panel;

    private final JLabel score;
    private final JLabel gameOver;
    private final JLabel cpuScore;

    private final JButton hit;
    private final JButton stayButton;
    private final JButton startNewGame;

    private int xAxis;
    private int yAxis;
    private int width;
    private int length;
    private int xAxisCPU;
    private int yAxisCPU;

    public GuiBuilder() {

        frame = new JFrame("Blackjack");
        panel = new JPanel(null);

        score = new JLabel();
        gameOver = new JLabel("hello");
        cpuScore = new JLabel("CPU score");

        hit = new JButton("Hit");
        stayButton = new JButton("Stay");
        startNewGame = new JButton("New game");

    }

    public void initComp() {

        // set up label boundaries and colors
        score.setBounds(167, 380, 100, 100);
        score.setForeground(Color.white);

        cpuScore.setBounds(0, 0, 50, 50);
        cpuScore.setForeground(Color.white);

        gameOver.setBounds(267, 380, 100, 100);
        gameOver.setForeground(Color.white);

        startNewGame.setBounds(200, 450, 200, 30);
        startNewGame.setVisible(false);   //only visible when game is over

        //initialize panel
        panel.setBackground(new Color(40, 95, 16));

        // initialize frame
        frame.setSize(600, 600);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
