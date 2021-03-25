/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamefunctionality;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Gorj
 */
public class Block extends JButton{
    private int id;

    public int getId() {
        return id;
    }
    
    public Block(int id){
        this.id = id;
        
        this.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
                System.out.println("Id: " + getId());
            }
        });
    }
    
    @Override
    public String toString(){
        return ("id: " + this.id);
    }
}
