/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import static com.ludogame.gamefunctionality.ConnectServer.sendToServer;

import static com.ludogame.gamegui.GuiTools.getResourceFolderFiles;
import static com.ludogame.gamegui.GuiTools.resize;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Ody
 */
public class GameGui 
{    
    public static void createGui()
    {
        JFrame gui       = new JFrame();
        TopMenu topBar   = new TopMenu();
        JTabbedPane tabs = new JTabbedPane();
        
        gui.setJMenuBar(topBar.createMenuBar());
	gui.setTitle("Γκρινιάρης");
        gui.setPreferredSize(new Dimension(1200, 900));        
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //populate the gui panes
        mainMenuTab(tabs, gui);
        PawnSelectorTab.pawnSelectorTab(tabs);
        inGameTab(tabs);
        
        gui.add(tabs);
    }

    
    private static void mainMenuTab(JTabbedPane tabs, JFrame gui)
    {
        JPanel mainMenu             = new JPanel();
        Border mainMenuButtonBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        JLabel connectionButton     = new JLabel("  Συμμετοχή σε παιχνίδι  ");
        JLabel settingsButton       = new JLabel("  Ρυθμίσεις  ");
        JLabel exitButton           = new JLabel("  Έξοδος  ");
        List<JLabel> menuButtons    = new ArrayList<JLabel>();
        
        /*add JLabels here*/
        menuButtons.add(connectionButton);
        menuButtons.add(settingsButton);
        menuButtons.add(exitButton);
      
        /*main menu panel attributes*/
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));
        mainMenu.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
        mainMenu.setBackground(Color.GRAY);
        
        /*start populating mainmenu pane*/
        mainMenu.add(Box.createVerticalGlue());
        for (JLabel menuButton : menuButtons)
        {
            menuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            menuButton.setAlignmentX(CENTER_ALIGNMENT);
            menuButton.setFont(new Font("Serif", Font.BOLD, 30));
            menuButton.setBorder(mainMenuButtonBorder);
            
            mainMenu.add(menuButton);
            mainMenu.add(Box.createRigidArea(new Dimension(0,10)));
        }
        mainMenu.add(Box.createVerticalGlue());
        
        /*add button listeners here*/
        connectionButton.addMouseListener(new MouseAdapter()  
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
              /*2*/
              tabs.setEnabledAt(0, false);
              tabs.setEnabledAt(1, true);

              sendToServer("INCOMING CONNECTION");
              tabs.setSelectedIndex(1);      
            } 
        });
        
        exitButton.addMouseListener(new MouseAdapter()  
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gui.dispose();
            } 
        });
        
        tabs.addTab("Αρχικό μενού", mainMenu);
    }

    private static void inGameTab(JTabbedPane tabs)
    {
        JPanel inGameTab = new JPanel();
        BoardButtons board = new BoardButtons();
        MenuPanel panel = new MenuPanel();
        
        //edw ehw kanei kati allages gia na ta fortwnei apo ti methodo tis klassis
        inGameTab.add(board.createButtons(),BorderLayout.CENTER);
        inGameTab.add(panel.createMenu(), BorderLayout.LINE_END);
        
        
        tabs.addTab("Παιχνίδι", inGameTab);
        /*1*/
        tabs.setEnabledAt(1, false);
        tabs.setEnabledAt(2, false);
    }
}
