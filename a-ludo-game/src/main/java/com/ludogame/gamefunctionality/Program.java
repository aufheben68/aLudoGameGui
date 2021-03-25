/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamefunctionality;

import com.ludogame.gamegui.GameGui;
import javax.swing.SwingUtilities;

/**
 *
 * @author Gorj
 */
public class Program
{    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {    
            public void run() 
            {
                GameGui.createGui();
            }
        });
    }
}

