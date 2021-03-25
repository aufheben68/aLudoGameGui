/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import com.ludogame.gameentities.Die;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ody
 */
public class DiePanel extends JPanel {
    
    public DiePanel(){
        setPreferredSize(new Dimension(250,750));
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        JPanel dieMainPanel = new JPanel(new BorderLayout());
        add(dieMainPanel,BorderLayout.CENTER);
        dieMainPanel.setBackground(Color.CYAN);
        dieMainPanel.revalidate();
        
      
        //Edw dhmiourgoume to koumpi gia to zari kai kaloume enan ClickListener o opoios kanei implement ton ActionListener
        //prokeimenou na enallasoume ta arxeia eikonas kai analoga to apotelesma tou zariou na emfanizetai kai i katallili 
        JButton dice = new JButton("Ρίξε το ζάρι!");
        dice.setBackground(Color.orange);
        ClickListener diceListener = new ClickListener(dieMainPanel);
        dice.addActionListener(diceListener);
        add(dice, BorderLayout.NORTH);
                
        JLabel playersPlaying = new JLabel("Συνδεδεμένοι Παίκτες : " );
        JTextArea  playersPlayingTextArea = new JTextArea(5,20);
        playersPlayingTextArea.setEditable(false);
        //playersPlayingTextArea.setText(message);
        
        JLabel playerCurrentlyPlaying = new JLabel("Σειρά Παίκτη : ");
        JTextField playerCurrentlyPlayingText = new JTextField();
        playerCurrentlyPlayingText.setPreferredSize(new Dimension(100,30));
        playerCurrentlyPlayingText.setEditable(false);
        
        JLabel playerColor = new JLabel("Χρώματα Παικτών : " );
        JTextArea playerColorTextArea = new JTextArea(5,20);
        playerColorTextArea.setEditable(false);
        
        playerCurrentlyPlaying.setForeground(Color.PINK);
        playersPlaying.setForeground(Color.PINK);
        playerColor.setForeground(Color.PINK);
        
        JPanel southPanel= new JPanel(new FlowLayout());
        southPanel.add(playersPlaying);
        southPanel.add(playersPlayingTextArea);
        southPanel.add(playerColor);
        southPanel.add(playerColorTextArea);
        southPanel.add(playerCurrentlyPlaying);
        southPanel.add(playerCurrentlyPlayingText);
        southPanel.setBackground(Color.BLACK);
        southPanel.setPreferredSize(new Dimension(250,300));
        add(southPanel,BorderLayout.SOUTH);
    }
    
    
    private class ClickListener implements ActionListener {

        Die die = new Die();
        private JPanel panel;

        public ClickListener(JPanel p) {
            panel = p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            Random rand = new Random();
            int dieRand = rand.nextInt(6);
            dieRand += 1;
            die.setDieNum(dieRand);

            ImageIcon die1;
            String diePath = "dice/default_skin/" + dieRand + ".png";
            try {
                panel.removeAll();
                JPanel diePane1 = new JPanel();
                die1 = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(diePath)));
                Image image = die1.getImage();
                Image newImg = image.getScaledInstance(250, 200, java.awt.Image.SCALE_SMOOTH);
                panel.add((new JLabel(new ImageIcon(newImg))));
                panel.repaint();
                panel.revalidate();
            } catch (IOException ex) {
                Logger.getLogger(Die.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
