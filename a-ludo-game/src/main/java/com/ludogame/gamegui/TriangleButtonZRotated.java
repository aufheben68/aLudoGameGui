/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author Ody
 */
    
    
    public class TriangleButtonZRotated extends JPanel {

    private int x;
    private int y;
    private int z;
    private Color color;
    
    public TriangleButtonZRotated(int x,int z,int y,Color color) {
        this.x=x;
        this.y=y;
        this.z=z;
        this.color=color;
    }
    
    @Override
    public void paintBorder( Graphics g ) {
            Polygon p = new Polygon();
            p.addPoint( x,x );
            p.addPoint( x,y );
            p.addPoint( z,z ); 
            ((Graphics2D)g).setPaint(color);
            ((Graphics2D)g).setBackground(color);
            ((Graphics2D)g).draw(p);
    }
    
   
    @Override
    public void paintComponent( Graphics g) {
            Polygon p = new Polygon();
            p.addPoint( x,x );
            p.addPoint( x,y );
            p.addPoint( z,z ); 
            int x1 = this.getWidth() / 2;
            int y1 = this.getHeight() / 2;
            ((Graphics2D)g).rotate(Math.toRadians(90.0), x1, y1);
            ((Graphics2D)g).setPaint(color);
            ((Graphics2D)g).setBackground(color);   
            ((Graphics2D)g).fill(p);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100,100);
    }
    
    
   }
    