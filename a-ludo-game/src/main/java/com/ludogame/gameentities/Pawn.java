/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gameentities;

import java.util.HashMap;

/**
 *
 * @author Gorj
 */
public class Pawn {
    private String pawnId;
    private String pawnColor;
    private int entryPoint;
    private String movingPath;
    private int pawnPosition;
    private HashMap<Integer, Integer> finish = new HashMap<Integer, Integer>();
    
    public int getPawnPosition() {
        return pawnPosition;
    }

    public void setPawnPosition(int pawnPosition) {
        this.pawnPosition = pawnPosition;
    }
    
    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
    }
        
    public String getPawnId() {
        return pawnId;
    }

    public String getPawnColor() {
        return pawnColor;
    }

    public int getEntryPoint() {
        return entryPoint;
    }

    public String getMovingPath() {
        return movingPath;
    }

    public HashMap<Integer, Integer> getFinish() {
        return finish;
    }

    public void setMovingPath(String movingPath) {
        this.movingPath = movingPath;
    }
        
    public void setEntryPoint(int entryPoint) {
        this.entryPoint = entryPoint;
    }
    
    public Pawn(String color, String Id){
        this.pawnColor = color;
        this.pawnId    = Id;
        this.finish    = mapFinish(color);
    }
    
    private HashMap<Integer, Integer> mapFinish(String pawnColor){
        
        HashMap<Integer, Integer> finishPath = new HashMap<Integer, Integer>();
        switch (pawnColor){
            case "red":
                this.setMovingPath("6-9-12-15-18-19-20-21-22-23-24-30-36-35-34-33-32-31-39-42-45-48-51-54-53-52-49-46-43-40-37-72-71-70-69-68-67-61-55-56-57-58-59-60-16-13-10-7-4-1-2-5-8-11-14-17");
                this.setEntryPoint(6);
                this.setPawnPosition(this.getEntryPoint());
                finishPath.put(5,5);
                finishPath.put(8,4);
                finishPath.put(11,3);
                finishPath.put(14,2);
                finishPath.put(17,1);
                break;
            case "blue":
                this.setMovingPath("35-34-33-32-31-39-42-45-48-51-54-53-52-49-46-43-40-37-72-71-70-69-68-67-61-55-56-57-58-59-60-16-13-10-7-4-1-2-3-6-9-12-15-18-19-20-21-22-23-24-30-29-28-27-26-25");
                this.setEntryPoint(35);
                this.setPawnPosition(this.getEntryPoint());
                finishPath.put(29,5);
                finishPath.put(28,4);
                finishPath.put(27,3);
                finishPath.put(26,2);
                finishPath.put(25,1);
                break;
            case "green":
                this.setMovingPath("56-57-58-59-60-16-13-10-7-4-1-2-3-6-9-12-15-18-19-20-21-22-23-24-30-36-35-34-33-32-31-39-42-45-48-51-54-53-52-49-46-43-40-37-72-71-70-69-68-67-61-62-63-64-65-66");
                this.setEntryPoint(56);
                this.setPawnPosition(this.getEntryPoint());
                finishPath.put(62,5);
                finishPath.put(63,4);
                finishPath.put(64,3);
                finishPath.put(65,2);
                finishPath.put(66,1);
                break;
            case "yellow":
                this.setMovingPath("49-46-43-40-37-72-71-70-69-68-67-61-55-56-57-58-59-60-16-13-10-7-4-1-2-3-6-9-12-15-18-19-20-21-22-23-24-30-36-35-34-33-32-31-39-42-45-48-51-54-53-50-47-44-41-38");
                this.setEntryPoint(49);
                this.setPawnPosition(this.getEntryPoint());
                finishPath.put(50,5);
                finishPath.put(47,4);
                finishPath.put(44,3);
                finishPath.put(41,2);
                finishPath.put(38,1);
                break;
        }
        return finishPath;
    }
    
    @Override
    public String toString(){
        return ("entryPoint: " + this.entryPoint +
                "moving path: " + this.movingPath +
                "Id: " + this.pawnId);
    }
}
