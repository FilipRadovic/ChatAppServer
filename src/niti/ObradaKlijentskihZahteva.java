/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Korisnik;
import domen.Poruka;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import logika.Kontroler;
import sun.nio.ch.IOStatus;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author frado
 */
public class ObradaKlijentskihZahteva extends Thread{
    
    Socket s;

    public ObradaKlijentskihZahteva(Socket socket) {
        s = socket;
    }
    

    @Override
    public void run() {
        while (true) {            
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            switch(kz.getOperacije()){
                case Operacije.LOGIN:
                    HashMap<Integer, String> mapa = (HashMap<Integer, String>) kz.getParametar();
                    String username = mapa.get(1);
                    String password = mapa.get(2);
                    Korisnik k = Kontroler.getInstance().login(username, password);
                    so.setOdgovor(k);
                    break;
                    
                case Operacije.VRATI_ULOGOVANE:
                    ArrayList<Korisnik> ulogovaniKorisnici = Kontroler.getInstance().getUlogovaniKorisnici();
                    so.setOdgovor(ulogovaniKorisnici);
                    break;
                    
                case Operacije.VRATI_PORUKE:
                    Korisnik korisnik = (Korisnik) kz.getParametar();
                    ArrayList<Poruka> poruke = Kontroler.getInstance().vratiPorukeZaKorisnika(korisnik);
                    so.setOdgovor(poruke);
                    break;
                    
                case Operacije.SACUVAJ_PORUKU:
                    Poruka p = (Poruka) kz.getParametar();
                    boolean uspesno = Kontroler.getInstance().sacuvajPoruku(p);
                    so.setOdgovor(uspesno);
                    break;
                
            }
            
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void posaljiOdgovor(ServerskiOdgovor so) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
