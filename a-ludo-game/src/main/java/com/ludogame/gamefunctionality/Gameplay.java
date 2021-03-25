/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamefunctionality;

import com.ludogame.gameentities.Die;
import com.ludogame.gameentities.Player;

/**
 *
 * @author Gorj
 */
public class Gameplay {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void play() {
        Die die = new Die();
        
    }
    
}
