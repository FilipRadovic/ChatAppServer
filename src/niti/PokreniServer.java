/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frado
 */
public class PokreniServer extends Thread{
    
    private ServerSocket serverskiSocket;

    public PokreniServer() {
    }
    
    

    @Override
    public void run() {
        try {
            this.serverskiSocket = new ServerSocket(9000);
            while (true) {
                Socket s = serverskiSocket.accept();
                System.out.println("Klijent se povezao!");
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(s);
                nit.start();
                
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerSocket getServerskiSocket() {
        return serverskiSocket;
    }

    public void setServerskiSocket(ServerSocket serverskiSocket) {
        this.serverskiSocket = serverskiSocket;
    }
    
    
    
}
