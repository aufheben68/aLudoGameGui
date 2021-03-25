/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gameentities;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
/**
 *
 * @author Gorj
 */
public class Player {

    private String playerName;
    private String playerPawn;   //pawn skin absolute path
    private String playerColor;

    private ArrayList<Pawn> pawnsControl = new ArrayList<Pawn>();

    public ArrayList<Pawn> getPawnsControl() {
        return pawnsControl;
    }

    public void setPawnsControl(ArrayList<Pawn> pawnsControl) {
        this.pawnsControl = pawnsControl;
    }
                
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPawn() {
        return playerPawn;
    }

    public void setPlayerPawn(String playerPawn) {
        this.playerPawn = playerPawn;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}
