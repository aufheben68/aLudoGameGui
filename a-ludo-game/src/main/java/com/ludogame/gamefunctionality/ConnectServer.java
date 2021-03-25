/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ludogame.gamefunctionality;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Gorj
 */
public class ConnectServer {
            
    public static void sendToServer(String data) {
        try (Socket echoSocket = new Socket("localhost", 7777);
                PrintWriter toServer = new PrintWriter(echoSocket.getOutputStream(), true);
                Scanner fromServer = new Scanner(echoSocket.getInputStream())) {
                toServer.println(data);
                System.out.println(fromServer.nextLine());
                
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
