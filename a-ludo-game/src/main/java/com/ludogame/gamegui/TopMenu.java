/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ody
 */
public class TopMenu {
    JTextArea output;
    JScrollPane scrollPane;
 
    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu,menu2;
        JMenuItem menuItem;
 
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Παιχνίδι");
        menu.getAccessibleContext();
        menuBar.add(menu);
 
        //h epilogi tou na summetasxei se paixnidi
        menuItem = new JMenuItem("Συμμετοχή σε παιχνίδι");
        menu.add(menuItem);
 
        //h epilogi tou na diakopsei to paixnidi
        menuItem = new JMenuItem("Διακοπή παιχνιδιού");
        menu.add(menuItem);
        
        //h epilogi tou na kleisei to programma
        menuItem = new JMenuItem("Έξοδος");
        menu.add(menuItem);
       
 
        //Build second menu in the menu bar.
        menu2 = new JMenu("Βοήθεια");
        menu2.getAccessibleContext();
        menuBar.add(menu2);
        
        //h epilogi tis voitheias me kana pop-up menu logika
        menuItem = new JMenuItem("Βοήθεια");
        menu2.add(menuItem);
        
        //h epilogi "sxetika me ton gkriniari"
        menuItem = new JMenuItem("Σχετικά με τον 'Γκρινιάρη' ");
        menu2.add(menuItem);
 
        return menuBar;
    }

}
