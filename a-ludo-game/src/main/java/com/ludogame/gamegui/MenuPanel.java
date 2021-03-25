/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import com.ludogame.gameentities.Die;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author obie
 */
public class MenuPanel {
        public JPanel createMenu(){
            
         
            
        JPanel diePane = new DiePanel();
        
                
        return(diePane);
    }
}
