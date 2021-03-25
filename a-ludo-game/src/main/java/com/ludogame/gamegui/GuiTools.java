/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamegui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Gorj
 */
public class GuiTools {

    public static BufferedImage resize(BufferedImage img, int height, int width)
    {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    
    public static ArrayList<String> getResourceFolderFiles(String folderPath)
    {
        ArrayList<String> listedFiles = new ArrayList<String>();

        for (File fileToLoad : getResourceFolderFilePaths(folderPath))
        {
            String fileToLoadPath = fileToLoad.getAbsolutePath();

            fileToLoadPath = fileToLoadPath.replaceAll(".*target.classes.", "");
            listedFiles.add(fileToLoadPath);
        }  
        
        return listedFiles;
    }

    
    private static File[] getResourceFolderFilePaths(String folder) 
    {
        //System.out.println(folder);
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url            = loader.getResource(folder);
        //System.out.println(url);
        String path        = url.getPath();
        
        return new File(path).listFiles();
    }
}
