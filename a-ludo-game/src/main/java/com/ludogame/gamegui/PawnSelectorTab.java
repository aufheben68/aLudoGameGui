/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import com.google.gson.Gson;
import com.ludogame.gameentities.Pawn;
import com.ludogame.gameentities.Player;
import static com.ludogame.gamegui.GuiTools.getResourceFolderFiles;
import static com.ludogame.gamefunctionality.ConnectServer.*;
import com.ludogame.gamefunctionality.Gameplay;
import static com.ludogame.gamegui.GuiTools.resize;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Gorj
 */
public class PawnSelectorTab {

    PawnSelectorTab(){
       //do nothing    
    }
    
    private ArrayList<String> loadPawnSkins = new ArrayList<String>();
    JLabel pawnSkinButton = new JLabel();
    
    public ArrayList<String> getLoadPawnSkins() {
        return loadPawnSkins;
    }

    public void setLoadPawnSkins(ArrayList<String> loadPawnSkins) {
        this.loadPawnSkins = loadPawnSkins;
    }
    
        public JLabel getPawnSkinButton() {
        return pawnSkinButton;
    }
    
    public void setPawnSkinButton(JLabel pawnSkinButton) {
        this.pawnSkinButton = pawnSkinButton;
    }
    
    public static void pawnSelectorTab(JTabbedPane tabs) {
        Player player = new Player();
        PawnSelectorTab pawnTab = new PawnSelectorTab();
        
        JPanel playerColorPanel  = new JPanel();
        JPanel pawnSelectorPanel = new JPanel();
        JPanel pawnSelectorTab   = new JPanel();
        Component emptySpace     = Box.createRigidArea(new Dimension(0, 10));
        final ArrayList<String> redPawnSkins    = new ArrayList<String>(getResourceFolderFiles("pawn_skins/red_pawn"));
        final ArrayList<String> bluePawnSkins   = new ArrayList<String>(getResourceFolderFiles("pawn_skins/blue_pawn"));
        final ArrayList<String> yellowPawnSkins = new ArrayList<String>(getResourceFolderFiles("pawn_skins/yellow_pawn"));
        final ArrayList<String> greenPawnSkins  = new ArrayList<String>(getResourceFolderFiles("pawn_skins/green_pawn"));
        
        JButton nextButton         = new JButton("Εκκίνηση Παιχνιδιού");
        JLabel playerNameLabel     = new JLabel("Όνομα παίχτη");
        JTextField playerNameField = new JTextField();
        playerNameField.setPreferredSize(new Dimension(300, 20));
        playerNameField.setMaximumSize(playerNameField.getPreferredSize());
        JLabel playerColorLabel    = new JLabel("Χρώμα πιονιού");
        JLabel playerPawnSkinLabel = new JLabel("Επιλογή πιονιού");
        
        playerColorPanel.setBackground(Color.GRAY);
        playerColorPanel.setLayout(new BoxLayout(playerColorPanel, BoxLayout.X_AXIS));
        pawnSelectorPanel.setBackground(Color.GRAY);
        pawnSelectorPanel.setLayout(new BoxLayout(pawnSelectorPanel, BoxLayout.X_AXIS));
        playerColorPanel.setPreferredSize(new Dimension(200, 200));
        playerColorPanel.setMaximumSize(playerColorPanel.getPreferredSize());

        ArrayList<JButton> playerColorButtons = new ArrayList<JButton>();

        JButton redColorButton = new JButton();
        redColorButton.setBackground(Color.RED);

        JButton blueColorButton = new JButton();
        blueColorButton.setBackground(Color.BLUE);

        JButton greenColorButton = new JButton();
        greenColorButton.setBackground(Color.GREEN);

        JButton yellowColorButton = new JButton();
        yellowColorButton.setBackground(Color.YELLOW);

        playerColorButtons.add(redColorButton);
        playerColorButtons.add(blueColorButton);
        playerColorButtons.add(greenColorButton);
        playerColorButtons.add(yellowColorButton);
        
        redColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redColorButton.setEnabled(false);
                player.setPlayerColor("red");
                
                removePawnSkins(pawnTab, pawnSelectorPanel, pawnSelectorTab);                
                pawnTab.setLoadPawnSkins(redPawnSkins);

                addPawnSkinsToPanel(pawnTab, player, pawnSelectorPanel, nextButton, emptySpace);
                //pawnSelectorTab.add(Box.createVerticalGlue());
                pawnSelectorTab.add(pawnSelectorPanel);
                pawnSelectorTab.add(emptySpace);
                pawnSelectorTab.add(nextButton);
                emptySpace.setVisible(false);
                nextButton.setVisible(false);
                yellowColorButton.setEnabled(true);
                greenColorButton.setEnabled(true);
                blueColorButton.setEnabled(true);

                pawnSelectorTab.revalidate();
                pawnSelectorTab.repaint();
            }
        });

        blueColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //blueColorButton.setBorder(new LineBorder(Color.BLACK));
                blueColorButton.setEnabled(false);
                player.setPlayerColor("blue");
                
                removePawnSkins(pawnTab, pawnSelectorPanel, pawnSelectorTab);
                pawnTab.setLoadPawnSkins(bluePawnSkins);
                
                addPawnSkinsToPanel(pawnTab, player, pawnSelectorPanel, nextButton, emptySpace);
                pawnSelectorTab.add(pawnSelectorPanel);
                pawnSelectorTab.add(emptySpace);
                pawnSelectorTab.add(nextButton);
                emptySpace.setVisible(false);
                nextButton.setVisible(false);
                //nextButton.setVisible(true);
                //pawnSelectorTab.add(Box.createVerticalGlue());
                yellowColorButton.setEnabled(true);
                greenColorButton.setEnabled(true);
                redColorButton.setEnabled(true);

                pawnSelectorTab.revalidate();
                pawnSelectorTab.repaint();
            }
        });

        greenColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //blueColorButton.setBorder(new LineBorder(Color.BLACK));
                greenColorButton.setEnabled(false);
                player.setPlayerColor("green");
                
                removePawnSkins(pawnTab, pawnSelectorPanel, pawnSelectorTab);
                pawnTab.setLoadPawnSkins(greenPawnSkins);
                addPawnSkinsToPanel(pawnTab, player, pawnSelectorPanel, nextButton, emptySpace);
                pawnSelectorTab.add(pawnSelectorPanel);
                pawnSelectorTab.add(emptySpace);
                pawnSelectorTab.add(nextButton);
                emptySpace.setVisible(false);
                nextButton.setVisible(false);
                //nextButton.setVisible(true);
                yellowColorButton.setEnabled(true);
                blueColorButton.setEnabled(true);
                redColorButton.setEnabled(true);

                pawnSelectorTab.revalidate();
                pawnSelectorTab.repaint();
            }
        });

        yellowColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //blueColorButton.setBorder(new LineBorder(Color.BLACK));
                yellowColorButton.setEnabled(false);
                player.setPlayerColor("yellow");
                
                removePawnSkins(pawnTab, pawnSelectorPanel, pawnSelectorTab);
                pawnTab.setLoadPawnSkins(yellowPawnSkins);
                addPawnSkinsToPanel(pawnTab, player, pawnSelectorPanel, nextButton, emptySpace);
                pawnSelectorTab.add(pawnSelectorPanel);
                pawnSelectorTab.add(emptySpace);
                pawnSelectorTab.add(nextButton);
                emptySpace.setVisible(false);
                nextButton.setVisible(false);
                greenColorButton.setEnabled(true);
                blueColorButton.setEnabled(true);
                redColorButton.setEnabled(true);

                pawnSelectorTab.revalidate();
                pawnSelectorTab.repaint();
            }
        });

        playerColorPanel.add(Box.createHorizontalGlue());
        for (JButton colorButton : playerColorButtons) {
            colorButton.setMaximumSize(new Dimension(30, 30));
            colorButton.setMinimumSize(new Dimension(30, 30));
            playerColorPanel.add(colorButton);
            playerColorPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        }
        playerColorPanel.add(Box.createHorizontalGlue());

        pawnSelectorTab.setLayout(new BoxLayout(pawnSelectorTab, BoxLayout.Y_AXIS));
        pawnSelectorTab.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        pawnSelectorTab.setBackground(Color.GRAY);

        pawnSelectorTab.add(Box.createVerticalGlue());
        pawnSelectorTab.add(playerNameLabel);
        pawnSelectorTab.add(emptySpace);
        pawnSelectorTab.add(playerNameField);
        pawnSelectorTab.add(emptySpace);

        pawnSelectorTab.add(playerColorLabel);
        pawnSelectorTab.add(emptySpace);
        pawnSelectorTab.add(playerColorPanel);
        
        pawnSelectorTab.add(playerPawnSkinLabel);
        pawnSelectorTab.add(emptySpace);
        pawnSelectorTab.add(pawnSelectorPanel);
        pawnSelectorTab.add(emptySpace);

        //pawnSelectorTab.add(nextButton);
        //nextButton.setVisible(false);
        pawnSelectorTab.add(Box.createVerticalGlue());

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*3*/
                if (!playerNameField.getText().isEmpty()){
                    player.setPlayerName(playerNameField.getText());
                }
                else{
                    player.setPlayerName("Player " + player.getPlayerColor());
                }
                
                //populate pawn arraylist                
                ArrayList<Pawn> pawnsCreate = new ArrayList<Pawn>();
                
                for ( int i = 0; i < 4; i++ )
                {
                    String namePawn = player.getPlayerColor() + i ;
                    Pawn playerPawn = new Pawn(player.getPlayerColor(), namePawn);
                    pawnsCreate.add(playerPawn);
                }
                
                player.setPawnsControl(pawnsCreate);
                                
                Gson gson   = new Gson();
                String json = gson.toJson(player);
                //System.out.println(json);
                sendToServer(json);

                tabs.setEnabledAt(1, false);
                tabs.setEnabledAt(2, true);
                /*TODO send to server player choices, get response and proceed or reject & reset fields*/
                tabs.setSelectedIndex(2);
            }
        });

        //pawnSelectorTab.add(nextButton);
        tabs.addTab("Παίχτης", pawnSelectorTab);
    }
    
    private static void addPawnSkinsToPanel(PawnSelectorTab pawnTab,Player player, JPanel pawnSelectorPanel, JButton nextButton, Component emptySpace)
    {
        Border pawnButtonBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        pawnSelectorPanel.add(Box.createHorizontalGlue());
        for (String pawnSkin : pawnTab.getLoadPawnSkins()) {
            try {
                BufferedImage imageFile = ImageIO.read(ClassLoader.getSystemResource(pawnSkin));
                BufferedImage resized = resize(imageFile, 60, 60);
                pawnTab.setPawnSkinButton(new JLabel(new ImageIcon(resized)));
            } catch (IOException e) {
                System.out.println(e);
            }

            pawnTab.pawnSkinButton.setBackground(Color.GRAY);
            pawnTab.pawnSkinButton.setBorder(pawnButtonBorder);
            pawnTab.pawnSkinButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pawnSelectorPanel.add(pawnTab.pawnSkinButton);
            pawnSelectorPanel.add(Box.createRigidArea(new Dimension(20, 0)));

            pawnTab.pawnSkinButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    player.setPlayerPawn(pawnSkin);
                    emptySpace.setVisible(true);
                    nextButton.setVisible(true);
                }
            });
        }
        pawnSelectorPanel.add(Box.createHorizontalGlue());
        //pawnSelectorPanel.revalidate();
        //pawnSelectorPanel.repaint();
    }
    
    private static void removePawnSkins(PawnSelectorTab pawnTab, JPanel pawnSelectorPanel, JPanel pawnSelectorTab) {
        int pawnCount = 0;

        //check if arraylist contains images
        for (String pawnSkin : pawnTab.getLoadPawnSkins()) {
            pawnCount++;
        }

        //if it has elements, remove the contents of pawn player panel
        if ( pawnCount != 0 ){
            pawnSelectorTab.remove(pawnSelectorPanel);
            pawnSelectorPanel.removeAll();
            pawnSelectorTab.revalidate();
            pawnSelectorTab.repaint();
        }
    }
}
