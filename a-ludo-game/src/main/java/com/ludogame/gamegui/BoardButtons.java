/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import com.ludogame.gameentities.Player;
import com.ludogame.gamefunctionality.Block;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author obie
 */
public class BoardButtons {

    ArrayList<Block> blockList = new ArrayList<Block>();
    
    public ArrayList<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(ArrayList<Block> blockList) {
        this.blockList = blockList;
    }

    public JPanel createButtons() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        int id = 0;

        //kokkini diadromi
        JPanel redTraversal = new JPanel(new GridLayout(6, 3));
        redTraversal.setPreferredSize(new Dimension(3 * 50, 6 * 50));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                id++;
                Block redButton = new Block(id);
                redTraversal.add(redButton);
                if ((i == 1 && j == 5) || (i == 1 && j == 6)) {
                    redButton.setBackground(Color.RED);
                } else if ((i == 2 && j == 2) || (i == 2 && j == 5)) {
                    redButton.setBackground(Color.RED);
                } else if ((i == 3 && j == 2) || (i == 3 && j == 5)) {
                    redButton.setBackground(Color.RED);
                } else if ((i == 2 && j == 4)) {
                    try {
                        ImageIcon pinkCircle = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pink_circle/pink_circle.png")));
                        Image image = pinkCircle.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        pinkCircle = new ImageIcon(newimg);
                        redButton.setIcon(pinkCircle);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                } else if ((i == 3 && j == 3)) {
                    try {
                        ImageIcon star = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("star/gold_star.png")));
                        Image image = star.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        star = new ImageIcon(newimg);
                        redButton.setIcon(star);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        JPanel redTraversalPanel = new JPanel(new GridBagLayout());
        redTraversalPanel.add(redTraversal);

        GridBagConstraints sC = new GridBagConstraints();
        sC.gridx = 6;
        sC.gridy = 6;
        mainPanel.add(redTraversalPanel, sC);

        JPanel blueTraversal = new JPanel(new GridLayout(3, 6));
        blueTraversal.setPreferredSize(new Dimension(6 * 50, 3 * 50));
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton blueButton = new Block(id);
                blueTraversal.add(blueButton);
                if (j == 2 && i == 6) {
                    blueButton.setBackground(Color.BLUE);
                } else if ((j == 2 && i == 4 || (j == 3 && i == 3) || (j == 1 && i == 4) || (j == 1 && i == 3) || (j == 2 && i == 3))) {
                    blueButton.setBackground(Color.BLUE);
                } else if ((j == 3 && i == 1)) {
                    try {
                        ImageIcon pinkCircle = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pink_circle/pink_circle.png")));
                        Image image = pinkCircle.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        pinkCircle = new ImageIcon(newimg);
                        blueButton.setIcon(pinkCircle);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                } else if ((j == 2 && i == 5)) {
                    try {
                        ImageIcon star = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("star/gold_star.png")));
                        Image image = star.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        star = new ImageIcon(newimg);
                        blueButton.setIcon(star);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        JPanel blueTraversalPanel = new JPanel(new GridBagLayout());

        blueTraversalPanel.add(blueTraversal);
        GridBagConstraints sC3 = new GridBagConstraints();
        sC3.gridx = 9;
        sC3.gridy = 10;

        mainPanel.add(blueTraversalPanel, sC3);

        //mple diadromi
        JPanel yellowTraversal = new JPanel(new GridLayout(6, 3));
        yellowTraversal.setPreferredSize(new Dimension(3 * 50, 6 * 50));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                id++;
                JButton yellowButton = new Block(id);
                yellowTraversal.add(yellowButton);
                if ((i == 1 && j == 2) || (i == 1 && j == 5)) {
                    yellowButton.setBackground(Color.YELLOW);
                } else if ((i == 2 && j == 2) || (i == 2 && j == 5)) {
                    yellowButton.setBackground(Color.YELLOW);
                } else if ((i == 3 && j == 2) || (i == 3 && j == 1)) {
                    yellowButton.setBackground(Color.YELLOW);
                } else if ((i == 2 && j == 3)) {
                    try {
                        ImageIcon pinkCircle = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pink_circle/pink_circle.png")));
                        Image image = pinkCircle.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        pinkCircle = new ImageIcon(newimg);
                        yellowButton.setIcon(pinkCircle);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                } else if ((i == 1 && j == 4)) {
                    try {
                        ImageIcon star = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("star/gold_star.png")));
                        Image image = star.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        star = new ImageIcon(newimg);
                        yellowButton.setIcon(star);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }

            }
        }

        JPanel yellowTraversalPanel = new JPanel(new GridBagLayout());
        yellowTraversalPanel.add(yellowTraversal);

        GridBagConstraints sC1 = new GridBagConstraints();
        sC1.gridx = 6;
        sC1.gridy = 12;

        mainPanel.add(yellowTraversalPanel, sC1);

        JPanel greenTraversal = new JPanel(new GridLayout(3, 6));
        greenTraversal.setPreferredSize(new Dimension(6 * 50, 3 * 50));
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton greenButton = new Block(id);
                greenTraversal.add(greenButton);
                if ((j == 2 && i == 1)) {
                    greenButton.setBackground(Color.GREEN);
                } else if ((j == 2 && i == 4) || (j == 3 && i == 3) || (j == 3 && i == 4) || (j == 1 && i == 4) || (j == 2 && i == 3)) {
                    greenButton.setBackground(Color.GREEN);
                } else if ((j == 1 && i == 6)) {
                    try {
                        ImageIcon pinkCircle = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pink_circle/pink_circle.png")));
                        Image image = pinkCircle.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        pinkCircle = new ImageIcon(newimg);
                        greenButton.setIcon(pinkCircle);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                } else if ((j == 2 && i == 2)) {
                    try {
                        ImageIcon star = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("star/gold_star.png")));
                        Image image = star.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        star = new ImageIcon(newimg);
                        greenButton.setIcon(star);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }

            }
        }

        JPanel greenTraversalPanel = new JPanel(new GridBagLayout());

        greenTraversalPanel.add(greenTraversal);
        GridBagConstraints sC2 = new GridBagConstraints();
        sC2.gridx = 0;
        sC2.gridy = 10;

        mainPanel.add(greenTraversalPanel, sC2);

        //TA PANELS STIS GWNIES POU MPENOUN TA ARXIKA KOUMPIA
        //TODO vale ta blocks se ena arraylist
        JPanel kitrino = new JPanel(new GridBagLayout());
        kitrino.setPreferredSize(new Dimension(300, 300));
        kitrino.setBackground(Color.YELLOW);
        GridBagConstraints sKitrino = new GridBagConstraints();
        sKitrino.gridx = 0;
        sKitrino.gridy = 12;
        //Ta kitrina koumpia ekkinisis pou prosartontai sto Panel
        JPanel kitrinoStart = new JPanel(new GridLayout(3, 6));
        kitrinoStart.setPreferredSize(new Dimension(200, 200));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton aButton = new Block(id);
                kitrinoStart.add(aButton);
                if ((i == 1 && j == 1) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 && j == 1) || (i == 3 && j == 3)) {
                    aButton.setBackground(Color.YELLOW);
                    aButton.setEnabled(false);
                } else {
                    try {
                        //TODO Deserialize jsons from server to objects
                        //ImageIcon yellowPawn = new ImageIcon(ImageIO.read(ClassLoader.getSystemResource(playerYellow.getPlayerPawn()));
                        ImageIcon yellowPawn = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pawn_skins/yellow_pawn/yellow_pawn.png")));
                        Image image = yellowPawn.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        yellowPawn = new ImageIcon(newimg);
                        aButton.setIcon(yellowPawn);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        kitrino.add(kitrinoStart);

        mainPanel.add(kitrino, sKitrino);

        JPanel kokkino = new JPanel(new GridBagLayout());
        kokkino.setPreferredSize(new Dimension(300, 300));
        kokkino.setBackground(Color.RED);
        GridBagConstraints sKokkino = new GridBagConstraints();
        sKokkino.gridx = 9;
        sKokkino.gridy = 6;
        //Ta kokkina koumpia ekkinisi pou prosartontai sto kokkino Panel
        JPanel kokkinoStart = new JPanel(new GridLayout(3, 6));
        kokkinoStart.setPreferredSize(new Dimension(200, 200));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton aButton = new Block(id);
                kokkinoStart.add(aButton);
                if ((i == 1 && j == 1) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 && j == 1) || (i == 3 && j == 3)) {
                    aButton.setBackground(Color.RED);
                    aButton.setEnabled(false);
                } else {
                    try {
                        ImageIcon redPawn = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pawn_skins/red_pawn/red_pawn.png")));
                        Image image = redPawn.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        redPawn = new ImageIcon(newimg);
                        aButton.setIcon(redPawn);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        kokkino.add(kokkinoStart);

        mainPanel.add(kokkino, sKokkino);

        JPanel mple = new JPanel(new GridBagLayout());
        mple.setPreferredSize(new Dimension(300, 300));
        mple.setBackground(Color.BLUE);
        GridBagConstraints sMple = new GridBagConstraints();
        sMple.gridx = 9;
        sMple.gridy = 12;
        //Ta mple koumpia ekkinisis
        JPanel mpleStart = new JPanel(new GridLayout(3, 6));
        mpleStart.setPreferredSize(new Dimension(200, 200));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton aButton = new Block(id);
                mpleStart.add(aButton);
                if ((i == 1 && j == 1) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 && j == 1) || (i == 3 && j == 3)) {
                    aButton.setBackground(Color.BLUE);
                    aButton.setEnabled(false);
                } else {
                    try {
                        ImageIcon bluePawn = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pawn_skins/blue_pawn/blue_pawn.png")));
                        Image image = bluePawn.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        bluePawn = new ImageIcon(newimg);
                        aButton.setIcon(bluePawn);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        mple.add(mpleStart);

        mainPanel.add(mple, sMple);

        JPanel prasino = new JPanel(new GridBagLayout());
        prasino.setPreferredSize(new Dimension(300, 300));
        prasino.setBackground(Color.GREEN);
        GridBagConstraints sPrasino = new GridBagConstraints();
        sPrasino.gridx = 0;
        sPrasino.gridy = 6;
        //Ta prasina koumpia ekkinisis
        JPanel prasinoStart = new JPanel(new GridLayout(3, 6));
        prasinoStart.setPreferredSize(new Dimension(200, 200));
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                id++;
                JButton aButton = new Block(id);
                prasinoStart.add(aButton);
                if ((i == 1 && j == 1) || (i == 1 && j == 3) || (i == 2 && j == 2) || (i == 3 && j == 1) || (i == 3 && j == 3)) {
                    aButton.setBackground(Color.GREEN);
                    aButton.setEnabled(false);
                } else {
                    try {
                        ImageIcon greenPawn = new ImageIcon(ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("pawn_skins/green_pawn/green_pawn.png")));
                        Image image = greenPawn.getImage(); // transform it 
                        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
                        greenPawn = new ImageIcon(newimg);
                        aButton.setIcon(greenPawn);
                    } catch (IOException e) {
                        System.out.println("unable to locate image");
                    }
                }
            }
        }

        prasino.add(prasinoStart);

        mainPanel.add(prasino, sPrasino);

        //Prasino Trigwniko Koumpi
        JPanel prasinoTrigwno = new JPanel(new GridBagLayout());
        TriangleButtonZ triangleButton1 = new TriangleButtonZ(0, 50, 100, GREEN);
        triangleButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Green!");
            }
        });
        triangleButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbd1 = new GridBagConstraints();
        gbd1.insets = new Insets(0, 0, 0, 0);
        gbd1.gridx = 6;
        gbd1.gridy = 10;
        prasinoTrigwno.add(triangleButton1);
        mainPanel.add(prasinoTrigwno, gbd1);

        JPanel kokkinoTrigwno = new JPanel(new GridBagLayout());
        TriangleButtonZRotated triangleButton2 = new TriangleButtonZRotated(0, 50, 100, RED);
        triangleButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("RED!");
            }
        });
        triangleButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbd2 = new GridBagConstraints();
        gbd2.insets = new Insets(0, 10, 10, 0);
        gbd2.gridx = 6;
        gbd2.gridy = 10;
        kokkinoTrigwno.add(triangleButton2);
        mainPanel.add(kokkinoTrigwno, gbd2);

        JPanel mpleTrigwno = new JPanel(new GridBagLayout());
        TriangleButtonZ triangleButton3 = new TriangleButtonZ(100, 50, 0, BLUE);
        triangleButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("BLUE!");
            }
        });
        triangleButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbd3 = new GridBagConstraints();
        gbd3.insets = new Insets(0, 20, 0, 0);
        gbd3.gridx = 6;
        gbd3.gridy = 10;
        mpleTrigwno.add(triangleButton3);
        mainPanel.add(mpleTrigwno, gbd3);

        JPanel kitrinoTrigwno = new JPanel(new GridBagLayout());
        TriangleButtonZRotated triangleButton4 = new TriangleButtonZRotated(100, 50, 0, YELLOW);
        triangleButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("YELLOW!");
            }
        });
        triangleButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints gbd4 = new GridBagConstraints();
        gbd4.insets = new Insets(10, 10, 0, 0);
        gbd4.gridx = 6;
        gbd4.gridy = 10;
        kitrinoTrigwno.add(triangleButton4);
        mainPanel.add(kitrinoTrigwno, gbd4);

        //return to tablo tou paixnidiou
        return (mainPanel);

    }

}
